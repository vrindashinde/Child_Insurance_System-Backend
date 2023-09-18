package com.capstone.child.insurance.system.entity;

 

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

 

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

 

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

 

//@Entity
public class Reminder {

 

//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private Integer reminderId; // unique due id
//	@JsonFormat(pattern = "yyyy-MM-dd")
//	private LocalDate nextDueDate; // next due date
//	private Double due; // monthly due to be paid
	private String to;
	private String subject;
	private String message;
//
//	@JsonIgnore
//	@OneToOne
//	@JoinColumn(name = "enrollmentId")
//	private ChildPolicyEnrollment enrollment;

 

 

	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Reminder(String to, String subject, String message) {
		super();
		this.to = to;
		this.subject = subject;
		this.message = message;
	}



 

}