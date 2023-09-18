package com.capstone.child.insurance.system.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.capstone.child.insurance.system.entity.Policy;

public interface PolicyRepository extends JpaRepository<Policy, Integer>{

}
