package com.TVsystem.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.TVsystem.entity.Channel;

@Repository
public class ChannelDAOImpl implements ChannelDAO {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Channel> findAll() {
		Session session = entityManager.unwrap(Session.class);
		Query<Channel> query = session.createQuery("from Channel where status=:channelStatus", Channel.class);
		query.setParameter("channelStatus", "active");
		List<Channel> channelList = query.getResultList();
		return channelList;
	}

	@Override
	public Channel getById(String theId) {
		Session session = entityManager.unwrap(Session.class);
		Channel channel = session.get(Channel.class, theId);
		return channel;
	}	

	@Override
	public void save(Channel channel) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(channel);
	}

	@Override
	public void deleteById(String theId) {
		Session session = entityManager.unwrap(Session.class);
		Query theQuery = session.createQuery("delete from Channel where id=:channelId");
		theQuery.setParameter("channelId", theId);
		theQuery.executeUpdate();
	}

	@Override
	public List<Channel> findAllPending() {
		
		Session session = entityManager.unwrap(Session.class);
		Query<Channel> query = session.createQuery("from Channel where status=:channelStatus", Channel.class);
		query.setParameter("channelStatus", "pending");
		List<Channel> channelList = query.getResultList();
		return channelList;	
	}

}
