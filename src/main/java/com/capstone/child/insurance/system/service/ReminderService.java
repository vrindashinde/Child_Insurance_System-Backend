package com.capstone.child.insurance.system.service;

import java.util.Collection;

import com.capstone.child.insurance.system.entity.Reminder;



public interface ReminderService {
	
void sendEmail(String to, String subject, String message);

	


}
