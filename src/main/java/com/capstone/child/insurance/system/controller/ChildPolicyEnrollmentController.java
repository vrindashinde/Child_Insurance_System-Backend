package com.capstone.child.insurance.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.PatchExchange;

import com.capstone.child.insurance.system.dao.ChildPolicyEnrollmentRepository;
import com.capstone.child.insurance.system.entity.ChildPolicyEnrollment;
import com.capstone.child.insurance.system.entity.ChildPolicyEnrollment.policyStatus;
import com.capstone.child.insurance.system.exceptions.ChildPolicyEnrollmentException;
import com.capstone.child.insurance.system.service.ChildPolicyEnrollmentService;
import jakarta.persistence.EntityNotFoundException;
import java.util.Collection;
import java.util.Optional;

@RestController
@CrossOrigin(allowedHeaders="*",origins = "*")
@RequestMapping("/api/childpolicyenrollments")
public class ChildPolicyEnrollmentController {
	@Autowired
	private ChildPolicyEnrollmentService childPolicyEnrollmentService;

	// Get all child policy enrollments

	@GetMapping("/{enrollmentId}") // done http://localhost:8082/api/childpolicyenrollments
	public ChildPolicyEnrollment getEnrollment(@PathVariable Integer enrollmentId)
			throws ChildPolicyEnrollmentException {
		try {
			return childPolicyEnrollmentService.getEnrollmentById(enrollmentId);
		} catch (ChildPolicyEnrollmentException e) {
			throw e;
		}
	}

	@GetMapping("/child/{childId}") // done http://localhost:8082/api/childpolicyenrollments
	public Collection<ChildPolicyEnrollment> getAllChildPolicyEnrollments(@PathVariable Integer childId)
			throws ChildPolicyEnrollmentException {
		try {
			return childPolicyEnrollmentService.getAllChildPolicyEnrollments(childId);
		} catch (ChildPolicyEnrollmentException e) {
			throw e;
		}
	}

	@GetMapping("/policy/{policyId}") // done http://localhost:8082/api/childpolicyenrollments
	public Collection<ChildPolicyEnrollment> getAllEnrollmentsByPolicyId(@PathVariable Integer policyId)
			throws ChildPolicyEnrollmentException {
		try {
			return childPolicyEnrollmentService.getAllEnrollmentsByPolicy(policyId);
		} catch (ChildPolicyEnrollmentException e) {
			throw e;
		}
	}

	// Create a new child policy enrollment
	@PostMapping("/{childId}/{policyId}") // done
	public ChildPolicyEnrollment createChildPolicyEnrollment(@PathVariable("childId") Integer childId,@PathVariable("policyId") Integer policyId,
			@RequestBody ChildPolicyEnrollment enrollment) throws ChildPolicyEnrollmentException {
		
//	    boolean isAlreadyEnrolled = childPolicyEnrollmentService.isChildEnrolledInPolicy(childId, policyId);
//
//	    if (isAlreadyEnrolled) {
//	        throw new ChildPolicyEnrollmentException("Child is already enrolled in this policy.");
//	    }
		
		try {
			return this.childPolicyEnrollmentService.addEnrollment(enrollment, childId, policyId);
		} catch (ChildPolicyEnrollmentException e) {
			throw e;
		}

	}

	// Change status of enrollment
	@PatchMapping("/{enrollmentId}/")
	public ChildPolicyEnrollment updateStatusOfEnrollment(@PathVariable Integer enrollmentId,@RequestBody ChildPolicyEnrollment childPolicyEnrollment)
			throws ChildPolicyEnrollmentException {

		try {
			return this.childPolicyEnrollmentService.updateStatusOfEnrollment(enrollmentId, childPolicyEnrollment);
		} catch (ChildPolicyEnrollmentException e) {
			throw e;
		}
	}
}
