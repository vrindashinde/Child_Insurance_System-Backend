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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer paymentId; // payment id
	private Boolean paymentSuccesful; // whether the payment is successful or not
	private Double amountPaid; // Amount paid
	
	private String razorPayOrderId;
	
	
	private String paymentDate; // Date of payment
	
	
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "enrollment_id")
	private ChildPolicyEnrollment enrollment;

	public Payment() {
		super();
		
	}

	public Payment(Integer paymentId, Boolean paymentSuccesful, Double amountPaid, String razorPayOrderId,
			String paymentDate, ChildPolicyEnrollment enrollment) {
		super();
		this.paymentId = paymentId;
		this.paymentSuccesful = paymentSuccesful;
		this.amountPaid = amountPaid;
		this.razorPayOrderId = razorPayOrderId;
		this.paymentDate = paymentDate;
		this.enrollment = enrollment;
	}

	public Integer getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	public Boolean getPaymentSuccesful() {
		return paymentSuccesful;
	}

	public void setPaymentSuccesful(Boolean paymentSuccesful) {
		this.paymentSuccesful = paymentSuccesful;
	}

	public Double getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(Double amountPaid) {
		this.amountPaid = amountPaid;
	}

	public String getRazorPayOrderId() {
		return razorPayOrderId;
	}

	public void setRazorPayOrderId(String razorPayOrderId) {
		this.razorPayOrderId = razorPayOrderId;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	public ChildPolicyEnrollment getEnrollment() {
		return enrollment;
	}

	public void setEnrollment(ChildPolicyEnrollment enrollment) {
		this.enrollment = enrollment;
	}
	
	
	
}