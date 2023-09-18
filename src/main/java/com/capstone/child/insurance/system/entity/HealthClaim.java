package com.capstone.child.insurance.system.entity;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

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

@Entity
public class HealthClaim {

	// Enums

	public enum healthApproval {
		Verifying, Approved, Declined
	}

	// Atrributes

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer healthClaimId; // health claim id
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate incidenceDate; // Date of Incidence
	private String hospitalName; // Hospital Name
	private String roomCategory; // Room Category Occupied
	private String reason; // Hospitalization due to
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate admitDate; // Date of admission
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate dischargeDate; // Date of discharge
	private Double preHospitalExpenses; // Pre-hospital expenses
	private Double hospitalExpenses; // Hospital expenses
	private Double postHospitalExpenses; // Post-hospital expenses
	private Double ambulanceExpenses; // Ambulance expenses
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate claimDate; // Claim Date
	@Enumerated(EnumType.STRING)
	private healthApproval approval; // Claim has been approved or not
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate claimStatusDate; // Claim Date
	private String customMessage;
	
	


    @JsonIgnore
	@ManyToOne
	@JoinColumn(name = "childId")
	private Child child;
    
   
	@ManyToOne
	@JoinColumn(name = "policyId")
	private Policy policy;

	// Documents

	@Lob
	private byte[] hospitalBill;

	@Lob
	private byte[] doctorPrescribtion;

	@Lob
	private byte[] dischargeDocuments;

	@Lob
	private byte[] ambulanceBill;

	// Constructors

	public HealthClaim() {
		super();
	}

	

	// Getters and Setters

	


	public HealthClaim(LocalDate incidenceDate, String hospitalName, String roomCategory, String reason,
			LocalDate admitDate, LocalDate dischargeDate, Double preHospitalExpenses, Double hospitalExpenses,
			Double postHospitalExpenses, Double ambulanceExpenses, LocalDate claimDate, healthApproval approval,
			LocalDate claimStatusDate, String customMessage, Child child, Policy policy, byte[] hospitalBill,
			byte[] doctorPrescribtion, byte[] dischargeDocuments, byte[] ambulanceBill) {
		super();
		this.incidenceDate = incidenceDate;
		this.hospitalName = hospitalName;
		this.roomCategory = roomCategory;
		this.reason = reason;
		this.admitDate = admitDate;
		this.dischargeDate = dischargeDate;
		this.preHospitalExpenses = preHospitalExpenses;
		this.hospitalExpenses = hospitalExpenses;
		this.postHospitalExpenses = postHospitalExpenses;
		this.ambulanceExpenses = ambulanceExpenses;
		this.claimDate = claimDate;
		this.approval = approval;
		this.claimStatusDate = claimStatusDate;
		this.customMessage = customMessage;
		this.child = child;
		this.policy = policy;
		this.hospitalBill = hospitalBill;
		this.doctorPrescribtion = doctorPrescribtion;
		this.dischargeDocuments = dischargeDocuments;
		this.ambulanceBill = ambulanceBill;
	}



	public Integer getHealthClaimId() {
		return healthClaimId;
	}

	public void setHealthClaimId(Integer healthClaimId) {
		this.healthClaimId = healthClaimId;
	}

	public LocalDate getIncidenceDate() {
		return incidenceDate;
	}

	public void setIncidenceDate(LocalDate incidenceDate) {
		this.incidenceDate = incidenceDate;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getRoomCategory() {
		return roomCategory;
	}

	public void setRoomCategory(String roomCategory) {
		this.roomCategory = roomCategory;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public LocalDate getAdmitDate() {
		return admitDate;
	}

	public void setAdmitDate(LocalDate admitDate) {
		this.admitDate = admitDate;
	}

	public LocalDate getDischargeDate() {
		return dischargeDate;
	}

	public void setDischargeDate(LocalDate dischargeDate) {
		this.dischargeDate = dischargeDate;
	}

	public Double getPreHospitalExpenses() {
		return preHospitalExpenses;
	}

	public void setPreHospitalExpenses(Double preHospitalExpenses) {
		this.preHospitalExpenses = preHospitalExpenses;
	}

	public Double getHospitalExpenses() {
		return hospitalExpenses;
	}

	public void setHospitalExpenses(Double hospitalExpenses) {
		this.hospitalExpenses = hospitalExpenses;
	}

	public Double getPostHospitalExpenses() {
		return postHospitalExpenses;
	}

	public void setPostHospitalExpenses(Double postHospitalExpenses) {
		this.postHospitalExpenses = postHospitalExpenses;
	}

	public Double getAmbulanceExpenses() {
		return ambulanceExpenses;
	}

	public void setAmbulanceExpenses(Double ambulanceExpenses) {
		this.ambulanceExpenses = ambulanceExpenses;
	}

	public healthApproval getApproval() {
		return approval;
	}

	public void setApproval(healthApproval approval) {
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

	public byte[] getHospitalBill() {
		return hospitalBill;
	}

	public void setHospitalBill(byte[] hospitalBill) {
		this.hospitalBill = hospitalBill;
	}

	public byte[] getDoctorPrescribtion() {
		return doctorPrescribtion;
	}

	public void setDoctorPrescribtion(byte[] doctorPrescribtion) {
		this.doctorPrescribtion = doctorPrescribtion;
	}

	public byte[] getDischargeDocuments() {
		return dischargeDocuments;
	}

	public void setDischargeDocuments(byte[] dischargeDocuments) {
		this.dischargeDocuments = dischargeDocuments;
	}

	public byte[] getAmbulanceBill() {
		return ambulanceBill;
	}

	public void setAmbulanceBill(byte[] ambulanceBill) {
		this.ambulanceBill = ambulanceBill;
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
