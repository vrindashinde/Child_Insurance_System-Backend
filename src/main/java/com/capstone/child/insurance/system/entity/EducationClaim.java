package com.capstone.child.insurance.system.entity;

import java.time.LocalDate;

import java.util.*;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class EducationClaim {

	// Enums

	public enum educationApproval {
		Verifying, Approved, Declined
	}

	// Attributes

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer educationClaimId; // education claim id
	private String instituteName; // Educational institue name of child
	private Double annualFee; // Annual fee
	private Double transport; // Transport cost
	private Double material; // Educational material cost
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate claimDate; // Claim Date
	@Enumerated(EnumType.STRING)
	private educationApproval approval; // Claim has been approved or not
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate claimStatusDate; // Claim Date
	private String customMessage;
	
    @JsonIgnore
	@ManyToOne
	@JoinColumn(name = "childId")
	private Child child;

	@ManyToOne
	@JoinColumn(name = "policyId")
	private Policy policy;

	// Files

	@Lob
	private byte[] bonafide;
	@Lob
	private byte[] feeInvoice;
	@Lob
	private byte[] bills;
	@Lob
	private byte[] deathCertificate;

	// Constructors

	public EducationClaim() {
		super();
	}


	


	// Getters and setters

	public EducationClaim(String instituteName, Double annualFee, Double transport, Double material,
			LocalDate claimDate, educationApproval approval, LocalDate claimStatusDate, String customMessage,
			Child child, Policy policy, byte[] bonafide, byte[] feeInvoice, byte[] bills, byte[] deathCertificate) {
		super();
		this.instituteName = instituteName;
		this.annualFee = annualFee;
		this.transport = transport;
		this.material = material;
		this.claimDate = claimDate;
		this.approval = approval;
		this.claimStatusDate = claimStatusDate;
		this.customMessage = customMessage;
		this.child = child;
		this.policy = policy;
		this.bonafide = bonafide;
		this.feeInvoice = feeInvoice;
		this.bills = bills;
		this.deathCertificate = deathCertificate;
	}





	public Integer getEducationClaimId() {
		return educationClaimId;
	}

	public void setEducationClaimId(Integer educationClaimId) {
		this.educationClaimId = educationClaimId;
	}

	public String getInstituteName() {
		return instituteName;
	}

	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}

	public Double getAnnualFee() {
		return annualFee;
	}

	public void setAnnualFee(Double annualFee) {
		this.annualFee = annualFee;
	}

	public Double getTransport() {
		return transport;
	}

	public void setTransport(Double transport) {
		this.transport = transport;
	}

	public Double getMaterial() {
		return material;
	}

	public void setMaterial(Double material) {
		this.material = material;
	}

	public educationApproval getApproval() {
		return approval;
	}

	public void setApproval(educationApproval approval) {
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

	public byte[] getBonafide() {
		return bonafide;
	}

	public void setBonafide(byte[] bonafide) {
		this.bonafide = bonafide;
	}

	public byte[] getFeeInvoice() {
		return feeInvoice;
	}

	public void setFeeInvoice(byte[] feeInvoice) {
		this.feeInvoice = feeInvoice;
	}

	public byte[] getBills() {
		return bills;
	}

	public void setBills(byte[] bills) {
		this.bills = bills;
	}

	public byte[] getDeathCertificate() {
		return deathCertificate;
	}

	public void setDeathCertificate(byte[] deathCertificate) {
		this.deathCertificate = deathCertificate;
	}





	public LocalDate getClaimDate() {
		return claimDate;
	}





	public void setClaimDate(LocalDate claimDate) {
		this.claimDate = claimDate;
	}





	public LocalDate getClaimStatusDate() {
		return claimStatusDate;
	}





	public void setClaimStatusDate(LocalDate claimStatusDate) {
		this.claimStatusDate = claimStatusDate;
	}





	public String getCustomMessage() {
		return customMessage;
	}





	public void setCustomMessage(String customMessage) {
		this.customMessage = customMessage;
	}
	
	

}
