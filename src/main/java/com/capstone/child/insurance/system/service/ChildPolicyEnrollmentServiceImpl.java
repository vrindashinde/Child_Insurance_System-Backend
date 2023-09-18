package com.capstone.child.insurance.system.service;

import java.util.Collection;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.child.insurance.system.dao.ChildPolicyEnrollmentRepository;
import com.capstone.child.insurance.system.dao.ChildRepository;
import com.capstone.child.insurance.system.dao.PolicyRepository;
import com.capstone.child.insurance.system.entity.Child;
import com.capstone.child.insurance.system.entity.ChildPolicyEnrollment;
import com.capstone.child.insurance.system.entity.ChildPolicyEnrollment.policyStatus;
import com.capstone.child.insurance.system.entity.Policy;
import com.capstone.child.insurance.system.exceptions.ChildPolicyEnrollmentException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ChildPolicyEnrollmentServiceImpl implements ChildPolicyEnrollmentService {

	@Autowired
	ChildPolicyEnrollmentRepository childPolicyEnrollmentRepository;
	
	@Autowired
	ChildRepository childRepository;
	
	@Autowired
	PolicyRepository policyrepository;




	@Override // done
	public Collection<ChildPolicyEnrollment> getAllChildPolicyEnrollments(Integer ChildId) throws ChildPolicyEnrollmentException{
		Optional<Child> child = childRepository.findById(ChildId);
		
		Optional<Collection<ChildPolicyEnrollment>>childPolicyEnrollments = Optional.of(childPolicyEnrollmentRepository.findAllByChild(child.get()));
		if(!childPolicyEnrollments.isPresent()) {
			throw new ChildPolicyEnrollmentException("No enrollment for this user found");
		}
		
		return childPolicyEnrollments.get();
	}



	@Override
	public ChildPolicyEnrollment addEnrollment(ChildPolicyEnrollment enrollment, Integer childId, Integer policyId) throws ChildPolicyEnrollmentException{
		
		Optional<Child> child = this.childRepository.findById(childId);
		
		if(!child.isPresent()) {
			throw new ChildPolicyEnrollmentException("No child with given id found");
		}
		
		enrollment.setChild(child.get());
		
      Optional<Policy> policy = this.policyrepository.findById(policyId);
		
		if(!policy.isPresent()) {
			throw new ChildPolicyEnrollmentException("No policy with given id found");
		}
		
		enrollment.setPolicy(policy.get());
		
		enrollment.setStatus(policyStatus.PAYMENTPENDING);	
		return this.childPolicyEnrollmentRepository.save(enrollment);
	}



	@Override
	public Collection<ChildPolicyEnrollment> getAllEnrollmentsByPolicy(Integer policyId)
			throws ChildPolicyEnrollmentException {
		
		Optional<Policy> policy = this.policyrepository.findById(policyId);
		
		Optional<Collection<ChildPolicyEnrollment>>childPolicyEnrollments = Optional.of(childPolicyEnrollmentRepository.findAllByPolicy(policy.get()));
		if(!childPolicyEnrollments.isPresent()) {
			throw new ChildPolicyEnrollmentException("No enrollment for this policy found");
		}
		
		return childPolicyEnrollments.get();
		
		
	}

	@Override
	public ChildPolicyEnrollment updateStatusOfEnrollment(Integer enrollmentId, ChildPolicyEnrollment childPolicyEnrollment) throws ChildPolicyEnrollmentException {
		Optional<ChildPolicyEnrollment> existingEnrollment = this.childPolicyEnrollmentRepository.findById(enrollmentId);
		if(!existingEnrollment.isPresent()) {
			throw new ChildPolicyEnrollmentException("No enrollment found for this id");
		}
		policyStatus status = childPolicyEnrollment.getStatus();
		
		existingEnrollment.get().setStatus(status);
		
		return existingEnrollment.get();
	}



	@Override
	public ChildPolicyEnrollment getEnrollmentById(Integer enrollmentId) throws ChildPolicyEnrollmentException {
		Optional<ChildPolicyEnrollment> childPolicyEnrollment = this.childPolicyEnrollmentRepository.findById(enrollmentId);
		if(!childPolicyEnrollment.isPresent()) {
			throw new ChildPolicyEnrollmentException("No enrollment found for this id");
		}
		return childPolicyEnrollment.get();
	}
	
//	@Override//
//	public boolean isChildEnrolledInPolicy(Integer childId, Integer policyId) {
//	    // Check if there is an enrollment with the same child and policy IDs
//	    Optional<ChildPolicyEnrollment> existingEnrollment = childPolicyEnrollmentRepository.findByChildIdAndPolicyId(childId, policyId);
//	    
//	    // If an enrollment exists, return true; otherwise, return false
//	    return existingEnrollment.isPresent();
//	}



}
