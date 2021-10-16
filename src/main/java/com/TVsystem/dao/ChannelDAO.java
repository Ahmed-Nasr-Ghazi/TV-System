package com.TVsystem.dao;

import java.util.List;

import com.TVsystem.entity.Channel;

public interface ChannelDAO {

	public List<Channel> findAll();
	
	public List<Channel> findAllPending();
	
	public Channel getById(String theId);
	
	public void save(Channel channel);
	
	public void deleteById(String theId);
	
	
	
}
