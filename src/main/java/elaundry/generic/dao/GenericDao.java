package elaundry.generic.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class GenericDao<T, ID extends Serializable> implements GenericDaoI<T, ID> {

	private final Class<T> persistentClass;
	
	protected EntityManager em;
	
	public void setEm(EntityManager em){
		this.em = em;
	}
	
	public EntityManager getEm() {
		return this.em;	
	}
	@SuppressWarnings("unchecked")
	public GenericDao(){
		this.persistentClass = (Class<T>)((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public GenericDao(final Class<T> persistentClass){
		super();
		this.persistentClass = persistentClass;
		
	}
	public T save(T entity){
		return em.merge(entity);
	}
	
	@SuppressWarnings("unchecked")
	public List<T> list(T filter){
		return em.createQuery("from " + persistentClass.getName() + " t").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<T> list(Map<String, Object> filter){
		StringBuilder sb = new StringBuilder();
		sb.append("from ")
			.append(persistentClass.getName())
			.append(" t where t.id is not null");
		
		for(Map.Entry<String, Object> entry : filter.entrySet()){
			sb.append(" and t.").append(entry.getKey())
				.append("=:").append(entry.getKey());
		}
		
		Query query = em.createQuery(sb.toString());
		for(Map.Entry<String, Object> entry : filter.entrySet())
			query.setParameter(entry.getKey(), entry.getValue());
		
		return query.getResultList();
	}
	
	public void delete(ID id){
		em.remove(em.find(persistentClass, id));
	}
	
	public T findById(ID id){
		return em.find(persistentClass, id);
	}
	
	@SuppressWarnings("rawtypes")
	public int countAll(){
		List result =  em.createQuery("select count(t.id) from " + persistentClass.getName() 
				+ " t").getResultList();
		
		return ((Long) result.get(0)).intValue();
		
	}
}
