package com.project.life.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.life.models.Event;
import com.project.life.services.EventServ;

@Controller
@RequestMapping("/events")
public class EventController {
	
	private final EventServ eServ;
	
	public EventController(EventServ eServ) {
		this.eServ = eServ;
	}
	
	@RequestMapping("")
	public String eventHome(@ModelAttribute("event") Event event) {
		return "eventHome.jsp";
	}
	
	@RequestMapping(value="/new", method=RequestMethod.POST)
	public String createEvent(@Valid @ModelAttribute("event") Event event, BindingResult result) {
		if (result.hasErrors()) {
			return "eventHome.jsp";
		} else {
			eServ.createEvent(event);
			return "redirect:/events";
		}
	}
}
