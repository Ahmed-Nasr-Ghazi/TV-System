package com.TVsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.TVsystem.dao.UserDAO;
import com.TVsystem.entity.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Override
	@Transactional
	public List<User> findAll() {
		List<User> list = userDAO.findAll();
		return list;
	}

	@Override
	@Transactional
	public User getById(String theId) {
		return userDAO.getById(theId);
	}

	@Override
	@Transactional
	public void save(User user){
		userDAO.save(user);
	}

	@Override
	@Transactional
	public void deleteById(String theId) {
		userDAO.deleteById(theId);

	}

	@Override
	public List<User> findAllPending() {
		List<User> list = userDAO.findAllPending();
		return list;
	}
	
	
	public UserServiceImpl(UserDAO userDAO2) {
		this.userDAO = userDAO2;
	}


}
