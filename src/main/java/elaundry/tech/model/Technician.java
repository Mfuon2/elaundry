package elaundry.tech.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "phone_no")
	private String phoneNo;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

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

	
	@JsonIgnore
	public String getJson(){
		StringBuilder sb = new StringBuilder();
		sb.append("{")
			.append("\"id\": \"").append(getId()).append("\",")
			.append("\"fullname\": \"").append(getFullname()).append("\",")
			.append("\"techid\": \"").append(getTechid()).append("\",")
			.append("\"nationalid\": \"").append(getNationalid()).append("\",")
			.append("\"phoneNo\": \"").append(getPhoneNo()).append("\",")
			.append("\"email\": \"").append(getEmail()).append("\"");;
		
			
		sb.append("}");
		
		return sb.toString();
		
	}
	
	
}
