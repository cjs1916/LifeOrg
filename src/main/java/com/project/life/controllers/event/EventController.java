package com.project.life.controllers.event;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.life.models.event.Event;
import com.project.life.models.user.User;
import com.project.life.services.event.EventServ;
import com.project.life.services.user.UserService;

@Controller
@RequestMapping("/events")
public class EventController {
	
	private final EventServ eServ;
	private final UserService uServ;
	
	public EventController(EventServ eServ, UserService uServ) {
		this.eServ = eServ;
		this.uServ = uServ;
	}
	
	@RequestMapping("")
	public String eventHome(@ModelAttribute("event") Event event, Model model, HttpSession session) {
		Long thisUserId = (Long) session.getAttribute("userId");
		User thisUser = uServ.findUserById(thisUserId);
		model.addAttribute("thisUser", thisUser);
		return "/event/eventHome.jsp";
	}
	
	@RequestMapping(value="/new", method=RequestMethod.POST)
	public String createEvent(@Valid @ModelAttribute("event") Event event, BindingResult result, HttpSession session) {
		if (result.hasErrors()) {
			return "/event/eventHome.jsp";
		} else {
			Long thisUserId = (Long) session.getAttribute("userId");
			User thisUser = uServ.findUserById(thisUserId);
			eServ.createEvent(thisUser, event.getName(), event.getDescription(), event.getLocation(), event.getDate());
			return "redirect:/events";
		}
	}
}
