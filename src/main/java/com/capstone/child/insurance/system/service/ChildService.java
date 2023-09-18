package com.capstone.child.insurance.system.service;

import java.util.Collection;

import com.capstone.child.insurance.system.entity.Child;
import com.capstone.child.insurance.system.exceptions.ChildException;
import com.capstone.child.insurance.system.exceptions.ParentException;

public interface ChildService {
	
	Child addChildByParentId(Integer parentId, Child newChild) throws ChildException;
	Child getChildByChildId(Integer childId) throws ChildException;

	Collection<Child> getAllChildrenByParentId(Integer id);
	
	Child updateChildByChildId(Child updatedChild, Integer parentId) throws ChildException;
	
	boolean updateChildStatus(Integer childId, boolean active) throws ChildException;
	
	
//	boolean updateChildStatus(Integer childId, boolean active);    
	
	
	

}
