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
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @NotNull(message="Please enter a name")@Size(min=3, max=20, message="First Name must be 3 to 20 characters") 
    private String first_name;
    @NotNull(message="Please enter a name")@Size(min=2, max=20, message="Last Name must be 2-20 characters") 
    private String last_name;
    @NotNull(message="Please enter a location") @Size(min=3, max=20, message="Location should be three to twenty characters")
    private String location;
    @NotNull(message="Please enter a State") @Size(min=2, max=2, message="Must be 2 characters")
    private String State;
    @Email(message="Email must be valid") @NotEmpty(message="Please enter an email")
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
    
    // Relationships
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
	    name = "user_events",
	    joinColumns = @JoinColumn(name = "user_id"),
	    inverseJoinColumns = @JoinColumn(name = "event_id")
    )
    private List<Event> joinedEvents;
    
    @OneToMany(mappedBy="host", fetch = FetchType.LAZY)
    private List<Event> hostedEvents;
    
    @OneToMany(mappedBy="poster", fetch = FetchType.LAZY)
    private List<Message> postedMessages; //postedMessages is variable
    
    public User() {
    }


	public User(Long id,
			@NotNull(message = "Please enter a name") @Size(min = 3, max = 20, message = "First Name must be 3 to 20 characters") String first_name,
			@NotNull(message = "Please enter a name") @Size(min = 2, max = 20, message = "Last Name must be 2-20 characters") String last_name,
			@NotNull(message = "Please enter a location") @Size(min = 3, max = 20, message = "Location should be three to twenty characters") String location,
			@NotNull(message = "Please enter a State") @Size(min = 2, max = 2, message = "Must be 2 characters") String state,
			@Email(message = "Email must be valid") @NotEmpty(message = "Please enter an email") String email,
			@NotNull(message = "Password cannot be blank") @Size(min = 8, message = "Password must be at least 8 characters") String password,
			List<Event> joinedEvents, List<Event> hostedEvents, List<Message> postedMessages) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.location = location;
		State = state;
		this.email = email;
		this.password = password;
		this.joinedEvents = joinedEvents;
		this.hostedEvents = hostedEvents;
		this.postedMessages = postedMessages;
	}


	public List<Event> getHostedEvents() {
		return hostedEvents;
	}


	public void setHostedEvents(List<Event> hostedEvents) {
		this.hostedEvents = hostedEvents;
	}


	public List<Event> getJoinedEvents() {
		return joinedEvents;
	}

	public void setJoinedEvents(List<Event> joinedEvents) {
		this.joinedEvents = joinedEvents;
	}

	public List<Message> getPostedMessages() {
		return postedMessages;
	}


	public void setPostedMessages(List<Message> postedMessages) {
		this.postedMessages = postedMessages;
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

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}
	
}