package elaundry.user.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@NamedQueries({ 
			@NamedQuery(
					name = User.NQ_ALL, 
					query = "FROM User u"
			
			), 
			@NamedQuery(
					name = User.NQ_FINDBYID, 
					query = "FROM User u WHERE u.id =:id"
			) 
		})
@Entity
@Table(name = "users")
@XmlRootElement
@JsonInclude(Include.NON_EMPTY)
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Transient
	public static final String NQ_ALL = "User.All";
	
	@Transient
	public static final String NQ_FINDBYID = "User.findById";

	@Id@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "fullname")
	private String fullname;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
