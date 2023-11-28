package com.microservice.user.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.microservice.user.model.User;

@Service
public interface UserServices 
{
	List<User> getAllUsers();
	User createUser(User user);
	User getAllUserById(int id);
	void deleteUserById(String id);
	User updateUser(User user);
}
