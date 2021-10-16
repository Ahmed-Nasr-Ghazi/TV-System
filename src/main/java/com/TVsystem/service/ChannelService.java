package com.TVsystem.service;

import java.util.List;

import com.TVsystem.entity.Channel;

public interface ChannelService {

	public List<Channel> findAll();
	
	public List<Channel> findAllPending();

	public Channel getById(String theId);
	
	public void save(Channel channel) throws Exception;
	
	public void deleteById(String theId);
	
}
