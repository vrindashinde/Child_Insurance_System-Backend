package com.capstone.child.insurance.system.service;

import java.util.Collection;

import com.capstone.child.insurance.system.entity.ChildPolicyEnrollment;
import com.capstone.child.insurance.system.entity.Payment;
import com.capstone.child.insurance.system.entity.TransactionDetail;
import com.capstone.child.insurance.system.exceptions.ChildPolicyEnrollmentException;
import com.capstone.child.insurance.system.exceptions.PaymentException;
import com.razorpay.Order;

public interface PaymentService {
		
//	Payment addPayment(Payment newPayment) ;
	Collection<Payment> getPayments() throws PaymentException;
	Collection<Payment> getAllPayments(Integer EnrollmentId) throws ChildPolicyEnrollmentException, PaymentException;  //For User
	TransactionDetail createTransactionAmount(Integer amount);
	Payment addPayment(Payment newPayment, Integer EnrollmentId) throws ChildPolicyEnrollmentException;

}
