package com.adamp.lookify.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Songs")
public class Song {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Size(min = 5, max = 20, message = "Must be at least 5 characters and not more than 20")
	private String title;
	@Size(min = 5, max = 20,  message = "Must be at least 5 characters and not more than 20")
	private String artist;
	@NotNull(message="Cannot be empty") @Min(value=1, message = "Must be at least 1") @Max(value=10, message = "Cannot be higher that 10")
	private Integer rating;
	// This will not allow the createdAt column to be updated after creation
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	    
	public Song() {
	}

	@PrePersist
	protected void onCreate(){
		this.createdAt = new Date();
    }
	
    public Song(Long id,
			@Size(min = 5, max = 20, message = "Must be at least 5 characters and not more than 20") String title,
			@Size(min = 5, max = 20, message = "Must be at least 5 characters and not more than 20") String artist,
			@NotNull(message="Cannot be empty") @Min(value=1, message = "Must be at least 1") @Max(value=10, message = "Cannot be higher than 10")Integer rating) {
		super();
		this.id = id;
		this.title = title;
		this.artist = artist;
		this.rating = rating;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
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
