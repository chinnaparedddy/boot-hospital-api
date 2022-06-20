package com.ty.hospitalapi.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.hospitalapi.dto.Login;
import com.ty.hospitalapi.dto.ResponsStructure;
import com.ty.hospitalapi.dto.User;
import com.ty.hospitalapi.service.UserService;


@RestController
public class UserControler {

	@Autowired
	UserService userService;
	
	@PostMapping("/users")
	public  ResponsStructure<User> saveUser(@RequestBody User user) {
		return  userService.saveUser(user);
		
	}
	@GetMapping("/users")
	public  ResponsStructure<List<User>> getAllUsers(){
		return userService.getAllUsers();
	}
	@GetMapping("/users/{id}")
	public  ResponsStructure<User> userById(@PathVariable int id) {
		return userService.getById(id);
	}
	@PutMapping("/users")
	public  ResponsStructure<User> updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}
	@DeleteMapping("/users/{id}")
	public ResponsStructure<String> deleteUser(@RequestParam int id) {
		return userService.deleteUser(id);
	}
	@PostMapping("/users/login")
	public ResponsStructure<User> validateUser(@RequestBody Login login){
		
		return userService.validateUser(login.getEmail(), login.getPassword());
	}
	
}
