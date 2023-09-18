package com.capstone.child.insurance.system.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capstone.child.insurance.system.exceptions.EndowmentClaimException;

@RestControllerAdvice
public class EndowmentClaimAdvice {
	
	@ExceptionHandler
	public ResponseEntity<String> handleEndowmentException(EndowmentClaimException endowmentClaimException) {
		return new ResponseEntity<String>(endowmentClaimException.getMessage(),HttpStatus.BAD_REQUEST);
	}



}
