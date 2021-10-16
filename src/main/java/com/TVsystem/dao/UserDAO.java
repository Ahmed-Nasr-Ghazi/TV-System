package com.TVsystem.dao;

import java.util.List;

import com.TVsystem.entity.User;

public interface UserDAO {

	public List<User> findAll();
	
	public List<User> findAllPending();
	
	public User getById(String theId);
	
	public void save(User User);
	
	public void deleteById(String theId);
	

}
