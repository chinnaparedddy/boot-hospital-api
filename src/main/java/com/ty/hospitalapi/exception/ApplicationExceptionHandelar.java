package com.ty.hospitalapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ty.hospitalapi.dto.ResponsStructure;

@ControllerAdvice
public class ApplicationExceptionHandelar {

	@ExceptionHandler(value = NoIdFoundException.class)
	public ResponseEntity<ResponsStructure<String>> noIdFoundExceptionHandler(NoIdFoundException ie){
		ResponsStructure<String > responsStructure=new ResponsStructure<String>();
		responsStructure.setStatuscode(HttpStatus.NOT_FOUND.value());
		responsStructure.setMessage("No Id Found");
		responsStructure.setData(ie.getMessage());
		return new ResponseEntity<ResponsStructure<String>>(responsStructure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = InvalidUserExceptionn.class)
	public ResponseEntity<ResponsStructure<String>> invalidUser(InvalidUserExceptionn invalidUserExceptionn){
		ResponsStructure<String> responsStructure=new ResponsStructure<String>();
		responsStructure.setStatuscode(HttpStatus.NOT_FOUND.value());
		responsStructure.setMessage("Invalid User");
		responsStructure.setData(invalidUserExceptionn.getMessage());
		
		return new ResponseEntity<ResponsStructure<String>>(responsStructure,HttpStatus.NOT_FOUND);
	}
}
