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


import com.capstone.child.insurance.system.entity.EndowmentClaim;

import com.capstone.child.insurance.system.exceptions.EndowmentClaimException;

import com.capstone.child.insurance.system.service.EndowmentClaimService;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class EndowmentClaimController {
	@Autowired
	EndowmentClaimService endowmentClaimService;
	
	@GetMapping("/endowmentclaim/{id}")
	public EndowmentClaim getEndowmentClaimById(@PathVariable("id") Integer id) throws EndowmentClaimException {
		try {
			return this.endowmentClaimService.getEndowmentClaimById(id);
		} catch (EndowmentClaimException e) {
			throw e;
		}

	}

	@PostMapping("/endowmentclaim/{childId}/{policyId}")
	public EndowmentClaim addNewEndowmentClaim(@RequestBody EndowmentClaim newEndowmentclaim, @PathVariable("childId") Integer childId,@PathVariable("policyId")Integer policyId) throws EndowmentClaimException {

		try {
			return this.endowmentClaimService.addEndowmentClaim(newEndowmentclaim, childId, policyId);
		} catch (EndowmentClaimException e) {
			throw e;
		}
		
	}
	
	
	@GetMapping("/endowmentclaims/{userId}")     //Of a Particular User
	public Collection<EndowmentClaim> getUserEndowmentClaims(@PathVariable("userId") Integer id) throws EndowmentClaimException {
		try {
			return this.endowmentClaimService.getChildEndowmentClaims(id);
		} catch (EndowmentClaimException e) {

			throw e;
		}
	}

	@GetMapping("/endowmentclaims")        //Of All Users
	public Collection<EndowmentClaim> getAllEndowmentClaims() throws EndowmentClaimException {
		try {
			return this.endowmentClaimService.getAllEndowmentClaimsForAdmin();
		} catch (EndowmentClaimException e) {
			throw e;

		}
		
	}

}
