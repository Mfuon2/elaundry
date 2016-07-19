package elaundry.tech.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import elaundry.common.model.Address;

@Entity
@Table(name = "technician")
public class Technician implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "fullname")
	private String fullname;
	
	@Column(name = "techid")
	private String techid;
	
	@Column(name = "nationalid")
	private Long nationalid;
	
	@Embedded
	private Address address;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getTechid() {
		return techid;
	}

	public void setTechid(String techid) {
		this.techid = techid;
	}

	public Long getNationalid() {
		return nationalid;
	}

	public void setNationalid(Long nationalid) {
		this.nationalid = nationalid;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	@JsonIgnore
	public String getJson(){
		StringBuilder sb = new StringBuilder();
		sb.append("{")
			.append("\"id\": \"").append(getId()).append("\",")
			.append("\"fullname\": \"").append(getFullname()).append("\",")
			.append("\"techid\": \"").append(getTechid()).append("\",")
			.append("\"nationalid\": \"").append(getNationalid()).append("\"");
		
		if(getAddress() != null){
			sb.append(",\"phoneNo\": \"").append(getAddress().getPhoneNo()).append("\",")
			.append("\"email\": \"").append(getAddress().getEmail()).append("\",")
			.append("\"town\": \"").append(getAddress().getTown()).append("\",")
			.append("\"country\": \"").append(getAddress().getCountry()).append("\",")
			.append("\"box\": \"").append(getAddress().getBox()).append("\"");
		}
			
		sb.append("}");
		
		return sb.toString();
		
	}
	
	
}
