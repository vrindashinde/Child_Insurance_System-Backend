package com.capstone.child.insurance.system.dao;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.capstone.child.insurance.system.entity.Child;
import com.capstone.child.insurance.system.entity.HealthClaim;
import com.capstone.child.insurance.system.entity.HealthClaim.healthApproval;

public interface HealthClaimRepository extends JpaRepository<HealthClaim, Integer>{

	  Collection findAllByChild(Child child);
	Collection findAllByApproval(healthApproval approval);
}
