package com.ty.hospitalapi.exception;

public class InvalidUserExceptionn extends RuntimeException{

	private String message="Invali User";

	public InvalidUserExceptionn(String message) {
		this.message = message;
	}

	public InvalidUserExceptionn() {
	}
	public String innvalidUser() {
		return message;
	}
}