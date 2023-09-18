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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.capstone.child.insurance.system.entity.Parent;
import com.capstone.child.insurance.system.exceptions.ParentException;
import com.capstone.child.insurance.system.service.ParentService;

//@CrossOrigin(origins="http://localhost:4200/")

@CrossOrigin(allowedHeaders="*" , origins = "*")
@RestController
@RequestMapping("/api/v1/user")
public class ParentController {
	
	@Autowired
	ParentService parentService;

	
	// Demo
	
	@GetMapping("/")
	public String greet() {
		return "Child Insurence Management System.";
	}
	
	// ADMIN

	@PostMapping("/")
	public String createAdmin(@RequestBody Parent parent) {
		this.parentService.save(parent);
		return "Welcome to Child Insurance Management System.";
	}
	

	
	// PARENT
	
	@PostMapping("/parent/")
	public Parent addParent(@RequestBody Parent newParent) throws ParentException {
		try {
		return this.parentService.addParent(newParent);
		}
		catch(ParentException e) {
			throw e;
		}

	}
	

	@GetMapping("/parent/{parentId}")
	public Parent getParentById(@PathVariable("parentId") Integer parentId) throws ParentException {
		try {
		return this.parentService.getParentById(parentId);}
		catch(ParentException e) {
			throw e;
		}
		
	}
	
	@PutMapping("/parent/{parentId}")
	public ResponseEntity<Parent> updateParent(@PathVariable("parentId") Integer parentId , @RequestBody Parent parent) throws ParentException {
		Parent updateParent = parentService.updateParent(parent);
		
		if(updateParent == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(updateParent);
	}
	

	
	@PatchMapping("/{parentId}/status")
	public ResponseEntity<Boolean> updateParentStatus(@PathVariable Integer parentId , @RequestParam boolean active) throws ParentException {
	    boolean status = parentService.updateParentStatus(parentId , active);
	    return ResponseEntity.ok(status);
	}
	
	
	
	@GetMapping("/getAllParents/")
	@ResponseStatus(HttpStatus.OK)
	public Collection<Parent> getAllParents() {
		Collection<Parent> parentCollection = this.parentService.getAllParents();
		return parentCollection;
	}
	
	
	
	
	// PARENT LOGIN
    @PostMapping("/parent/login")
    @ResponseStatus(HttpStatus.OK)
    public Parent loginParent(@RequestBody Parent parent) throws ParentException {
        try {
            Parent findParent = this.parentService.login(parent);
            return findParent;
        }
        catch(ParentException e) {
			throw e;
        }

    }
}
