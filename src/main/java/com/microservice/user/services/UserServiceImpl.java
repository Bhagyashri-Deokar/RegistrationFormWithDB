package com.microservice.user.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.user.model.User;
import com.microservice.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserServices
{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public List<User> getAllUsers() {
		
		return userRepository.findAll();
	}

	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User getAllUserById(int id) {
		return userRepository.getUserByUserId(id);
	}


	@Override
	public User updateUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public void deleteUserById(String id) {
	userRepository.deleteById(id);
	}

}
