package com.adamp.beltreviewer.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.adamp.beltreviewer.models.Event;
import com.adamp.beltreviewer.models.Message;
import com.adamp.beltreviewer.repositories.EventRepository;
import com.adamp.beltreviewer.repositories.MessageRepository;

@Service
public class MainService {
	private final EventRepository eventRepo;
	private final MessageRepository msgRepo;
	
	public MainService(EventRepository eventRepo, MessageRepository msgRepo) {
		this.eventRepo = eventRepo;
		this.msgRepo = msgRepo;
	}

	public EventRepository getEventRepo() {
		return eventRepo;
	}

	public MessageRepository getMsgRepo() {
		return msgRepo;
	}

	//------------------------Event Methods-----------------------//



	// Get all
	public List<Event> getAllEvents() {
		return eventRepo.findAll();  // removed .this
	}
	
	// Find by ID
	public Event findEventById(Long id) {
		return eventRepo.findById(id).orElse(null); // removed .this
	}
	
	// Create
	public Event addEvent(Event event) {
		return eventRepo.save(event);
	}
	
	public void createEvent(Event event) {
		this.eventRepo.save(event);
	}
	
	// delete
	public void deleteEvent(Long id) {
		eventRepo.deleteById(id);
		return;
	}
	
	// Update 
	
	public void update(@Valid Event filledEvent) {
		eventRepo.save(filledEvent);
	}	
	//------------------------End Event Methods-----------------------//
	
	//------------------------Message Methods-----------------------//

	// Get all
	public List<Message> getAllMessages() {
		return msgRepo.findAll();  // removed .this
	}

	// Find by ID
	public Message findMessageById(Long id) {
		return msgRepo.findById(id).orElse(null); // removed .this
	}

	// Create
	public Message addMessage(Message message) {
		return msgRepo.save(message);
	}

	public void createMessage(Message message) {
		this.msgRepo.save(message);
	}

	// delete
	public void deleteMessage(Long id) {
		msgRepo.deleteById(id);
		return;
	}

	// Update 

	public void update(@Valid Message filledMessage) {
		msgRepo.save(filledMessage);
	}
	//------------------------End Message Methods-----------------------/
}