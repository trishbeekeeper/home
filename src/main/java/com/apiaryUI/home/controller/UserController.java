package com.apiaryUI.home.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apiaryUI.home.model.request.UserDetailsRequestModel;
import com.apiaryUI.home.model.response.UserRestResponseModel;
import com.apiaryUI.home.service.UserService;
import com.apiaryUI.home.shared.dto.UserDto;

@RestController
@RequestMapping("/users") //http:localhost:8080/users
public class UserController {
	@Autowired
	UserService userService;
	//to make it respond to get request:
	@GetMapping
	public String getUser() {
		return "get user was called!";
	}
	
	//to make the method respond to post request:
	@PostMapping
	public UserRestResponseModel createUser(@RequestBody UserDetailsRequestModel userDetails) {
		
		UserRestResponseModel returnValue = new UserRestResponseModel();
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userDetails, userDto);
		
		UserDto createdUser = userService.createUser(userDto);
		BeanUtils.copyProperties(createdUser, returnValue);
		
		return returnValue;
	}
	
	//to bind this method to put:
	@PutMapping
	public String updateUser() {
		return "update user was called!";
	}
	
	//to bind method to delete http method:
	@DeleteMapping
	public String deleteUser() {
		return "delete user was called";
	}
}

