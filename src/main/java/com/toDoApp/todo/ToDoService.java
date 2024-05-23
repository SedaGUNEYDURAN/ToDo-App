package com.toDoApp.todo;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;
@Service
public class ToDoService {
	private static List<ToDo> todos= new ArrayList<>();
	private static int todosCount=0;
	
	static{
		todos.add(new ToDo(++todosCount,"Seda","SpringBoot",LocalDate.now().plusYears(1), 
				false));
		todos.add(new ToDo(++todosCount,"Seda","JavaScript",LocalDate.now().plusYears(2), 
				false));
		todos.add(new ToDo(++todosCount,"Seda","Java",LocalDate.now().plusYears(3), 
				false));
		todos.add(new ToDo(++todosCount,"Seda","Html",LocalDate.now().plusYears(4), 
				false));
	}
	
	public List <ToDo> findByUserName(String name){
		return todos;
	}
	public void addTodo(String username, String description, LocalDate targetDate, boolean done) {
		ToDo todo=new ToDo(++todosCount, username,description,targetDate,done);
		todos.add(todo);
	}
	public void deleteById(int id) {
		Predicate<? super ToDo> predicate=todoDelete->todoDelete.getId()==id;
		todos.removeIf(predicate);
	}
	public ToDo findById(int id) {
		Predicate<? super ToDo> predicate=todoUpdate->todoUpdate.getId()==id;
		ToDo todo=todos.stream().filter(predicate).findFirst().orElse(null);
		return todo;
	}
	public void updateToDo(@Valid ToDo toDo) {
		deleteById(toDo.getId());
		todos.add(toDo);
	}
	

}
