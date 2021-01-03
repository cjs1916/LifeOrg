package com.jhan.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jhan.models.Room;

@Repository
public interface RoomRepo extends CrudRepository<Room, Long> {
	List<Room> findAll();
}
