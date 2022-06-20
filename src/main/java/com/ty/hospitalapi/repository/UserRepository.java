package com.ty.hospitalapi.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.hospitalapi.dto.User;


public interface UserRepository extends JpaRepository<User, Integer>{

	@Query("select u from User u where u.email=?1 and u.password=?2")
	User validateUser(String email,String password);
}
