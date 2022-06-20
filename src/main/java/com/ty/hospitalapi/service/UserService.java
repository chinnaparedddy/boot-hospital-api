package com.ty.hospitalapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.hospitalapi.dao.UserDao;
import com.ty.hospitalapi.dto.ResponsStructure;
import com.ty.hospitalapi.dto.User;
import com.ty.hospitalapi.exception.InvalidUserExceptionn;
import com.ty.hospitalapi.exception.NoIdFoundException;


@Service
public class UserService {

	@Autowired
	UserDao userDao;

	public ResponsStructure<User> saveUser(User user) {
		ResponsStructure<User> responsStructure=new ResponsStructure<User>();
		responsStructure.setStatuscode(HttpStatus.CREATED.value());
		responsStructure.setMessage("Sucess");
		responsStructure.setData(userDao.saveUser(user));
		return responsStructure;
	}
	 
	public ResponsStructure<List<User>> getAllUsers() {
		ResponsStructure<List<User>> responsStructure=new ResponsStructure<List<User>>();
		responsStructure.setStatuscode(HttpStatus.CREATED.value());
		responsStructure.setMessage("sucess");
		responsStructure.setData(userDao.getAllUsers());
		return responsStructure;
	}
	
	public ResponsStructure<User> getById(int id){
		User user= userDao.getUserId(id);
		ResponsStructure<User> responsStructure=new ResponsStructure<User>();
		if(user!=null) {
			responsStructure.setStatuscode(HttpStatus.CREATED.value());
			responsStructure.setMessage("sucess");
			responsStructure.setData(user);
		}else {
			throw new NoIdFoundException("Id Not Found"+id+"not found");
//			responsStructure.setStatuscode(HttpStatus.CREATED.value());
//			responsStructure.setMessage("User id Not Found");
//			responsStructure.setData(null);
		}
		return  responsStructure;
	}

	public ResponsStructure<User> updateUser(User user){
		User user1= userDao.getUserId(user.getId());
		ResponsStructure<User> responsStructure=new ResponsStructure<User>();
		if(user1!=null) {
			responsStructure.setStatuscode(HttpStatus.CREATED.value());
			responsStructure.setMessage("sucess");
			responsStructure.setData(userDao.updateUser(user));
		}else {
			responsStructure.setStatuscode(HttpStatus.CREATED.value());
			responsStructure.setMessage("User id Not Found");
			responsStructure.setData(user);
		}
		return responsStructure;
	}
	
	public ResponsStructure<String> deleteUser(int id){
		boolean user1= userDao.userDelete(id);
		ResponsStructure<String> responsStructure=new ResponsStructure<String>();
		if(user1) {
			responsStructure.setStatuscode(HttpStatus.CREATED.value());
			responsStructure.setMessage("Data deleted");
		    responsStructure.setData("Data Deleted");
		}else {
			responsStructure.setStatuscode(HttpStatus.CREATED.value());
			responsStructure.setMessage("Not Deleted");
			responsStructure.setData("Data Not Deleted");
		}
		return responsStructure;
	}
	public ResponsStructure<User> validateUser(String email,String password){
		
		User user=userDao.validateUser(email, password);
		ResponsStructure<User> responsStructure=new ResponsStructure<User>();
		if(user!=null) {
			 responsStructure.setStatuscode(HttpStatus.ACCEPTED.value());
			 responsStructure.setMessage("sucess");
			 responsStructure.setData(user);
		}else {
			throw new InvalidUserExceptionn("User Invalid");
		}
		return responsStructure;
	}
	
}
