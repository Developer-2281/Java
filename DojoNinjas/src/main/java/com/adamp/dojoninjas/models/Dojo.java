package com.adamp.dojoninjas.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table
public class Dojo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Size(min = 2, max = 255, message = "Must be at least 2 characters and not more than 255")
	private String name;
	
	// One to Many Relationship
	@OneToMany(mappedBy= "dojo", fetch  = FetchType.LAZY)
	private List<Ninja> ninjas;
	
	// This will not allow the createdAt column to be updated after creation
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	//always add an empty constructor
	
	public Dojo() {
	}
	
	
	public Dojo(Long id,
			@Size(min = 2, max = 255, message = "Must be at least 2 characters and not more than 255`") String name) {
		super();
		this.id = id;
		this.name = name;
	}

	// Getter & setter for relationship
	public List<Ninja> getNinjas() {
		return ninjas;
	}


	public void setNinjas(List<Ninja> ninjas) {
		this.ninjas = ninjas;
	}


	//Remember to always add these two
	@PrePersist
	protected void onCreate(){
		this.createdAt = new Date();
    }

	@PreUpdate
    protected void onUpdate(){
    	this.updatedAt = new Date();
	}
    //	


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
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
	
}
