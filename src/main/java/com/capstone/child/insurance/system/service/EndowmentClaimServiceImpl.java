package com.capstone.child.insurance.system.service;

import java.util.Collection;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.child.insurance.system.dao.ChildPolicyEnrollmentRepository;
import com.capstone.child.insurance.system.dao.ChildRepository;
import com.capstone.child.insurance.system.dao.EndowmentClaimRepository;
import com.capstone.child.insurance.system.dao.PolicyRepository;
import com.capstone.child.insurance.system.entity.Child;
import com.capstone.child.insurance.system.entity.ChildPolicyEnrollment;
import com.capstone.child.insurance.system.entity.EndowmentClaim;

import com.capstone.child.insurance.system.entity.Policy;

import com.capstone.child.insurance.system.entity.ChildPolicyEnrollment.policyStatus;
import com.capstone.child.insurance.system.exceptions.EndowmentClaimException;




@Service
public class EndowmentClaimServiceImpl implements EndowmentClaimService{
	
	@Autowired
	EndowmentClaimRepository endowmentClaimRepository;
	
	@Autowired
	ChildRepository childRepository;
	
	@Autowired
	PolicyRepository policyRepository;
	

	@Autowired
	ChildPolicyEnrollmentRepository childPolicyEnrollmentRepository;

	@Override
	public EndowmentClaim addEndowmentClaim(EndowmentClaim newEndowmentClaim, Integer childId, Integer policyId)
			throws EndowmentClaimException {
		Optional<Child> child = this.childRepository.findById(childId);
		if(!child.isPresent()) { throw new EndowmentClaimException("No child found");}
		
		Optional<Policy> policy = this.policyRepository.findById(policyId);
		if(!policy.isPresent()) {throw new EndowmentClaimException("No policy found");}
		
		Optional<ChildPolicyEnrollment> enrollment = Optional.ofNullable(this.childPolicyEnrollmentRepository.findAllByChildAndPolicyAndStatus(child.get(),policy.get(), policyStatus.Active));
		if(!enrollment.isPresent()) {throw new EndowmentClaimException("The user does not have an active enrollment in this policy");}
		
		newEndowmentClaim.setChild(child.get());
		newEndowmentClaim.setPolicy(policy.get());
	
		return this.endowmentClaimRepository.save(newEndowmentClaim);
		
	}

	@Override
	public EndowmentClaim getEndowmentClaimById(Integer id) throws EndowmentClaimException {
		Optional<EndowmentClaim> endowmentClaim = this.endowmentClaimRepository.findById(id);
		if (endowmentClaim == null) {
			throw new EndowmentClaimException("No Endowment Claim Found");
		}
		return endowmentClaim.get();
	}

	@Override
	public Collection<EndowmentClaim> getChildEndowmentClaims(Integer childId) throws EndowmentClaimException {
		Optional<Child> currentChild = this.childRepository.findById(childId);
		if (!currentChild.isPresent()) {
			throw new EndowmentClaimException("Child Not Found");
		}

		Optional<Collection> endowmentClaims = Optional.of(this.endowmentClaimRepository.findAllByChild(currentChild.get()));
		if (!endowmentClaims.isPresent()) {
			throw new EndowmentClaimException("No EndowmentClaims Found");
		}

		return endowmentClaims.get();
	}
	
	
	//GET ALL ENDOWMENT CLAIMS OF ALL USERS (FOR ADMIN)

	@Override
	public Collection<EndowmentClaim> getAllEndowmentClaimsForAdmin() throws EndowmentClaimException {
		
		Optional<Collection> endowmentClaims = Optional.of(this.endowmentClaimRepository.findAll());
		if (!endowmentClaims.isPresent()) {
			throw new EndowmentClaimException("No Endowment Claims Found");
		}

		return endowmentClaims.get();
		
		
		
	}

	@Override
	public Child getChildByEndowmentClaim(Integer claimId) throws EndowmentClaimException {
		Optional<EndowmentClaim> endowmentclaim = this.endowmentClaimRepository.findById(claimId);
		if (!endowmentclaim.isPresent()) {
			throw new EndowmentClaimException("No Endowment Claim Found");
		}
		
		Optional<Child> child = Optional.of(this.childRepository.findByEndowmentClaim(endowmentclaim.get()));
		
		
		return child.get();
		
		
		
		
		
		
	}
	

}
