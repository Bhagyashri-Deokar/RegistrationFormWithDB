package com.microservice.user.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.user.model.User;
import com.microservice.user.responsebody.ApiResponse;
import com.microservice.user.services.UserServices;

@RestController
@CrossOrigin
@RequestMapping("api/v1")
public class UserController {
	@Autowired
	UserServices userServices;

	@PostMapping("/user")
	public ResponseEntity<?> saveUserInformation(@Valid @RequestBody User user, BindingResult bindingResult)
	{
		
		ApiResponse<String> apiResponse = new ApiResponse<String>();
		
		System.out.println("Error="+bindingResult.getErrorCount());
		if (bindingResult.hasErrors()) {
			apiResponse.setStatus(400);
			apiResponse.setMessage("Validation failed for the following fields:");
			apiResponse.setData(bindingResult.getFieldErrors().get(0).getDefaultMessage());

			return ResponseEntity.badRequest().body(apiResponse);
		}

		try {
			// Call the service to save the user information
			User savedUser = userServices.createUser(user);

			return ResponseEntity.status(HttpStatus.OK).body(savedUser);
		} catch (Exception e) {
			System.out.println("Exception="+e.getMessage());
			// Handle specific exception, you can create your own custom exception classes
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(e);
		}
	}

	@PostMapping("/user/{id}")
	public ResponseEntity<?> updateUserInformation(@PathVariable int id, @RequestBody User user) {
		User user_ = userServices.getAllUserById(id);
		return ResponseEntity.status(HttpStatus.OK).body(userServices.createUser(user));
	}

	@GetMapping("/user")
	public ResponseEntity<?> getAllUser() {
		return ResponseEntity.status(HttpStatus.OK).body(userServices.getAllUsers());
	}
}
