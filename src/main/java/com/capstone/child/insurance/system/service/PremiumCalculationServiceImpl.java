package com.capstone.child.insurance.system.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.child.insurance.system.dao.ChildRepository;
import com.capstone.child.insurance.system.dao.PolicyRepository;
import com.capstone.child.insurance.system.dao.PremiumCalculationRepository;
import com.capstone.child.insurance.system.entity.Child;
import com.capstone.child.insurance.system.entity.Child.gender;
import com.capstone.child.insurance.system.entity.PremiumCalculation;

@Service
public class PremiumCalculationServiceImpl implements PremiumCalculationService {
	@Autowired
	PremiumCalculationRepository premCalcRepository;
	PolicyRepository PolicyRepo;
	ChildRepository childRepo;

	@Override
	public Double addPremCalc(PremiumCalculation newPremCalc, Child children) {
		double amountToBePaid = 0;
		double baseRateCalc = 0;
		double AgeCalc = 0;
		double incomeCalc = 0;
		double GenderCalc = 0;

		// base rate calculation
		baseRateCalc = baseRate(newPremCalc.getCover(), newPremCalc.getDuration());
		// condition based on age
		baseRateCalc = totalAmountByAge(newPremCalc.getChildAge());
		// Income factor
		incomeCalc = IncomeFactor(newPremCalc.getAnnual_income());
		// condition based on gender
		GenderCalc = amountByGender(children.getChildGender(), children.getChildId());
		amountToBePaid = baseRateCalc + AgeCalc + incomeCalc + GenderCalc;
		return amountToBePaid;
	}

	private double baseRate(double cover, int duration) {
		double rate = 0;
//		Optional<PremiumCalculation> p1 = premCalcRepository.findById(id);
		rate = (30000*cover)/duration;
		return rate;

	}

	private double totalAmountByAge(int age) {
		double amountByAge = 0;
		double age_factor = 100.0;
		amountByAge = age_factor * age;
		return amountByAge;
	}

	private double IncomeFactor(double annual_income) {
		
		double income = 0.01 * annual_income;
		

		return income;
	}

	private double amountByGender(gender Genderofchild, Integer id) {
		double amountByGender = 0;

		Optional<Child> childOpt = childRepo.findById(id);
		Child child;
		if (childOpt.isPresent()) {
			child = childOpt.get();
			if (child.getChildGender() == Genderofchild.Male) {
				amountByGender = 100.0;
			}
            else {
			amountByGender = 0;
		}
		}
		return amountByGender;
	}
	

	}


