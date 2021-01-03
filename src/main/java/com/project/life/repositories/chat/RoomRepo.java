package com.project.life.repositories.chat;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.life.models.chat.Room;

@Repository
public interface RoomRepo extends CrudRepository<Room, Long> {
	List<Room> findAll();
}
