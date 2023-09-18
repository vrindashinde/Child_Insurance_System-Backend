package com.capstone.child.insurance.system.controller;

import java.util.Collection;
import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.child.insurance.system.dao.PolicyRepository;
import com.capstone.child.insurance.system.entity.Policy;
import com.capstone.child.insurance.system.exceptions.PolicyException;
import com.capstone.child.insurance.system.service.PolicyService;

@RestController
@CrossOrigin(allowedHeaders="*",origins = "*")
@RequestMapping("/policies")
public class PolicyController {
	@Autowired
	private PolicyService policyService;

	@GetMapping("/{policyId}") // http://localhost:8082/policies/1
	public ResponseEntity<Policy> getPolicyById(@PathVariable Integer policyId) throws PolicyException {
		try {
			
			Policy policy = policyService.getPolicyById(policyId);
			return ResponseEntity.ok(policy);
		} catch (PolicyException e) {
			throw e;
		}
	}

	@PatchMapping("/{policyId}/status") // http://localhost:8082/policies/1/status?active=true
	public ResponseEntity<Boolean> updatePolicyStatus(@PathVariable Integer policyId, @RequestParam boolean active)
			throws PolicyException {
		boolean status = this.policyService.updatePolicyStatus(policyId, active);
		return ResponseEntity.ok(status);
	}

	// Add a new policy
	@PostMapping("/add") // http://localhost:8083/policies/add
	public ResponseEntity<Policy> addPolicy(@RequestBody Policy newPolicy) throws PolicyException {
		Policy addedPolicy = this.policyService.addPolicy(newPolicy);
		return new ResponseEntity<>(addedPolicy, HttpStatus.CREATED);
	}

	@GetMapping("/") // http://localhost:8083/policies/
	public ResponseEntity<Collection<Policy>> getAllPolicies() throws PolicyException {
		try {
			Collection<Policy> policies = policyService.getAllPolicies();
			return ResponseEntity.ok(policies);
		} catch (PolicyException e) {
			throw e;
		}
	}
}
