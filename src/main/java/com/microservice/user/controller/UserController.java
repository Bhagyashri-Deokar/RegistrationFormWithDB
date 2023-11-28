package com.microservice.user.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.user.model.User;
import com.microservice.user.services.UserServices;

@RestController
@RequestMapping("api/v1")
public class UserController {
	@Autowired
	UserServices userServices;

	@PostMapping("/user")
	public ResponseEntity<?> saveUserInformation(@Valid @RequestBody User user)
	{
		return ResponseEntity.status(HttpStatus.OK).body(userServices.createUser(user));
	}
	@PostMapping("/user/{id}")
	public ResponseEntity<?> updateUserInformation(@PathVariable int id,@RequestBody User user)
	{
		User user_=userServices.getAllUserById(id);
		return ResponseEntity.status(HttpStatus.OK).body(userServices.createUser(user));
	}
	@GetMapping("/user")
	public ResponseEntity<?> getAllUser()
	{
		return ResponseEntity.status(HttpStatus.OK).body(userServices.getAllUsers());
	}
}
