package com.capstone.child.insurance.system.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.capstone.child.insurance.system.entity.Payment;
import com.capstone.child.insurance.system.entity.TransactionDetail;
import com.capstone.child.insurance.system.exceptions.ChildPolicyEnrollmentException;
import com.capstone.child.insurance.system.exceptions.PaymentException;
import com.capstone.child.insurance.system.service.PaymentService;

import jakarta.annotation.security.PermitAll;

@RequestMapping("/api/v1/user")
@RestController
@CrossOrigin(origins="http://localhost:4200/")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

//	@GetMapping("/")
//	public String getGreeting() {
//		return "welcome to payment!";
//	}

	@PostMapping("/payment/{enrollment_id}")
	public Payment addPayment(@RequestBody Payment newPayment,@PathVariable("enrollment_id") Integer EnrollmentId) throws ChildPolicyEnrollmentException{

		return this.paymentService.addPayment(newPayment, EnrollmentId);

	}

	@GetMapping("/getall")
	public Collection<Payment> getPayments() throws PaymentException {
		
		return this.paymentService.getPayments();
	}
	
	@GetMapping("/findall/{enrollment_id}")
	public Collection<Payment> getAllPayments(@PathVariable("enrollment_id") Integer id) throws PaymentException, ChildPolicyEnrollmentException{
		return this.paymentService.getAllPayments(id);
		
	}
	
	@GetMapping("/createTransaction/{amount}")
    public TransactionDetail createTransaction(@PathVariable (name="amount")Integer amount) {
		return paymentService.createTransactionAmount(amount);

		    }
		
	}


