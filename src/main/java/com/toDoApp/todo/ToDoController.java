package com.toDoApp.todo;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class ToDoController {
	
	private ToDoService todoService;
	//Constructor Injection 
	public ToDoController(ToDoService todoService) {
		super();
		this.todoService = todoService;
	}


	@RequestMapping("list-todos")
	public String listAllTodos(Model model) {
		List<ToDo> todos = todoService.findByUserName("Seda");
		model.addAttribute("todos",todos);
		return "listToDos";
	}
}
