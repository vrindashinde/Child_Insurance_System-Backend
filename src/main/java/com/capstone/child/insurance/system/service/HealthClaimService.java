package com.capstone.child.insurance.system.service;

import java.util.Collection;

import com.capstone.child.insurance.system.entity.Child;
import com.capstone.child.insurance.system.entity.ChildPolicyEnrollment;
import com.capstone.child.insurance.system.entity.HealthClaim;
import com.capstone.child.insurance.system.exceptions.HealthClaimException;


public interface HealthClaimService {
	
	HealthClaim addHealthClaim(HealthClaim newHealthClaim, Integer childId, Integer policyId) throws HealthClaimException;
	HealthClaim getHealthClaimById(Integer id) throws HealthClaimException;
	HealthClaim updateHealthClaimById(HealthClaim newHealthClaim, Integer childId, Integer policyId) throws HealthClaimException;
	HealthClaim updateHealthClaimStatus(Integer claimId, HealthClaim approvalStatus) throws HealthClaimException;
	
	Collection<HealthClaim> getChildHealthClaims(Integer childId) throws HealthClaimException; //For Child
	Collection<HealthClaim> getAllHealthClaimsForAdmin() throws HealthClaimException;     //For Admin
	
	Child getChildByhealthClaim(Integer claimId) throws HealthClaimException; 
	
	Collection<HealthClaim> getAllPendingHealthClaimsForAdmin() throws HealthClaimException;     //For Admin
	
	ChildPolicyEnrollment checkActiveEnrollments(Integer childId, Integer policyId) throws HealthClaimException;

}
