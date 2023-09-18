package com.capstone.child.insurance.system.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capstone.child.insurance.system.exceptions.AdminException;


@RestControllerAdvice
public class AdminAdvice {
	
	
	@ExceptionHandler
	public ResponseEntity<String> handleAdminException(AdminException adminException) {
		return new ResponseEntity<String>(adminException.getMessage(),HttpStatus.BAD_REQUEST);
	}

}
