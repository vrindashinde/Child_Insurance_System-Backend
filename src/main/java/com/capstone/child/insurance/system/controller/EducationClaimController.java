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
import com.capstone.child.insurance.system.entity.EducationClaim;

import com.capstone.child.insurance.system.exceptions.EducationClaimException;

import com.capstone.child.insurance.system.service.EducationClaimService;




@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class EducationClaimController {

	@Autowired
	EducationClaimService educationClaimService;
	
	
	@GetMapping("/educationclaim/{id}")
	public EducationClaim getEducationClaimById(@PathVariable("id") Integer id) throws EducationClaimException {
		try {
			return this.educationClaimService.getEducationClaimById(id);
		} catch (EducationClaimException e) {
			throw e;
		}

	}

	@PostMapping("/educationclaim/{childId}/{policyId}")
	public EducationClaim addNewEducationClaim(@RequestBody EducationClaim neweducationclaim,  @PathVariable("childId") Integer childId,@PathVariable("policyId")Integer policyId) throws EducationClaimException {

		try {
			return this.educationClaimService.addEducationClaim(neweducationclaim, childId, policyId);
		} catch (EducationClaimException e) {
			throw e;
		}
		
	}
	
	
	

	@PutMapping("/educationclaim/{childId}/{policyId}")
	public EducationClaim updateEducationClaimById(@RequestBody EducationClaim updateClaim,  @PathVariable("childId") Integer childId,@PathVariable("policyId")Integer policyId) throws EducationClaimException {
		try {
			return this.educationClaimService.updateEducationClaimById(updateClaim, childId, policyId);
		} catch (EducationClaimException e) {
			throw e;
		}

	}
	
	@PatchMapping("/educationclaim/approve/{claimId}")
	public EducationClaim updateEducationClaimStatus(@RequestBody EducationClaim approvalStatus, @PathVariable Integer claimId) throws EducationClaimException{
		try {
		return this.educationClaimService.updateEducationClaimStatus(claimId, approvalStatus);}
		catch(EducationClaimException e) {
			throw e;
		}
	
	}
	

	@GetMapping("/educationclaims/{userId}")
	public Collection<EducationClaim> getUserEducationClaims(@PathVariable("userId") Integer id) throws EducationClaimException {
		try {
			return this.educationClaimService.getChildEducationClaims(id);
		} catch (EducationClaimException e) {

			throw e;
		}
	}

	@GetMapping("/educationclaims")
	public Collection<EducationClaim> getAllEducationClaims() throws EducationClaimException {
		try {
			return this.educationClaimService.getAllEducationClaimsForAdmin();
		} catch (EducationClaimException e) {
			throw e;

		}

	}
	
	
	
	@GetMapping("/educationclaims/pending")        //Of All Users
	@ResponseStatus(HttpStatus.OK) 
	public Collection<EducationClaim> getAllPendingEducationClaims() throws EducationClaimException {
		try {
			return this.educationClaimService.getAllPendingEducationClaimsForAdmin();
		} catch (EducationClaimException e) {
			throw e;

		}
	
	}
	
	
	

	@GetMapping("/educationclaim/child/{claimId}")        //Get Child By Education Claim
	@ResponseStatus(HttpStatus.OK) 
	public Child getChildByEducationClaim(@PathVariable("claimId") Integer claimId) throws EducationClaimException {
		try {
			return this.educationClaimService.getChildByEducationClaim(claimId);
		} catch (EducationClaimException e) {

			throw e;
		}
	}
	
}
