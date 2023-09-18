package com.capstone.child.insurance.system.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capstone.child.insurance.system.exceptions.EducationClaimException;


@RestControllerAdvice
public class EducationClaimAdvice {

	@ExceptionHandler
	public ResponseEntity<String> handleEducationException(EducationClaimException educationClaimException) {
		return new ResponseEntity<String>(educationClaimException.getMessage(),HttpStatus.BAD_REQUEST);
	}

	
}
