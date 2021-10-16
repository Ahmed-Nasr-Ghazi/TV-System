package com.TVsystem.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.TVsystem.entity.Role;
import com.TVsystem.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<User> findAll() {
		Session session = entityManager.unwrap(Session.class);
		Query<User> query = session.createQuery("from User where enabled=:userStatus", User.class);
		query.setParameter("userStatus", 1);
		List<User> userList = query.getResultList();
		return userList;
	}

	@Override
	public User getById(String theId) {
		Session session = entityManager.unwrap(Session.class);
		Query<User> query = session.createQuery("from User where userName=:userName", User.class);
		query.setParameter("userName", theId);
		User theUser = query.getSingleResult();
		return theUser;
	}	

	@Override
	public void save(User user) {
		Session session = entityManager.unwrap(Session.class);
		Role role = new Role(user.getUserName(), "ROLE_USER");
		session.saveOrUpdate(user);
		session.saveOrUpdate(role);
	}

	@Override
	public void deleteById(String theId) {
		Session session = entityManager.unwrap(Session.class);
		Query theRoleQuery = session.createQuery("delete from Role where userName=:userId");
		theRoleQuery.setParameter("userId", theId);
		theRoleQuery.executeUpdate();
		
		Query theQuery = session.createQuery("delete from User where userName=:userId");
		theQuery.setParameter("userId", theId);
		
		theQuery.executeUpdate();
	}

	@Override
	public List<User> findAllPending() {
		
		Session session = entityManager.unwrap(Session.class);
		Query<User> query = session.createQuery("from User where enabled=:userStatus", User.class);
		query.setParameter("userStatus", 0);
		List<User> userList = query.getResultList();
		return userList;	
	}

}
