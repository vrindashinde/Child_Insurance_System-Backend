package com.capstone.child.insurance.system.controller;

 

import java.util.Collection;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

 

import com.capstone.child.insurance.system.entity.ChildPolicyEnrollment;
import com.capstone.child.insurance.system.entity.Reminder;
import com.capstone.child.insurance.system.exceptions.ChildPolicyEnrollmentException;
import com.capstone.child.insurance.system.service.ChildPolicyEnrollmentService;
import com.capstone.child.insurance.system.service.ReminderService;

 

@RestController
public class ReminderController {

	@Autowired
    ReminderService reminderService;

	@Autowired
	ChildPolicyEnrollmentService enrollmentsService;

    public ReminderController(ReminderService reminderService) {
    	this.reminderService=reminderService;
    }



	@PostMapping("/send-email")
	public ResponseEntity sendEmail(@RequestBody Reminder emailMessage){
		this.reminderService.sendEmail(emailMessage.getTo(),emailMessage.getSubject(), emailMessage.getMessage());
		return ResponseEntity.ok("Success");


	}

//	@GetMapping("/enrollments") 
//	public ResponseEntity<Collection<ChildPolicyEnrollment>>getAllChildPolicyEnrollment() throws ChildPolicyEnrollmentException {
//		Collection<ChildPolicyEnrollment> enrollments=enrollmentsService.getAllChildPolicyEnrollment();
//		return ResponseEntity.ok(enrollments);
//    }



 

}