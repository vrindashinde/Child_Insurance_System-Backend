package com.capstone.child.insurance.system.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.capstone.child.insurance.system.entity.Policy;
import com.capstone.child.insurance.system.exceptions.PolicyException;



public interface PolicyService {
	

	Policy addPolicy(Policy newPolicy) throws PolicyException;

	Policy getPolicyById(Integer policyId) throws PolicyException;
	
	
    boolean updatePolicyStatus(Integer policyId, boolean active) throws PolicyException;

	Collection<Policy> getAllPolicies()throws PolicyException;
	

}
