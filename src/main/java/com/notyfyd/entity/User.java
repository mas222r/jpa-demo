package com.notyfyd.entity;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
@Entity
@Table(name = "t_user")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected String firstName;
    protected String lastName;
    protected String mobile;
    protected String email;
    
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(foreignKey = @ForeignKey(name = "role_id_fk"),nullable=false)//foreignKey = @ForeignKey(name = "role_id_fk")
    @JsonBackReference   
    protected Role fkUserRole;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
	public Role getFkUserRole() {
		return fkUserRole;
	}
	public void setFkUserRole(Role fkUserRole) {
		this.fkUserRole = fkUserRole;
	}
	
	
    
}