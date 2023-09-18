package com.capstone.child.insurance.system.service;

import com.capstone.child.insurance.system.entity.Admin;
import com.capstone.child.insurance.system.exceptions.AdminException;

public interface AdminService {
	
	Admin addAdmin(Admin newAdmin) throws AdminException;
	
	Admin getAdminById(Integer adminId) throws AdminException;
	
	Admin adminlogin(Admin newAdmin) throws AdminException;

}
