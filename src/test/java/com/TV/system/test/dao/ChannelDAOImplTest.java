package com.TV.system.test.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.TVsystem.dao.ChannelDAO;
import com.TVsystem.entity.Channel;


@SpringBootTest
class ChannelDAOImplTest {

	@Autowired
	private ChannelDAO channelDAO;
	
	@Test
	void testFindAll() {
		//when
		List<Channel> expectedchannelList = channelDAO.findAll();
		//then
		assertNotNull(expectedchannelList);
	}

	@Test
	@Transactional	
	void testSave() {
		//given
		Channel channel = new Channel("test","www.test.com", "test", "pending");
		//when
		channelDAO.save(channel);
		//then
		Channel expectedChannel = channelDAO.getById(channel.getName());
		assertEquals(expectedChannel, channel);
	}
	
	@Test
	@Transactional	
	void testGetById() {
		//given
		Channel channel = new Channel("test","www.test.com", "test", "pending");
		channelDAO.save(channel);
		//when
		Channel expectedChannel = channelDAO.getById(channel.getName());
		//then
		assertEquals(expectedChannel, channel);
	}

	@Test
	@Transactional
	void testDeleteById() {
		//given
		Channel channel = new Channel("test","www.test.com", "test", "pending");
		channelDAO.save(channel);
		//when
		channelDAO.deleteById(channel.getName());
		//then
		assertNull(channelDAO.getById(channel.getName()));
		
	}

	@Test
	void testFindAllPending() {
		//when
		List<Channel> expectedchannelList = channelDAO.findAllPending();
		//then
		assertNotNull(expectedchannelList);
	}

}
