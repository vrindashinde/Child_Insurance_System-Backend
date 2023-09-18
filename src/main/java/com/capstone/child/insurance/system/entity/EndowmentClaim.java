package com.capstone.child.insurance.system.entity;

import java.time.LocalDate;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;


@Entity
public class EndowmentClaim {
	

	// Enums

	public enum endowmentApproval {
		 Approved, Declined
	}
	
	//Attributes

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer endowmentClaimId; // endowment claim id
	private Integer childAge; // Child age
	
	private Integer coverAmount;
	
	@Enumerated(EnumType.STRING)
	private endowmentApproval approval;             //Claim has been approved or not
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate claimDate; // Claim Date
	
	 @JsonIgnore
    @OneToOne
    @JoinColumn(name = "childId")
    private Child child;

    @ManyToOne
    @JoinColumn(name = "policyId")
    private Policy policy;
    
    private String customMessage;
	
	//Constructors
	
	public EndowmentClaim() {
		super();
	}
	
	
	
	


	//Getters and setters

	public EndowmentClaim(Integer childAge, endowmentApproval approval, LocalDate claimDate, Child child,
			Policy policy) {
		super();
		this.childAge = childAge;
		this.approval = approval;
		this.claimDate = claimDate;
		this.child = child;
		this.policy = policy;
	}






	public LocalDate getClaimDate() {
		return claimDate;
	}






	public void setClaimDate(LocalDate claimDate) {
		this.claimDate = claimDate;
	}






	public Integer getEndowmentClaimId() {
		return endowmentClaimId;
	}

	public void setEndowmentClaimId(Integer endowmentClaimId) {
		this.endowmentClaimId = endowmentClaimId;
	}

	public Integer getChildAge() {
		return childAge;
	}

	public void setChildAge(Integer childAge) {
		this.childAge = childAge;
	}

	public endowmentApproval getApproval() {
		return approval;
	}

	public void setApproval(endowmentApproval approval) {
		this.approval = approval;
	}

	public Child getChild() {
		return child;
	}

	public void setChild(Child child) {
		this.child = child;
	}

	public Policy getPolicy() {
		return policy;
	}

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}
	
	






}
