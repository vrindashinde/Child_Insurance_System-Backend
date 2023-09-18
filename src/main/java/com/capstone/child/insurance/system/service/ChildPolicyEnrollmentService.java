package com.capstone.child.insurance.system.service;

import java.util.Collection;

import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;

import com.capstone.child.insurance.system.entity.ChildPolicyEnrollment;
import com.capstone.child.insurance.system.entity.ChildPolicyEnrollment.policyStatus;
import com.capstone.child.insurance.system.exceptions.ChildPolicyEnrollmentException;

public interface ChildPolicyEnrollmentService {

	ChildPolicyEnrollment addEnrollment(ChildPolicyEnrollment enrollment, Integer childId, Integer policyId)
			throws ChildPolicyEnrollmentException;

	Collection<ChildPolicyEnrollment> getAllChildPolicyEnrollments(Integer childId)
			throws ChildPolicyEnrollmentException;

	Collection<ChildPolicyEnrollment> getAllEnrollmentsByPolicy(Integer policyId) throws ChildPolicyEnrollmentException;

	ChildPolicyEnrollment updateStatusOfEnrollment(Integer enrollmentId, ChildPolicyEnrollment childPolicyEnrollment)
			throws ChildPolicyEnrollmentException;

	ChildPolicyEnrollment getEnrollmentById(Integer enrollmentId) throws ChildPolicyEnrollmentException;

//	boolean isChildEnrolledInPolicy(Integer childId, Integer policyId);

}
