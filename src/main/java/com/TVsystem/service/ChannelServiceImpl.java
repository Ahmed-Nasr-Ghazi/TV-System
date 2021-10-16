package com.TVsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.TVsystem.dao.ChannelDAO;
import com.TVsystem.entity.Channel;

@Service
public class ChannelServiceImpl implements ChannelService {

	@Autowired
	private ChannelDAO channelDAO;

	@Override
	@Transactional
	public List<Channel> findAll() {
		List<Channel> list = channelDAO.findAll();
		return list;
	}

	@Override
	@Transactional
	public Channel getById(String theId) {
		return channelDAO.getById(theId);
	}

	@Override
	@Transactional
	public void save(Channel channel) throws Exception{
		Channel theChannel = channelDAO.getById(channel.getName());
		if(theChannel != null && theChannel.getStatus().equals("active")) {
			throw new Exception("User already exist");
		}
		channelDAO.save(channel);
	}

	@Override
	@Transactional
	public void deleteById(String theId) {
		channelDAO.deleteById(theId);

	}

	@Override
	public List<Channel> findAllPending() {
		List<Channel> list = channelDAO.findAllPending();
		return list;
	}
	
	
	public ChannelServiceImpl(ChannelDAO channelDAO2) {
		this.channelDAO = channelDAO2;
	}


}
