package com.capstone.child.insurance.system.service;

 

import java.util.Collection;
import java.util.Optional;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

 

import com.capstone.child.insurance.system.dao.ChildPolicyEnrollmentRepository;
import com.capstone.child.insurance.system.dao.ParentRepository;
import com.capstone.child.insurance.system.entity.ChildPolicyEnrollment;
import com.capstone.child.insurance.system.entity.Parent;
import com.capstone.child.insurance.system.entity.Payment;
import com.capstone.child.insurance.system.entity.Reminder;
import com.capstone.child.insurance.system.exceptions.ChildPolicyEnrollmentException;
import com.capstone.child.insurance.system.exceptions.ParentException;
import com.capstone.child.insurance.system.exceptions.PaymentException;

 

 

@Service
public class ReminderServiceImpl implements ReminderService {


 

//constructor
	private final JavaMailSender mailSender;

	public ReminderServiceImpl(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

 

 

	
	@Override
	public void sendEmail(String to, String subject, String message){

		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom("sapanabhate@gmail.com");
		simpleMailMessage.setTo(to);
		simpleMailMessage.setSubject(subject);
		simpleMailMessage.setText(message);

 

		this.mailSender.send(simpleMailMessage);


	}}







//	@Scheduled(cron = "* * * * * *")
//	public void emailScheduler() {
//		System.out.println("mail sent");
//		sendEmail("sapanabhate@gmail.com","urgent","your policy enrollment is succesfull");}
// 