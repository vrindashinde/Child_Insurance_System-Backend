package com.capstone.child.insurance.system.service;

import java.util.Collection;

import com.capstone.child.insurance.system.entity.Child;
import com.capstone.child.insurance.system.entity.ChildPolicyEnrollment;
import com.capstone.child.insurance.system.entity.EducationClaim;
import com.capstone.child.insurance.system.exceptions.EducationClaimException;




public interface EducationClaimService {
	

	EducationClaim addEducationClaim(EducationClaim newEducationClaim, Integer childId, Integer policyId) throws EducationClaimException;
	EducationClaim getEducationClaimById(Integer id) throws EducationClaimException;
	EducationClaim updateEducationClaimById(EducationClaim newEducationClaim, Integer childId, Integer policyId) throws EducationClaimException;
	EducationClaim updateEducationClaimStatus(Integer claimId, EducationClaim approvalStatus) throws EducationClaimException;
	
	Collection<EducationClaim> getChildEducationClaims(Integer childId) throws EducationClaimException; //For Child
	Collection<EducationClaim> getAllEducationClaimsForAdmin() throws EducationClaimException;     //For Admin
	

	Child getChildByEducationClaim(Integer claimId) throws EducationClaimException; 
	
	Collection<EducationClaim> getAllPendingEducationClaimsForAdmin() throws EducationClaimException;     //For Admin
	
}
