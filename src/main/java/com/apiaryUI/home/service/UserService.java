package com.apiaryUI.home.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.apiaryUI.home.shared.dto.UserDto;

public interface UserService {

	UserDto createUser(UserDto user);
}
