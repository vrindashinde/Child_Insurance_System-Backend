package com.capstone.child.insurance.system.service;

import java.util.Collection;

import com.capstone.child.insurance.system.entity.Child;
import com.capstone.child.insurance.system.entity.PremiumCalculation;

public interface PremiumCalculationService {
	

	Double addPremCalc(PremiumCalculation newPremCalc, Child children);

}
