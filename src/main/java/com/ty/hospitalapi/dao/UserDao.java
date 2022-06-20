package com.ty.hospitalapi.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.hospitalapi.dto.User;
import com.ty.hospitalapi.repository.UserRepository;


@Repository
public class UserDao {

	@Autowired
	UserRepository userRepository;
	
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	 
	public User getUserId(int id) {
		Optional<User>optional= userRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			return null;
		}
	}
	public User updateUser(User user) {
		Optional< User> optional=userRepository.findById(user.getId());
		if(optional.isPresent()) {
			return userRepository.save(user);
		}else {
			return null;
		}
	}
	public boolean userDelete(int id) {
		Optional<User>optional= userRepository.findById(id);
		if(optional.isPresent()) {
			  userRepository.delete(optional.get());
		return true;
		}else {
			return false;
		}
}
	public User validateUser(String email,String password){
		return userRepository.validateUser(email, password);
	}
}
