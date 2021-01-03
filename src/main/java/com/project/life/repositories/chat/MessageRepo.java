package com.project.life.repositories.chat;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.life.models.chat.Message;

@Repository
public interface MessageRepo extends CrudRepository<Message, Long> {
	List<Message> findAll();
}
