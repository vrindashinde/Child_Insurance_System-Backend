package com.capstone.child.insurance.system.service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.child.insurance.system.dao.ChildRepository;
import com.capstone.child.insurance.system.dao.ParentRepository;
import com.capstone.child.insurance.system.entity.Child;
import com.capstone.child.insurance.system.entity.EducationClaim;
import com.capstone.child.insurance.system.entity.EndowmentClaim;
import com.capstone.child.insurance.system.entity.HealthClaim;
import com.capstone.child.insurance.system.entity.Parent;
import com.capstone.child.insurance.system.exceptions.ChildException;
import com.capstone.child.insurance.system.exceptions.ParentException;


@Service 
public class ChildServiceImpl implements ChildService{
	
	@Autowired
	ChildRepository childRepository;

	@Autowired
	ParentRepository parentRepository;
	
	@Override
	public Child addChildByParentId(Integer parentId, Child newChild) throws ChildException {
		Optional<Parent> parentOpt = parentRepository.findById(parentId);
		if (!parentOpt.isPresent()) {
			throw new ChildException("Parent not found for id:" + parentId);
		}
		
		Parent parent = parentOpt.get();
		   newChild.setParent(parent);
			return childRepository.save(newChild);

	}




	@Override
	public Child updateChildByChildId(Child updatedChild, Integer parentId) throws ChildException {
		Optional<Child> childOpt = this.childRepository.findById(updatedChild.getChildId());
		if(!childOpt.isPresent())
			throw new ChildException("Child not found.");
		Optional<Parent> parentOpt = parentRepository.findById(parentId);
		if (!parentOpt.isPresent()) {
			throw new ChildException("Parent not found for id:" + parentId);}
		
		
		updatedChild.setParent(parentOpt.get());
		
		
		Optional <List<HealthClaim>> healthClaims= Optional.of(childOpt.get().getHealthClaims());
		if(!healthClaims.isPresent()) {
			updatedChild.setHealthClaims(null);
		}
		else {
			updatedChild.setHealthClaims(healthClaims.get());
			
		}
		
		Optional <List<EducationClaim>> educationClaims= Optional.of(childOpt.get().getEducationClaims());
		if(!educationClaims.isPresent()) {
			updatedChild.setEducationClaims(null);
		}
		else {
			updatedChild.setEducationClaims(educationClaims.get());
			
		}
		
		Optional <EndowmentClaim> endowmentClaim= Optional.of(childOpt.get().getEndowmentClaim());
		if(!endowmentClaim.isPresent()) {
			updatedChild.setEndowmentClaim(null);
		}
		else {
			updatedChild.setEndowmentClaim(endowmentClaim.get());
			
		}
		
		
		
		
		return this.childRepository.save(updatedChild);
	}

	


	@Override
	public Child getChildByChildId(Integer childId) throws ChildException {
		Optional<Child> childOpt = this.childRepository.findById(childId);
		if(!childOpt.isPresent())
			throw new ChildException("Child with Id " +childId+ "not found.");
		Child child = childOpt.get();
	
		return childOpt.get();
	}




	@Override
	public Collection<Child> getAllChildrenByParentId(Integer parentId) {
		
		Optional<Parent> parentOpt = parentRepository.findById(parentId);
		if (parentOpt.isPresent()) {
		   Parent parent = parentOpt.get();

			return parent.getChildren(); 
		}
		return Collections.emptyList();


	}




	@Override
	public boolean updateChildStatus(Integer childId, boolean active) throws ChildException{
	Optional<Child> childOpt = childRepository.findById(childId);
			
			if(!childOpt.isPresent())
			{
				throw  new ChildException("Child with ID " + childId + "not found.");
			}
			
			Child child = childOpt.get();
			child.setAccountActive(active);
			childRepository.save(child);
			return active;

	}

	
	





	


}
