package com.toDoApp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

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
	
	@RequestMapping(value="add-todo", method=RequestMethod.GET)
	public String showNewTodoPage(ModelMap model) {
		String username=(String)model.getAttribute("name");
		ToDo todo=new ToDo(0, username,"Default",LocalDate.now().plusYears(1),false);
		model.put("todoPage",todo);
		return "todo";
	}
	
	@RequestMapping(value="add-todo", method=RequestMethod.POST)
	public String addNewTodo(ModelMap model, @ModelAttribute("todoPage")@Valid ToDo toDo, BindingResult result) {
		
		if(result.hasErrors()) {
			return "todo";
		}
		String username=(String)model.get("name");
		todoService.addTodo(username, toDo.getDescription(), LocalDate.now().plusYears(1), false);
		
		return "redirect:list-todos";
	}
}
