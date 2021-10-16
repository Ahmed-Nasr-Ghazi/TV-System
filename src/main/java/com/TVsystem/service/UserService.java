package com.TVsystem.service;

import java.util.List;

import com.TVsystem.entity.User;

public interface UserService {

	public List<User> findAll();
	
	public List<User> findAllPending();

	public User getById(String theId);
	
	public void save(User theUser);
	
	public void deleteById(String theId);
	
}
