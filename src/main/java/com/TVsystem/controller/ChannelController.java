package com.TVsystem.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.TVsystem.entity.Channel;
import com.TVsystem.service.ChannelService;


@Controller
@RequestMapping("/channels")
public class ChannelController {
	
	@Autowired
	private ChannelService channelService;
	
	@GetMapping("/list")
	private String channelsList(Model theModel) {		
		List<Channel> channelList = channelService.findAll();
		theModel.addAttribute("channellist", channelList);
		return "channels/channel-list";
	}
	
	@GetMapping("/showFormForSuggest")
	public String showFormForSuggest(Model theModel) {
		Channel theChannel = new Channel();
		theModel.addAttribute("channel", theChannel);
		return "channels/channel-form";
	}
	
	@PostMapping("/suggest")
	public String saveSuggest(@ModelAttribute ("channel") Channel theChannel){
		
		if(theChannel.getName().equals("") || theChannel.getURL().equals("")) {
			return "redirect:/channels/list";
		}
		theChannel.setStatus("pending");
		try {
			channelService.save(theChannel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/channels/list";
	}

	@GetMapping("/search")
	public String searchChannel(@RequestParam("channelName") String channelName, Model theModel) {
		Channel theChannel = channelService.getById(channelName);
		if(theChannel==null) {
			theModel.addAttribute("searchError", "There is no such channel");
			return "redirect:/channels/list";
		}
		theModel.addAttribute("channel", theChannel);
		return "channels/search-result";
	}
	
	
}
