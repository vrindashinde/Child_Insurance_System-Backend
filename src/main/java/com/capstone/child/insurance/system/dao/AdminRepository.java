package com.capstone.child.insurance.system.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.capstone.child.insurance.system.entity.Admin;
import com.capstone.child.insurance.system.entity.Parent;

public interface AdminRepository extends JpaRepository<Admin, Integer>{
	Admin findByEmail(String email);

}
