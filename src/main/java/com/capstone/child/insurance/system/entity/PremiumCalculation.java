package com.capstone.child.insurance.system.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PremiumCalculation {
	@Id
	            
	private Integer childAge;           //child age
	private Double annual_income;      //annual Amount
	private Double cover;     //Cover Amount
	private Integer duration;          //Duration in years
	          
	
	


	public Double getCover() {
		return cover;
	}


	public void setCover(Double cover) {
		this.cover = cover;
	}
	
	
	public PremiumCalculation() {
		super();
	}




	public PremiumCalculation( Integer childAge, Double annual_income, Double cover,
			Integer duration) {
		super();
				this.childAge = childAge;
		this.annual_income = annual_income;
		this.cover = cover;
		this.duration = duration;
		
	}
	public Integer getChildAge() {
		return childAge;
	}


	public void setChildAge(Integer childAge) {
		this.childAge = childAge;
	}





	public Double getAnnual_income() {
		return annual_income;
	}


	public void setAnnual_income(Double annual_income) {
		this.annual_income = annual_income;
	}


	public Integer getDuration() {
		return duration;
	}


	public void setDuration(Integer duration) {
		this.duration = duration;
	}


	
	




}
