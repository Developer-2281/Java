package com.adamp.authentication.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Email(message="Email must be valid")
    private String email;
    @NotNull(message="Password cannot be blank") @Size(min=8, message="Password must be at least 8 characters") 
    private String password;
    @Transient
    private String passwordConfirmation;
    @Transient
    private String duplicate;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    public User() {
    }

	public User(Long id, @Email(message = "Email must be valid") String email,
			@NotNull(message = "Password cannot be blank") @Size(min = 8, message = "Password must be at least 8 characters") String password) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
	}


	// other getters and setters removed for brevity
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
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


	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}


	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	public Date getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}


	public String getDuplicate() {
		return duplicate;
	}


	public void setDuplicate(String duplicate) {
		this.duplicate = duplicate;
	}
	
}