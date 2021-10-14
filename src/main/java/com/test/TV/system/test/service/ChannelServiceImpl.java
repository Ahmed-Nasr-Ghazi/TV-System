package com.test.TV.system.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.TV.system.test.dao.ChannelDAO;
import com.test.TV.system.test.entity.Channel;

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
	public void save(Channel channel) {
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

}
