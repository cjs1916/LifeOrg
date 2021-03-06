package com.project.life.controllers.chat;

import java.util.List; 

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.life.models.chat.Message;
import com.project.life.models.chat.Room;
import com.project.life.models.user.User;
import com.project.life.services.chat.RoomServ;
import com.project.life.services.user.UserService;


@Controller
public class RoomController {
	private final UserService uServ;
	private final RoomServ rServ;
	
	public RoomController(UserService uServ, RoomServ rServ) {
		this.uServ = uServ;
		this.rServ = rServ;
	}
	
	@RequestMapping("/rooms")
	public String chatIndex(@ModelAttribute("room") Room room, Model model) {
		List<Room> allRooms = rServ.allRooms();
		model.addAttribute("allRooms", allRooms);
		return "/chat/index.jsp";
	}
	
	@RequestMapping(value="/rooms/new", method=RequestMethod.POST)
	public String createChatRoom(@Valid @ModelAttribute("room") Room room, BindingResult result) {
		if(result.hasErrors()) {
			return "/chat/index.jsp";
		} else {
			rServ.createRoom(room);
			return "redirect:/rooms";
		}
	}
	
	@RequestMapping("/rooms/{id}")
	public String chatRoom(@PathVariable("id") Long id, @ModelAttribute("message") Message message, Model model, HttpSession session) {
		List<Room> allRooms = rServ.allRooms();
		Room thisRoom = rServ.findRoom(id);
		Long thisUserId = (Long) session.getAttribute("userId");
		User thisUser = uServ.findUserById(thisUserId);
		model.addAttribute("user", thisUser);
		model.addAttribute("thisRoom", thisRoom);
		model.addAttribute("allRooms", allRooms);
		return "/chat/chatRoom.jsp";
	}
	
	@RequestMapping(value="/rooms/{room_id}/message", method=RequestMethod.POST)
	public String sendMessage(@PathVariable("room_id") Long roomId, @ModelAttribute("message") Message message, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		Room thisRoom = rServ.findRoom(roomId);
		User thisUser = uServ.findUserById(userId);
		String content = message.getContent();
		rServ.message(thisUser, thisRoom, content);
		return "redirect:/rooms/" + roomId;
	}
	
}
