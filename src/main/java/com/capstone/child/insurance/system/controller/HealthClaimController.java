package com.capstone.child.insurance.system.controller;

import java.util.Collection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.child.insurance.system.entity.Child;
import com.capstone.child.insurance.system.entity.ChildPolicyEnrollment;
import com.capstone.child.insurance.system.entity.HealthClaim;
import com.capstone.child.insurance.system.entity.HealthClaim.healthApproval;
import com.capstone.child.insurance.system.exceptions.HealthClaimException;
import com.capstone.child.insurance.system.service.HealthClaimService;




@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class HealthClaimController {
	
//	Logger logger = LoggerFactory.getLogger(HealthClaimController.class);
	
	
	@Autowired
	HealthClaimService healthClaimservice;

	@GetMapping("/healthclaim/{id}")
	@ResponseStatus(HttpStatus.OK) 
	public HealthClaim getHealthClaimById(@PathVariable("id") Integer id) throws HealthClaimException {
		try {
			return this.healthClaimservice.getHealthClaimById(id);
		} catch (HealthClaimException e) {
			throw e;
		}

	}

	@PostMapping("/healthclaim/{childId}/{policyId}")
	@ResponseStatus(HttpStatus.OK) 
	public HealthClaim addNewHealthClaim(@RequestBody HealthClaim newhealthclaim, @PathVariable("childId") Integer childId,@PathVariable("policyId")Integer policyId) throws HealthClaimException {

		try {
			return this.healthClaimservice.addHealthClaim(newhealthclaim, childId, policyId);
		} catch (HealthClaimException e) {
			throw e;
		}
		
	}

	@PutMapping("/healthclaim/{childId}/{policyId}")
	@ResponseStatus(HttpStatus.OK) 
	public HealthClaim updateHealthClaimById(@RequestBody HealthClaim updateClaim, @PathVariable("childId") Integer childId,@PathVariable("policyId")Integer policyId) throws HealthClaimException {
		try {
			return this.healthClaimservice.updateHealthClaimById(updateClaim, childId, policyId);
		} catch (HealthClaimException e) {
			throw e;
		}

	}
	
	@PatchMapping("/healthclaim/approve/{claimId}")
	@ResponseStatus(HttpStatus.OK) 
	public HealthClaim updateHealthClaimStatus(@RequestBody HealthClaim approvalStatus, @PathVariable Integer claimId) throws HealthClaimException{
		try {
		return this.healthClaimservice.updateHealthClaimStatus(claimId, approvalStatus);}
		catch(HealthClaimException e) {
			throw e;
		}
	
	}
	

	@GetMapping("/healthclaims/{userId}")       //Of a particular user
	@ResponseStatus(HttpStatus.OK) 
	public Collection<HealthClaim> getUserHealthClaims(@PathVariable("userId") Integer id) throws HealthClaimException {
		try {
			return this.healthClaimservice.getChildHealthClaims(id);
		} catch (HealthClaimException e) {

			throw e;
		}
	}

	@GetMapping("/healthclaims")        //Of All Users
	@ResponseStatus(HttpStatus.OK) 
	public Collection<HealthClaim> getAllHealthClaims() throws HealthClaimException {
		try {
			return this.healthClaimservice.getAllHealthClaimsForAdmin();
		} catch (HealthClaimException e) {
			throw e;

		}
		
	}
	
	
	@GetMapping("/healthclaims/pending")        //Of All Users
	@ResponseStatus(HttpStatus.OK) 
	public Collection<HealthClaim> getAllPendingHealthClaims() throws HealthClaimException {
		try {
			return this.healthClaimservice.getAllPendingHealthClaimsForAdmin();
		} catch (HealthClaimException e) {
			throw e;

		}
	
	}
	
	@GetMapping("/healthclaim/child/{claimId}")        //Get Child By Health Claim
	@ResponseStatus(HttpStatus.OK) 
	public Child getChildByHealthClaim(@PathVariable("claimId") Integer claimId) throws HealthClaimException {
		try {
			return this.healthClaimservice.getChildByhealthClaim(claimId);
		} catch (HealthClaimException e) {

			throw e;
		}
	}
	
	@GetMapping("/enrollments/{childId}/{policyId}")
	@ResponseStatus(HttpStatus.OK) 
	public ChildPolicyEnrollment checkActiveEnrollments(@PathVariable("childId") Integer childId,@PathVariable("policyId")Integer policyId) throws HealthClaimException {

		try {
			return this.healthClaimservice.checkActiveEnrollments(childId, policyId);
		} catch (HealthClaimException e) {
			throw e;
		}
		
	}
	
	
	

}
