package elaundry.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import elaundry.clients.model.Clients;
import elaundry.tech.model.Technician;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

//@NamedQueries({ 
//			@NamedQuery(
//					name = User.NQ_ALL, 
//					query = "FROM User u"
//			
//			), 
//			@NamedQuery(
//					name = User.NQ_FINDBYID, 
//					query = "FROM User u WHERE u.id =:id"
//			) 
//		})
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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "usertype")
    private String usertype;

    @ManyToOne
    private Clients clientId;

    @ManyToOne
    private Technician techId;
    public String getUsertype() {
        return usertype;
    }
    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }
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
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @JsonIgnore
    public String getJson() {
        StringBuilder sb = new StringBuilder();
        sb.append("{")
                .append("\"id\": \"").append(getId()).append("\",")
                .append("\"fullname\": \"").append(getFullname()).append("\",")
                .append("\"username\": \"").append(getUsername()).append("\",")
                .append("\"password\": \"").append(getPassword()).append("\",")
                .append("\"usertype\": \"").append(getUsertype()).append("\",")
                .append("\"email\":\"").append(getEmail()).append("\"");
        sb.append("}");
        return sb.toString();
    }

}
