package com.test.TV.system.test.controller;

import javax.validation.Valid;

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

import com.test.TV.system.test.entity.User;

@Controller
//@Validated
@RequestMapping("/register")
public class RegisterController {

	
	
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

		System.out.println(theUser);
		theModel.addAttribute("user", theUser);
		
		return "registration-confirmation";
	}
	
	
}
