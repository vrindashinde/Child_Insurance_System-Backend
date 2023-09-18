package com.capstone.child.insurance.system.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstone.child.insurance.system.entity.Parent;

public interface ParentRepository extends JpaRepository<Parent, Integer>{

	
	 Parent findByEmail(String email);
}
