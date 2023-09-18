package com.capstone.child.insurance.system.service;

import java.util.Collection;

import com.capstone.child.insurance.system.entity.Child;
import com.capstone.child.insurance.system.entity.ChildPolicyEnrollment;
import com.capstone.child.insurance.system.entity.EducationClaim;
import com.capstone.child.insurance.system.entity.EndowmentClaim;
import com.capstone.child.insurance.system.exceptions.EducationClaimException;
import com.capstone.child.insurance.system.exceptions.EndowmentClaimException;
import com.capstone.child.insurance.system.exceptions.HealthClaimException;



public interface EndowmentClaimService {
	
	

	EndowmentClaim addEndowmentClaim(EndowmentClaim newEndowmentClaim, Integer childId, Integer policyId) throws EndowmentClaimException;
	EndowmentClaim getEndowmentClaimById(Integer id) throws EndowmentClaimException;
	
	
	Collection<EndowmentClaim> getChildEndowmentClaims(Integer childId) throws EndowmentClaimException; //For Child
	Collection<EndowmentClaim> getAllEndowmentClaimsForAdmin() throws EndowmentClaimException;     //For Admin

	Child getChildByEndowmentClaim(Integer claimId) throws EndowmentClaimException;
	
}
