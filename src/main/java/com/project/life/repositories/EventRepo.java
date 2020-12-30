package com.project.life.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.life.models.Event;

@Repository
public interface EventRepo extends CrudRepository<Event, Long> {
	List<Event> findAll();
	
}
