package com.project.life.controllers.event;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.life.models.event.Event;
import com.project.life.services.event.EventServ;

@Controller
@RequestMapping("/events")
public class EventController {
	
	private final EventServ eServ;
	
	public EventController(EventServ eServ) {
		this.eServ = eServ;
	}
	
	@RequestMapping("")
	public String eventHome(@ModelAttribute("event") Event event) {
		return "/event/eventHome.jsp";
	}
	
	@RequestMapping(value="/new", method=RequestMethod.POST)
	public String createEvent(@Valid @ModelAttribute("event") Event event, BindingResult result) {
		if (result.hasErrors()) {
			return "/event/eventHome.jsp";
		} else {
			eServ.createEvent(event);
			return "redirect:/events";
		}
	}
}
