package com.project.life.services.event;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.life.models.event.Event;
import com.project.life.models.user.User;
import com.project.life.repositories.event.EventRepo;

@Service
public class EventServ {
	private final EventRepo eRepo;
	
	public EventServ(EventRepo eRepo) {
		this.eRepo = eRepo;
	}
	
	public List<Event> allEvents() {
		return eRepo.findAll();
	}
	
	public void createEvent(User user, String name, String description, String location, String date) {
		Event newEvent = new Event(user, name, description, location, date);
		eRepo.save(newEvent);
	}
	
	public void updateEvent(Event e) {
		eRepo.save(e);
	}
	
	public Event findOneEvent(Long id) {
		Optional<Event> thisEvent = eRepo.findById(id);
		if (thisEvent.isPresent()) {
			return thisEvent.get();
		} else {
			return null;
		}
	}
}
