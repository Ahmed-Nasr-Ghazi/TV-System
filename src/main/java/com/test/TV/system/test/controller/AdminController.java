package com.test.TV.system.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.TV.system.test.entity.Channel;
import com.test.TV.system.test.service.ChannelService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private ChannelService channelService;
	
	@GetMapping("/dashboard")
	private String showDashBoard(Model theModel) {
		
		List<Channel> channelsList = channelService.findAllPending();
		theModel.addAttribute("pendingList", channelsList);
		
		return "admin/dash-board";
	}
	@GetMapping("/accept")
	private String accept(@RequestParam("channelName") String channelName) {
		Channel theChannel = channelService.getById(channelName);
		theChannel.setStatus("active");
		channelService.save(theChannel);
		return "redirect:/channels/list";
	}
	
	@GetMapping("/delete")
	private String delete(@RequestParam("channelName") String name) {
		channelService.deleteById(name);
		return "redirect:/channels/list";
	}
}
