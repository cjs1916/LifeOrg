package com.project.life.repositories.todo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.life.models.todo.ToDo;

@Repository
public interface ToDoRepository extends CrudRepository<ToDo, Long> {
	List<ToDo> findAll();
}
