package com.TV.system.test.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.TVsystem.dao.ChannelDAO;
import com.TVsystem.entity.Channel;
import com.TVsystem.service.ChannelService;
import com.TVsystem.service.ChannelServiceImpl;

@ExtendWith(SpringExtension.class)
class ChannelServiceImplTest {

	@Mock private ChannelDAO channelDAO;
	private ChannelService channelService;
	
	@BeforeEach
	void setUp() {
		channelService = new ChannelServiceImpl(channelDAO);
	}
	
	@Test
	void testFindAll() {
		//when
		channelService.findAll();
		//then
		verify(channelDAO).findAll();
	}

	@Test
	void testGetById() {
		//given
		String s = "test";
		//when
		channelService.getById(s);
		//then
		ArgumentCaptor<String> channelArgumentCaptor = ArgumentCaptor.forClass(String.class);
		verify(channelDAO).getById(channelArgumentCaptor.capture());
		
	}

	@Test
	void testSave(){
		//given
		Channel theChannel = new Channel();
		//when
		try {
			channelService.save(theChannel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//then
		ArgumentCaptor<Channel> channelArgumentCaptor = ArgumentCaptor.forClass(Channel.class);
		verify(channelDAO).save(channelArgumentCaptor.capture());
		
		Channel capturedChannel = channelArgumentCaptor.getValue();
		assertEquals(capturedChannel, theChannel);
	}

	@Test
	void testDeleteById() {
		//given
		String s = "test";
		//when
		try {
			channelService.deleteById(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//then
		ArgumentCaptor<String> channelArgumentCaptor = ArgumentCaptor.forClass(String.class);
		verify(channelDAO).deleteById(channelArgumentCaptor.capture());
	}

	@Test
	void testFindAllPending() {
		//when
		channelService.findAll();
		//then
		verify(channelDAO).findAll();
	}

}
