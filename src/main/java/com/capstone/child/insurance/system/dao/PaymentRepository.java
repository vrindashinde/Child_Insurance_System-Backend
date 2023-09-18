package com.capstone.child.insurance.system.dao;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.capstone.child.insurance.system.entity.ChildPolicyEnrollment;
import com.capstone.child.insurance.system.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer>{
	
	Collection<Payment> findAllByEnrollment(ChildPolicyEnrollment enrollment);

}
