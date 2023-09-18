package com.capstone.child.insurance.system.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capstone.child.insurance.system.exceptions.ParentException;

@RestControllerAdvice
public class ParentAdvice {
	
	@ExceptionHandler
	public ResponseEntity<String> handleParentException(ParentException parentException) {
		return new ResponseEntity<String>(parentException.getMessage(),HttpStatus.BAD_REQUEST);
	}

}

 

