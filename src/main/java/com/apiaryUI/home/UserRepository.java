package com.apiaryUI.home;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apiaryUI.home.io.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
	
	//note that simple methods like insert/create, select/find/read, update/put, 
	//and delete are provided by JPA when the appropriate methods are used
	//to call the Repository
}
