package com.TVsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@GetMapping("/showLoginPage")
	public String showMyLoginPage() {
		
		return "login-form";	
	}

	
	@GetMapping("/access-denied")
	public String showAccessDenied() {
		
		return "access-denied";
		
	}
	
	@GetMapping("/error")
	public String errorHandler() {
		
		return "/";
	}
	
	@GetMapping("/")
	public String redirectToLogin() {
		return "redirect:/channels/list";
	}
	
}