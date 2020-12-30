package com.project.life.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.life.models.Event;
import com.project.life.repositories.EventRepo;

@Service
public class EventServ {
	private final EventRepo eRepo;
	
	public EventServ(EventRepo eRepo) {
		this.eRepo = eRepo;
	}
	
	public List<Event> allEvents() {
		return eRepo.findAll();
	}
	
	public void createEvent(Event e) {
		eRepo.save(e);
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
