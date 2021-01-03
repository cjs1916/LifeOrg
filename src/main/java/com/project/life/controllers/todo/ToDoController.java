package com.project.life.controllers.todo;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.life.models.todo.Item;
import com.project.life.models.todo.ToDo;
import com.project.life.models.user.User;
import com.project.life.services.todo.ItemService;
import com.project.life.services.todo.ToDoService;
import com.project.life.services.user.UserService;

@Controller
public class ToDoController {
	private final ToDoService toDoService;
	private final UserService userService;

	public ToDoController(ToDoService toDoService, ItemService itemService, UserService userService) {
		this.toDoService = toDoService;
		this.userService = userService;
	}

	@RequestMapping("/todo")
	public String index(@ModelAttribute("toDo") ToDo toDo, HttpSession session, Model model) {
		Long userId = (Long) session.getAttribute("userId");
		User user = userService.findUserById(userId);
		List<ToDo> toDos = user.getToDos();
		Boolean isEmpty = toDos.isEmpty();
		Integer number = toDos.size();
		model.addAttribute("number", number);
		model.addAttribute("isEmpty", isEmpty);
		model.addAttribute("user", user);
		model.addAttribute("toDos", toDos);
		return "todo/index.jsp";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(@ModelAttribute("toDo") ToDo toDo, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		User user = userService.findUserById(userId);
		List<ToDo> toDos = user.getToDos();
		toDos.add(toDo);
		toDoService.saveToDo(toDo);
		userService.saveUser(user);
		return "redirect:/todo";
	}

	@RequestMapping("/todo/{id}")
	public String newToDo(@PathVariable("id") Long id, Model model, HttpSession session) {
		ToDo toDo = toDoService.findToDoById(id);
		List<Item> items = toDo.getItems();
		Boolean isEmpty = items.isEmpty();
		;
		Long userId = (Long) session.getAttribute("userId");
		User creator = toDo.getCreator();
		Long creatorId = creator.getId();
		if (userId != creatorId) {
			return "redirect:/todo";
		}
		model.addAttribute("isEmpty", isEmpty);
		model.addAttribute("items", items);
		model.addAttribute("toDo", toDo);
		return "todo/new_todo.jsp";
	}

}
