package com.TVsystem.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.TVsystem.entity.User;
import com.TVsystem.service.UserService;

@Controller
//@Validated
@RequestMapping("/register")
public class RegisterController {

	@Autowired
	private UserService userService;
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@GetMapping("/showRegisterForm")
	public String showRegisterForm(Model theModel) {
		
		theModel.addAttribute("user", new User());
		return "registration-form";
	}
	
	@PostMapping("/handleRegister")
	public String handleRegister(@Valid @ModelAttribute("user") User theUser, 
			BindingResult theBindingResult, Model theModel) {
				
		if (theBindingResult.hasErrors()){
			 return "registration-form";
	    }
		theModel.addAttribute("user", theUser);
		theUser.setPassword("{noop}"+theUser.getPassword());
		userService.save(theUser);
		
		
		return "registration-confirmation";
	}
	
	
}
