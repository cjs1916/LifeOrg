package com.project.life.services.todo;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.life.models.todo.ToDo;
import com.project.life.models.user.User;
import com.project.life.repositories.todo.ToDoRepository;
import com.project.life.repositories.user.UserRepository;

@Service
public class ToDoService {
	private final ToDoRepository toDoRepository;

	public ToDoService(ToDoRepository toDoRepository) {
		this.toDoRepository = toDoRepository;
	}

	public ToDo saveToDo(ToDo toDo) {
		return toDoRepository.save(toDo);

	}

	public ToDo findToDoById(Long id) {
		Optional<ToDo> td = toDoRepository.findById(id);

		if (td.isPresent()) {
			return td.get();
		} else {
			return null;
		}
	}

	public List<ToDo> getAll() {
		List <ToDo> toDos = toDoRepository.findAll();
		return toDos;
	}

}
