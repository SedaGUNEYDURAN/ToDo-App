package com.toDoApp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	public boolean authenticate(String username, String password){
		boolean isValidUserName=username.equalsIgnoreCase("Seda");
		boolean isValidPassword=password.equalsIgnoreCase("1234");
		return isValidUserName && isValidPassword;
				
	}

}
