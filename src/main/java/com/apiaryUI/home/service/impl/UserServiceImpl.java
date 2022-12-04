package com.apiaryUI.home.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiaryUI.home.UserRepository;
import com.apiaryUI.home.io.entity.UserEntity;
import com.apiaryUI.home.service.UserService;
import com.apiaryUI.home.shared.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;
	
	//Recieves object created from JSON sent by UI; 
	//will not have all fields of UserEntity yet. 
	//userId is generated here, so is encryptedPassword.
	//Otherwise handed over...
	@Override
	public UserDto createUser(UserDto user) {
		//this object will be used to fill database
		UserEntity userEntity = new UserEntity();
		
		//copy the values like firstName, email that will just
		//fill entries n database
		BeanUtils.copyProperties(user, userEntity);
		
		//do something for values like userId and encryptedPassword
		//that are created from user entered data
		userEntity.setEncryptedPassword("testEncPassword");
		userEntity.setUserId("testUserId");
		
		//get completed UserEntity object as indicator of success!!!
		UserEntity storedUserDetails = userRepository.save(userEntity);
		
		//to send values in UserEntity object back must convert over to dto...
		UserDto returnValue = new UserDto();
		BeanUtils.copyProperties(storedUserDetails,  returnValue);
		
		return null;
	}

}
