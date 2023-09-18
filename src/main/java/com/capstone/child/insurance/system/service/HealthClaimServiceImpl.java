package com.capstone.child.insurance.system.service;

import java.util.Collection;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.child.insurance.system.dao.ChildPolicyEnrollmentRepository;
import com.capstone.child.insurance.system.dao.ChildRepository;
import com.capstone.child.insurance.system.dao.HealthClaimRepository;
import com.capstone.child.insurance.system.dao.PolicyRepository;
import com.capstone.child.insurance.system.entity.Child;
import com.capstone.child.insurance.system.entity.ChildPolicyEnrollment;
import com.capstone.child.insurance.system.entity.ChildPolicyEnrollment.policyStatus;
import com.capstone.child.insurance.system.entity.HealthClaim;
import com.capstone.child.insurance.system.entity.HealthClaim.healthApproval;
import com.capstone.child.insurance.system.entity.Policy;
import com.capstone.child.insurance.system.exceptions.HealthClaimException;


@Service
public class HealthClaimServiceImpl implements HealthClaimService {

	@Autowired
	HealthClaimRepository healthClaimRepository;

	@Autowired
	ChildRepository childRepository;
	
	@Autowired
	PolicyRepository policyRepository;
	
	@Autowired
	ChildPolicyEnrollmentRepository childPolicyEnrollmentRepository;

	
	//ADD HEALTH CLAIM BY USER ID, POLICY ID

	@Override
	public HealthClaim addHealthClaim(HealthClaim newHealthClaim, Integer childId, Integer policyId ) throws HealthClaimException {
		Optional<Child> child = this.childRepository.findById(childId);
		if(!child.isPresent()) { throw new HealthClaimException("No child found");}
		
		Optional<Policy> policy = this.policyRepository.findById(policyId);
		if(!policy.isPresent()) {throw new HealthClaimException("No policy found");}
		
		Optional<ChildPolicyEnrollment> enrollment = Optional.ofNullable(this.childPolicyEnrollmentRepository.findAllByChildAndPolicyAndStatus(child.get(),policy.get(), policyStatus.Active));
		if(!enrollment.isPresent()) {throw new HealthClaimException("The user does not have an active enrollment in this policy");}
		
		newHealthClaim.setChild(child.get());
		newHealthClaim.setPolicy(policy.get());
	
		return this.healthClaimRepository.save(newHealthClaim);
	}
	
	//GET HEALTH CLAIM BY HEALTH CLAIM ID

	@Override
	public HealthClaim getHealthClaimById(Integer id) throws HealthClaimException {
		Optional<HealthClaim> healthClaim = this.healthClaimRepository.findById(id);
		if (healthClaim == null) {
			throw new HealthClaimException("No Health Claim Found");
		}
		return healthClaim.get();
	}
	
	//UPDATE HEALTH CLAIM BY HEALTH CLAIM ID, CHILD ID AND POLICY ID

	@Override
	public HealthClaim updateHealthClaimById(HealthClaim newHealthClaim, Integer childId, Integer policyId) throws HealthClaimException {
		
		Integer id = newHealthClaim.getHealthClaimId();
		
		Optional<HealthClaim> healthClaim = this.healthClaimRepository.findById(id);
		if (!healthClaim.isPresent()) {
			throw new HealthClaimException("No Health Claim Found");
		}
		HealthClaim updatehealthClaim = healthClaim.get();
		if(updatehealthClaim.getApproval() != healthApproval.Verifying) {
			throw new HealthClaimException("This claim can no longer be updated.");
		}
		Optional<Child> child = this.childRepository.findById(childId);
		if(!child.isPresent()) { throw new HealthClaimException("No child found");}
		
		Optional<Policy> policy = this.policyRepository.findById(policyId);
		if(!policy.isPresent()) {throw new HealthClaimException("No policy found");}
		
		newHealthClaim.setChild(child.get());
		newHealthClaim.setPolicy(policy.get());
		
		return this.healthClaimRepository.save(newHealthClaim);
	}
	
	//UPDATE CLAIM STATUS (FOR ADMIN)
	
	@Override
	public HealthClaim updateHealthClaimStatus(Integer claimId, HealthClaim approvalStatus) throws HealthClaimException {
		
		Optional<HealthClaim> healthClaim = this.healthClaimRepository.findById(claimId);
		if (!healthClaim.isPresent()) {
			throw new HealthClaimException("No Health Claim Found");
		}
		
		HealthClaim updateStatusHealthClaim = healthClaim.get();
		updateStatusHealthClaim.setApproval(approvalStatus.getApproval());
		updateStatusHealthClaim.setCustomMessage(approvalStatus.getCustomMessage());
		
		return this.healthClaimRepository.save(updateStatusHealthClaim);
	}


	//GET ALL HEALTH CLAIMS BY CHILD ID
	
	@Override
	public Collection<HealthClaim> getChildHealthClaims(Integer childId) throws HealthClaimException {
		Optional<Child> currentChild = this.childRepository.findById(childId);
		if (!currentChild.isPresent()) {
			throw new HealthClaimException("Child Not Found");
		}

		Optional<Collection> healthClaims = Optional.of(this.healthClaimRepository.findAllByChild(currentChild.get()));
		if (!healthClaims.isPresent()) {
			throw new HealthClaimException("No HealthClaims Found");
		}

		return healthClaims.get();

	}
	
	//GET ALL HEALTH CLAIMS OF ALL USERS (FOR ADMIN)

	@Override
	public Collection<HealthClaim> getAllHealthClaimsForAdmin() throws HealthClaimException {

		Optional<Collection> healthClaims = Optional.of(this.healthClaimRepository.findAll());
		if (!healthClaims.isPresent()) {
			throw new HealthClaimException("No HealthClaims Found");
		}

		return healthClaims.get();
	}
	//GET CHILD BY HEALTHCLAIM (FOR ADMIN)

	@Override
	public Child getChildByhealthClaim(Integer claimId) throws HealthClaimException {
		
		Optional<HealthClaim> healtclaim = this.healthClaimRepository.findById(claimId);
		if (!healtclaim.isPresent()) {
			throw new HealthClaimException("No HealthClaim Found");
		}
		
		Optional<Child> child = Optional.of(this.childRepository.findByHealthClaims(healtclaim.get()));
		
		
		return child.get();
	}

	//GET VERIFICATION PENDING HEALTHCLAIMS (FOR ADMIN)
	
	@Override
	public Collection<HealthClaim> getAllPendingHealthClaimsForAdmin() throws HealthClaimException {
		Optional<Collection> healthClaims = Optional.of(this.healthClaimRepository.findAllByApproval(healthApproval.Verifying));
		if (!healthClaims.isPresent()) {
			throw new HealthClaimException("No Pending HealthClaim Found For Verification");
		}

		return healthClaims.get();
	}

	@Override
	public ChildPolicyEnrollment checkActiveEnrollments(Integer childId, Integer policyId) throws HealthClaimException {
		Optional<Child> child = this.childRepository.findById(childId);
		if(!child.isPresent()) { throw new HealthClaimException("No child found");}
		
		Optional<Policy> policy = this.policyRepository.findById(policyId);
		if(!policy.isPresent()) {throw new HealthClaimException("No policy found");}
		
		Optional<ChildPolicyEnrollment> enrollment = Optional.ofNullable(this.childPolicyEnrollmentRepository.findAllByChildAndPolicyAndStatus(child.get(),policy.get(), policyStatus.Active));
		if(!enrollment.isPresent()) {throw new HealthClaimException("The user does not have an active enrollment in this policy");}
		
		return enrollment.get();
	}


}
