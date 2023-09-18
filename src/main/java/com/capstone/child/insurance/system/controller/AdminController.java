package com.capstone.child.insurance.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.capstone.child.insurance.system.entity.Admin;

import com.capstone.child.insurance.system.exceptions.AdminException;

import com.capstone.child.insurance.system.service.AdminService;


@CrossOrigin(origins="http://localhost:4200/")
@RequestMapping("/api/v1/admin")
@RestController
public class AdminController {
	

	@Autowired
     AdminService adminService;
	
	
	@GetMapping("/")
	public String greetAdmin() {
		return "Child Insurence Management System.";
	}
	
	
	// get by id
	
	@GetMapping("/{adminId}")
	public Admin getAdminById(@PathVariable("adminId") Integer adminId) throws AdminException {
		try {
		return this.adminService.getAdminById(adminId);}
		catch(AdminException e) {
			throw e;
		}
		
	}
	
	@PostMapping("/")
	public Admin addAdmin(@RequestBody Admin newAdmin) throws AdminException {
		try {
		return this.adminService.addAdmin(newAdmin);
		}
		catch(AdminException e) {
			throw e;
		}

	}
	
	
	
	
	// Admin LOGIN
    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public Admin loginAdmin(@RequestBody Admin admin) throws AdminException {
        try {
        	Admin findAdmin = this.adminService.adminlogin(admin);
            return findAdmin;
        }
        catch(AdminException e) {
			throw e;
        }

    }

}
