package com.toDoApp.todo;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;
@Service
public class ToDoService {
	private static List<ToDo> todos= new ArrayList<>();
	
	static{
		todos.add(new ToDo(1,"Seda","SpringBoot",LocalDate.now().plusYears(1), 
				false));
		todos.add(new ToDo(2,"Seda","JavaScript",LocalDate.now().plusYears(2), 
				false));
		todos.add(new ToDo(3,"Seda","Java",LocalDate.now().plusYears(3), 
				false));
		todos.add(new ToDo(4,"Seda","Html",LocalDate.now().plusYears(4), 
				false));
	}
	
	public List <ToDo> findByUserName(String name){
		return todos;
	}
	

}
