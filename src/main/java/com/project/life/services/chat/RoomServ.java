package com.jhan.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jhan.models.Message;
import com.jhan.models.Room;
import com.jhan.models.User;
import com.jhan.repositories.MessageRepo;
import com.jhan.repositories.RoomRepo;

@Service
public class RoomServ {
	private RoomRepo rRepo;
	private MessageRepo mRepo;
	
	public RoomServ(RoomRepo rRepo, MessageRepo mRepo) {
		this.rRepo = rRepo;
		this.mRepo = mRepo;
	}
	
	public List<Room> allRooms() {
		return rRepo.findAll();
	}
	
	public Room findRoom(Long id) {
		return rRepo.findById(id).orElse(null);
	}
	
	public void createRoom(Room room) {
		rRepo.save(room);
	}
	
	public void updateRoom(Room room) {
		rRepo.save(room);
	}
	
	public void deleteRoom(Long id) {
		rRepo.deleteById(id);
	}
	
	public void message(User user, Room room, String content) {
		Message newMessage = new Message(user, room, content);
		mRepo.save(newMessage);
	}
	
	public void manageAttendees(Room room, User user, boolean isJoining) {
		if(isJoining) {
			room.getChatAttendees().add(user);
		} else {
			room.getChatAttendees().remove(user);
		}
		rRepo.save(room);
	}
}
