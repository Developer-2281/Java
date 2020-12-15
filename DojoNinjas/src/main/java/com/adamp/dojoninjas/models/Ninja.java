package com.adamp.dojoninjas.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table
public class Ninja {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Size(min = 2, max = 255, message = "Must be at least 2 characters and not more than 255`")
	private String first_name;
	@Size(min = 2, max = 255, message = "Must be at least 2 characters and not more than 255`")
	private String last_name;
	@NotNull(message="Must enter an age") @Min(value=18, message = "Must be at least 18") @Max(value=99, message = "Cannot be older than 100")
	private Integer age;
	// This will not allow the createdAt column to be updated after creation
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	// Many to One Relationship			***Remember to Set getters and setters after adding relationships
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="dojo_id")
	private Dojo dojo;
	
	//always add an empty constructor
	public Ninja() {
	}

	public Ninja(Long id,
			@Size(min = 2, max = 255, message = "Must be at least 2 characters and not more than 255`") String fname,
			@Size(min = 2, max = 255, message = "Must be at least 2 characters and not more than 255`") String lname,
			@NotNull(message = "Must enter an age") @Min(value = 18, message = "Must be at least 18") @Max(value = 99, message = "Cannot be older than 100") Integer age) {
		super();
		this.id = id;
		this.first_name = fname;
		this.last_name = lname;
		this.age = age;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String fname) {
		this.first_name = fname;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String lname) {
		this.last_name = lname;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
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

	public Dojo getDojo() {
		return dojo;
	}

	public void setDojo(Dojo dojo) {
		this.dojo = dojo;
	}
}
