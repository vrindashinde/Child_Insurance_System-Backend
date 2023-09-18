package com.capstone.child.insurance.system.entity;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Parent {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer parentId; // Parent id
	private String firstName; // Parent or guardian first name
	private String lastName; // Parent or guardian last name
	private String adhaar; // Parent or guardian adhaar
	private String address; // Parent or guardian address
	private String phone; // Parent or guardian phone
	private String email; // Parent or Guardian email
	private String password; // Account password
	private String bankName;
	private String accountNumber;
	private String ifscCode;
	private Boolean accountActive;
	private Integer status; //1 for admin and 0 for user

	@OneToMany(mappedBy = "parent")
	private List<Child> children = new ArrayList<>(); 

	public Parent() {
		super();
	}





	public Parent(String firstName, String lastName, String adhaar, String address, String phone, String email,
			String password, String bankName, String accountNumber, String ifscCode, Boolean accountActive,
			Integer status, List<Child> children) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.adhaar = adhaar;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.bankName = bankName;
		this.accountNumber = accountNumber;
		this.ifscCode = ifscCode;
		this.accountActive = accountActive;
		this.status = status;
		this.children = children;
	}





	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAdhaar() {
		return adhaar;
	}

	public void setAdhaar(String adhaar) {
		this.adhaar = adhaar;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Child> getChildren() {
		return children;
	}

	public void setChildren(List<Child> children) {
		this.children = children;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}


	public Boolean getAccountActive() {
		return accountActive;
	}


	public void setAccountActive(Boolean accountActive) {
		this.accountActive = accountActive;
	}





	public Integer getStatus() {
		return status;
	}





	public void setStatus(Integer status) {
		this.status = status;
	}



	
	

}
