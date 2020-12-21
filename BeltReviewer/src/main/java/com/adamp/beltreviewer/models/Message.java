package com.adamp.beltreviewer.models;

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
import javax.validation.constraints.NotNull;

@Entity
@Table(name="messages")
public class Message {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @NotNull(message="Message cannot be blank")
    private String msg_text;

    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    // Relationships
    @ManyToOne(fetch=FetchType.LAZY) //Creating one to many
    @JoinColumn(name="user_id")  // Foreign Key
    private User poster;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="event_id") // Foreign Key
    private Event wall;
    
    public Message() {
	
    }

	public Message(Long id, @NotNull(message = "Message cannot be blank") String msg_text, User poster, Event wall) {
		super();
		this.id = id;
		this.msg_text = msg_text;
		this.poster = poster;
		this.wall = wall;
	}


	public Event getWall() {
		return wall;
	}

	public void setWall(Event wall) {
		this.wall = wall;
	}

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


	public String getMsg_text() {
		return msg_text;
	}


	public void setMsg_text(String msg_text) {
		this.msg_text = msg_text;
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


	public User getPoster() {
		return poster;
	}


	public void setPoster(User poster) {
		this.poster = poster;
	}

    
}