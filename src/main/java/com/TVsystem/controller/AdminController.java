package com.TVsystem.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.TVsystem.entity.Channel;
import com.TVsystem.entity.User;
import com.TVsystem.service.ChannelService;
import com.TVsystem.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private ChannelService channelService;
	
	@Autowired
	private UserService userService;
	
	// ------- Channels requests
	
	@GetMapping("/dashboard")
	private String showDashBoard(Model theModel) {
		List<Channel> channelsList = channelService.findAllPending();
		theModel.addAttribute("pendingList", channelsList);
		return "admin/dash-board";
	}
	
	@GetMapping("/acceptChannel")
	private String acceptChannel(@RequestParam("channelName") String channelName){
		Channel theChannel = channelService.getById(channelName);
		theChannel.setStatus("active");
		try {
			channelService.save(theChannel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/channels/list";
	}
	
	@GetMapping("/deleteChannel")
	private String deleteChannel(@RequestParam("channelName") String name) {
		channelService.deleteById(name);
		return "redirect:/channels/list";
	}
	// ------- User requests
	
	@GetMapping("/usersDashboard")
	private String showUsersDashBoard(Model theModel) {
		List<User> userList = userService.findAllPending();
		theModel.addAttribute("pendingUser", userList);
		return "admin/users-dash-board";

	}
	
	@GetMapping("/acceptUser")
	private String acceptUser(@RequestParam("userName") String name) {
		System.out.println(name);
		User theUser = userService.getById(name);
		theUser.setEnabled(1);
		try {
			userService.save(theUser);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/channels/list";
	}
	
	@GetMapping("/declineUser")
	private String declineUser(@RequestParam("userName") String name) {
		System.out.println(name);
		userService.deleteById(name);
		return "redirect:/channels/list";
	}
	
	
	
}
