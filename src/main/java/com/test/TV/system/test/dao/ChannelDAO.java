package com.test.TV.system.test.dao;

import java.util.List;

import com.test.TV.system.test.entity.Channel;

public interface ChannelDAO {

	public List<Channel> findAll();
	
	public List<Channel> findAllPending();
	
	public Channel getById(String theId);
	
	public void save(Channel channel);
	
	public void deleteById(String theId);
	
	
	
}
