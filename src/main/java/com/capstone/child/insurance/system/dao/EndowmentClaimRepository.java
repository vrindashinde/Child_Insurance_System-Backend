package com.capstone.child.insurance.system.dao;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.capstone.child.insurance.system.entity.Child;
import com.capstone.child.insurance.system.entity.EndowmentClaim;

public interface EndowmentClaimRepository extends JpaRepository<EndowmentClaim, Integer>{
	Collection findAllByChild(Child child);
	
}
