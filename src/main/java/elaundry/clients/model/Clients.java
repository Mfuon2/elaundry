package elaundry.clients.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;
import elaundry.user.model.User;

@Entity
@Table(name = "clients")
@XmlRootElement
public class Clients implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "clientId")
    private String clientid;

    @Column(name = "nationalid")
    private String nationalid;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_no")
    private String phoneNo;

    @OneToMany(mappedBy = "clientId", cascade = CascadeType.ALL)
    private Set<User> users;

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

    public String getClientid() {
        return clientid;
    }

    public void setClientid(String clientid) {
        this.clientid = clientid;
    }

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

    public String getNationalid() {
        return nationalid;
    }

    public void setNationalid(String nationalid) {
        this.nationalid = nationalid;
    }


    @JsonIgnore
    public String getJson() {
        StringBuilder sb = new StringBuilder();
        sb.append("{")
                .append("\"id\": \"").append(getId()).append("\",")
                .append("\"fullname\": \"").append(getFullname()).append("\",")
                .append("\"clientid\": \"").append(getClientid()).append("\",")
                .append("\"nationalid\": \"").append(getNationalid()).append("\",")
                .append("\"phoneNo\": \"").append(getPhoneNo()).append("\",")
                .append("\"email\": \"").append(getEmail()).append("\"");

        sb.append("}");

        return sb.toString();

    }


}
