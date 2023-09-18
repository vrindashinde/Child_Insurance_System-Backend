package com.capstone.child.insurance.system.dao;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.capstone.child.insurance.system.entity.Child;
import com.capstone.child.insurance.system.entity.ChildPolicyEnrollment;
import com.capstone.child.insurance.system.entity.ChildPolicyEnrollment.policyStatus;
import com.capstone.child.insurance.system.entity.Policy;


public interface ChildPolicyEnrollmentRepository extends JpaRepository<ChildPolicyEnrollment, Integer>{
	 
	ChildPolicyEnrollment findAllByChildAndPolicyAndStatus(Child child, Policy policy, policyStatus status);
	
	Collection<ChildPolicyEnrollment> findAllByChild(Child child);

	Collection<ChildPolicyEnrollment> findAllByPolicy(Policy policy);

//	Optional<ChildPolicyEnrollment> findByChildIdAndPolicyId(Integer childId, Integer policyId);



	

}
