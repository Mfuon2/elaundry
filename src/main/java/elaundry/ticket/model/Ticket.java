package elaundry.ticket.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ticket")
public class Ticket implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "reportedby")
	private String reportedby;
	
	@Column(name = "descr", columnDefinition = "TEXT")
	private String descr;
	
	@Column(name = "status")
	//@Formula("(select status from ticket p where p.status = 'open')")
	private String status;
	
	@Column(name = "assign")
	private String assign;
	
	@Column(name = "priority")
	private String priority;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "postdate")
	private Date time;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getReportedby() {
		return reportedby;
	}

	public void setReportedby(String reportedby) {
		this.reportedby = reportedby;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String desc) {
		this.descr = desc;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAssign() {
		return assign;
	}

	public void setAssign(String assign) {
		this.assign = assign;
	}
	
	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	@JsonIgnore
	public String getJson(){
		StringBuilder sb = new StringBuilder();
		sb.append("{")
			.append("\"id\": \"").append(getId()).append("\",")
			.append("\"title\": \"").append(getTitle()).append("\",")
			.append("\"reportedby\": \"").append(getReportedby()).append("\",")
			.append("\"descr\": \"").append(getDescr()).append("\",")
			.append("\"status\": \"").append(getStatus()).append("\",")
		    .append("\"assign\": \"").append(getAssign()).append("\",")
		    .append("\"priority\": \"").append(getPriority()).append("\"");
		
			
		sb.append("}");
		
		return sb.toString();
		
	}
	
	

}