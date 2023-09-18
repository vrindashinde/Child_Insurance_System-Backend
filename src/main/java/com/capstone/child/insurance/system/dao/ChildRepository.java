package com.capstone.child.insurance.system.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import com.capstone.child.insurance.system.entity.Child;
import com.capstone.child.insurance.system.entity.EducationClaim;
import com.capstone.child.insurance.system.entity.EndowmentClaim;
import com.capstone.child.insurance.system.entity.HealthClaim;


public interface ChildRepository extends JpaRepository<Child, Integer>{
	
	Child findByHealthClaims(HealthClaim healthclaim);
	
	Child findByEducationClaims(EducationClaim educationclaim);

	Child findByEndowmentClaim(EndowmentClaim endowmentclaim);
}
