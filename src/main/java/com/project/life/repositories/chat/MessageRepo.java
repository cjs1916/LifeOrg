package com.jhan.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jhan.models.Message;

@Repository
public interface MessageRepo extends CrudRepository<Message, Long> {
	List<Message> findAll();
}
