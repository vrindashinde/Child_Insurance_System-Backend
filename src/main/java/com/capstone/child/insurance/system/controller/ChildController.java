package com.capstone.child.insurance.system.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.child.insurance.system.entity.Child;
import com.capstone.child.insurance.system.exceptions.ChildException;
import com.capstone.child.insurance.system.service.ChildService;

//@CrossOrigin(origins="http://localhost:4200/child-registration")

@CrossOrigin(allowedHeaders="*" , origins = "*")
@RestController
@RequestMapping("/api/v1/parents/{parentId}/children")

public class ChildController {
	
	@Autowired
	ChildService childService;
	
	// Get child by Id
	@GetMapping("/child/{childId}")
	public Child getChildByChildId(@PathVariable("childId") Integer childId) throws ChildException {
		return this.childService.getChildByChildId(childId);
		
	}

	// Get all children for parentId
	@GetMapping("/getAllChildren/")
	public ResponseEntity<Collection<Child>> getAllChildrenByParentId(@PathVariable Integer parentId) {
		Collection<Child> children = childService.getAllChildrenByParentId(parentId);
		return ResponseEntity.ok(children);
	}
	
	
	// add child by parent Id
	@PostMapping
	public ResponseEntity<Child> addChildByParentId(@PathVariable Integer parentId , @RequestBody Child newChild) throws ChildException {
		Child addedChild = childService.addChildByParentId(parentId , newChild);
		return ResponseEntity.status(HttpStatus.CREATED).body(addedChild);
	}
	
	
	
	@PutMapping("/")
	public ResponseEntity<Child> updateChildByChildId(@PathVariable Integer parentId, @RequestBody Child child) throws ChildException {
		Child updateChild =  childService.updateChildByChildId(child,parentId);
//		
//		if(updateChild == null) {
//			return ResponseEntity.notFound().build();
//		}
		return ResponseEntity.ok(updateChild);
	}
	
	
	// Activate
	
	@PatchMapping("/{childId}/status")
	public ResponseEntity<Boolean> updateChildStatus(@PathVariable Integer childId , @RequestParam boolean active) throws ChildException {
	    boolean status = childService.updateChildStatus(childId , active);
	    return ResponseEntity.ok(status);
	}
	
	
	
}
