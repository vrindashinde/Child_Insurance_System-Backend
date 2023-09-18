package com.capstone.child.insurance.system.service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.child.insurance.system.dao.PolicyRepository;
import com.capstone.child.insurance.system.entity.Policy;
import com.capstone.child.insurance.system.exceptions.PolicyException;

@Service
public class PolicyServiceImpl implements PolicyService {

	@Autowired
	private PolicyRepository policyRepository;


	@Override
	public Policy getPolicyById(Integer policyId) throws PolicyException{
        
		Optional<Policy> policy = this.policyRepository.findById(policyId);
		if(!policy.isPresent()) {
			throw new PolicyException("No Policy with given id found");
		}
        return policy.get();
    }
	
	@Override
    public boolean updatePolicyStatus(Integer policyId, boolean active) throws PolicyException {
        Optional<Policy> policyOpt = policyRepository.findById(policyId);

        if (!policyOpt.isPresent()) {
            throw new PolicyException("Policy with ID " + policyId + " not found.");
        }

        Policy policy = policyOpt.get();
        policy.setPolicyActive(active);
        policyRepository.save(policy);
        return active;
    }

	@Override
	public Policy addPolicy(Policy newPolicy) {
		return this.policyRepository.save(newPolicy);

	}

	@Override
	public Collection<Policy> getAllPolicies() throws PolicyException {
		
		Optional<Collection<Policy>> policies = Optional.of(this.policyRepository.findAll());
		if(!policies.isPresent()) {
			throw new PolicyException("No Policies Found");
		}
		
		return policies.get();
	}


}
