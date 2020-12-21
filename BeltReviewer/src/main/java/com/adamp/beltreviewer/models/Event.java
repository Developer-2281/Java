package com.adamp.beltreviewer.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="events")
public class Event {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @NotNull(message="Please enter a name")@Size(min=3, max=20, message="Name must be 2 to 25 characters") 
    private String name;
    @NotNull(message="Must enter an event date")
    @Future(message="Date must be in the future") @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date event_date;
    @NotNull(message="Please enter a location") @Size(min=3, max=20, message="Location should be three to twenty characters")
    private String location;
    @NotNull(message="Please enter a State") @Size(min=2, max=2, message="Must be 2 characters")
    private String state;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;

    //Relationships

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
	    name = "user_events",
	    joinColumns = @JoinColumn(name = "event_id"),
	    inverseJoinColumns = @JoinColumn(name = "user_id") //maybe avoid duplicate name as one to one
    )
    private List<User> hostedEvents; //should have named this joined events
    //Make sure the list reflects the many relationship, should not have same name as this model
    
    
    @ManyToOne(fetch=FetchType.LAZY) //Creating many to one
    @JoinColumn(name="users_id")  // Foreign Key
    private User host;
    
    @OneToMany(mappedBy="wall", fetch = FetchType.LAZY)
    private List<Message> wallMessages;
    
    public Event() {
    }

	public Event(Long id,
			@NotNull(message = "Please enter a name") @Size(min = 3, max = 20, message = "Name must be 2 to 25 characters") String name,
			@NotNull(message = "Must enter an event date") @Future(message = "Date must be in the future") Date event_date,
			@NotNull(message = "Please enter a location") @Size(min = 3, max = 20, message = "Location should be three to twenty characters") String location,
			@NotNull(message = "Please enter a State") @Size(min = 2, max = 2, message = "Must be 2 characters") String state,
			List<User> hostedEvents, User host, List<Message> wallMessages) {
		super();
		this.id = id;
		this.name = name;
		this.event_date = event_date;
		this.location = location;
		this.state = state;
		this.hostedEvents = hostedEvents;
		this.host = host;
		this.wallMessages = wallMessages;
	}

	public List<Message> getWallMessages() {
		return wallMessages;
	}

	public void setWallMessages(List<Message> wallMessages) {
		this.wallMessages = wallMessages;
	}

	public List<User> getHostedEvents() {
		return hostedEvents;
	}

	public void setHostedEvents(List<User> hostedEvents) {
		this.hostedEvents = hostedEvents;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getEvent_date() {
		return event_date;
	}

	public void setEvent_date(Date event_date) {
		this.event_date = event_date;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
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

	public User getHost() {
		return host;
	}

	public void setHost(User host) {
		this.host = host;
	}
}