package com.toDoApp.login;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
@Controller
//@SessionAttributes("name")
public class LoginController {
//	private AuthenticationService authenticationService;
//	
//	public LoginController(AuthenticationService authenticationService) {
//		super();
//		this.authenticationService = authenticationService;
//	}

	@RequestMapping(value="/", method=RequestMethod.GET)//login
	public String goToLoginPage(ModelMap model) {
		model.put("name","seda"); 
		
		return "welcome";//login
	}
	
//	@RequestMapping(value="login", method=RequestMethod.POST)
//	public String goToWelcomePage(@RequestParam String name,@RequestParam String password, ModelMap model) {
//		if(authenticationService.authenticate(name, password)) {
//			model.put("name",name);
//			model.put("password",password);
//			return "welcome";
//		}
//		model.put("errorMessage", "Invalid Creditials! Please try again");
//		return "login"; 
//		
//		
//	}
}
