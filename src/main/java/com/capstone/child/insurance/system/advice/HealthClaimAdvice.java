package com.capstone.child.insurance.system.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capstone.child.insurance.system.exceptions.HealthClaimException;

@RestControllerAdvice
public class HealthClaimAdvice {
	
	
	@ExceptionHandler
	public ResponseEntity<String> handleHealthException(HealthClaimException healthClaimException) {
		return new ResponseEntity<String>(healthClaimException.getMessage(),HttpStatus.BAD_REQUEST);
	}



}
