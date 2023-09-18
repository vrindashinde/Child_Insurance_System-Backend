package com.capstone.child.insurance.system.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.child.insurance.system.dao.ChildPolicyEnrollmentRepository;
import com.capstone.child.insurance.system.dao.ChildRepository;
import com.capstone.child.insurance.system.dao.EducationClaimRepository;
import com.capstone.child.insurance.system.dao.PolicyRepository;
import com.capstone.child.insurance.system.entity.Child;
import com.capstone.child.insurance.system.entity.ChildPolicyEnrollment;
import com.capstone.child.insurance.system.entity.EducationClaim;

import com.capstone.child.insurance.system.entity.EducationClaim.educationApproval;

import com.capstone.child.insurance.system.entity.Policy;
import com.capstone.child.insurance.system.entity.ChildPolicyEnrollment.policyStatus;
import com.capstone.child.insurance.system.exceptions.EducationClaimException;





@Service
public class EducationClaimServiceImpl implements EducationClaimService{
	@Autowired
	EducationClaimRepository educationClaimRepository;
	
	@Autowired
	ChildRepository childRepository;
	
	@Autowired
	PolicyRepository policyRepository;
	

	@Autowired
	ChildPolicyEnrollmentRepository childPolicyEnrollmentRepository;
	

	//ADD EDUCATION CLAIM BY USER ID, POLICY ID
	
	@Override
	public EducationClaim addEducationClaim(EducationClaim newEducationClaim, Integer childId, Integer policyId) throws EducationClaimException {
		Optional<Child> child = this.childRepository.findById(childId);
		if(!child.isPresent()) { throw new EducationClaimException("No child found");}
		
		Optional<Policy> policy = this.policyRepository.findById(policyId);
		if(!policy.isPresent()) {throw new EducationClaimException("No policy found");}
		
		Optional<ChildPolicyEnrollment> enrollment = Optional.ofNullable(this.childPolicyEnrollmentRepository.findAllByChildAndPolicyAndStatus(child.get(),policy.get(), policyStatus.Active));
		if(!enrollment.isPresent()) {throw new EducationClaimException("The user does not have an active enrollment in this policy");}
		
		newEducationClaim.setChild(child.get());
		newEducationClaim.setPolicy(policy.get());
	
		return this.educationClaimRepository.save(newEducationClaim);
		
	}
	

	
	
	//GET EDUCATION CLAIM BY EDUCATION CLAIM ID

	@Override
	public EducationClaim getEducationClaimById(Integer id) throws EducationClaimException {
		Optional<EducationClaim> educationClaim = this.educationClaimRepository.findById(id);
		if (!educationClaim.isPresent()) {
			throw new EducationClaimException("No Education Claim Found");
		}
		return educationClaim.get();
	}
	
	
	//UPDATE EDUCATION CLAIM BY EDUCATION CLAIM ID, CHILD ID AND POLICY ID

	@Override
	public EducationClaim updateEducationClaimById(EducationClaim newEducationClaim, Integer childId, Integer policyId)
			throws EducationClaimException {
		

		Integer id = newEducationClaim.getEducationClaimId();
		
		Optional<EducationClaim> educationClaim = this.educationClaimRepository.findById(id);
		if (!educationClaim.isPresent()) {
			throw new EducationClaimException("No Education Claim Found");
		}
		EducationClaim updateEducationClaim = educationClaim.get();
		if(updateEducationClaim.getApproval() != educationApproval.Verifying) {
			throw new EducationClaimException("This claim can no longer be updated.");
		}
		Optional<Child> child = this.childRepository.findById(childId);
		if(!child.isPresent()) { throw new EducationClaimException("No child found");}
		
		Optional<Policy> policy = this.policyRepository.findById(policyId);
		if(!policy.isPresent()) {throw new EducationClaimException("No policy found");}
		
		newEducationClaim.setChild(child.get());
		newEducationClaim.setPolicy(policy.get());
		
		return this.educationClaimRepository.save(newEducationClaim);
	}
	
	//UPDATE CLAIM STATUS (FOR ADMIN)

	@Override
	public EducationClaim updateEducationClaimStatus(Integer claimId, EducationClaim approvalStatus)
			throws EducationClaimException {
		Optional<EducationClaim> educationClaim = this.educationClaimRepository.findById(claimId);
		if (!educationClaim.isPresent()) {
			throw new EducationClaimException("No Education Claim Found");
		}
		
		
		EducationClaim updateStatusEducationClaim = educationClaim.get();
		updateStatusEducationClaim.setApproval(approvalStatus.getApproval());
		
		updateStatusEducationClaim.setCustomMessage(approvalStatus.getCustomMessage());
		
		return this.educationClaimRepository.save(updateStatusEducationClaim);
		
	}
	
	//GET ALL EDUCATION CLAIMS BY CHILD ID

	@Override
	public Collection<EducationClaim> getChildEducationClaims(Integer childId) throws EducationClaimException {
		Optional<Child> currentChild = this.childRepository.findById(childId);
		if (!currentChild.isPresent()) {
			throw new EducationClaimException("Child Not Found");
		}

		Optional<Collection> educationClaims = Optional.of(this.educationClaimRepository.findAllByChild(currentChild.get()));
		if (!educationClaims.isPresent()) {
			throw new EducationClaimException("No Education Claims Found");
		}

		return educationClaims.get();
	}
	
	//GET ALL EDUCATION CLAIMS OF ALL USERS (FOR ADMIN)

	@Override
	public Collection<EducationClaim> getAllEducationClaimsForAdmin() throws EducationClaimException {
		Optional<Collection> educationClaims = Optional.of(this.educationClaimRepository.findAll());
		if (!educationClaims.isPresent()) {
			throw new EducationClaimException("No Education Claims Found");
		}

		return educationClaims.get();
	}


	@Override
	public Child getChildByEducationClaim(Integer claimId) throws EducationClaimException {
		
		Optional<EducationClaim> educationclaim = this.educationClaimRepository.findById(claimId);
		if (!educationclaim.isPresent()) {
			throw new EducationClaimException("No EducationClaim Found");
		}
		
		Optional<Child> child = Optional.of(this.childRepository.findByEducationClaims(educationclaim.get()));
		
		
		return child.get();
	}


	@Override
	public Collection<EducationClaim> getAllPendingEducationClaimsForAdmin() throws EducationClaimException {
		

		Optional<Collection> educationClaims = Optional.of(this.educationClaimRepository.findAllByApproval(educationApproval.Verifying));
		if (!educationClaims.isPresent()) {
			throw new EducationClaimException("No Pending Education Claim Found For Verification");
		}

		return educationClaims.get();
		
			
	}



	

}
