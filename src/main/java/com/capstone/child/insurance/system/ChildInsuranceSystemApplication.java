package com.capstone.child.insurance.system;

import java.time.LocalDate;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import com.capstone.child.insurance.system.dao.AdminRepository;
import com.capstone.child.insurance.system.dao.ChildPolicyEnrollmentRepository;
import com.capstone.child.insurance.system.dao.ChildRepository;
import com.capstone.child.insurance.system.dao.EducationClaimRepository;
import com.capstone.child.insurance.system.dao.EndowmentClaimRepository;
import com.capstone.child.insurance.system.dao.HealthClaimRepository;
import com.capstone.child.insurance.system.dao.ParentRepository;
import com.capstone.child.insurance.system.dao.PaymentRepository;
import com.capstone.child.insurance.system.dao.PolicyRepository;
import com.capstone.child.insurance.system.dao.PremiumCalculationRepository;
import com.capstone.child.insurance.system.dao.ReminderRepository;
import com.capstone.child.insurance.system.entity.Admin;
import com.capstone.child.insurance.system.entity.Child;
import com.capstone.child.insurance.system.entity.Child.gender;
import com.capstone.child.insurance.system.entity.Child.relationship;
import com.capstone.child.insurance.system.entity.ChildPolicyEnrollment;
import com.capstone.child.insurance.system.entity.EducationClaim;
import com.capstone.child.insurance.system.entity.EducationClaim.educationApproval;
import com.capstone.child.insurance.system.entity.EndowmentClaim;
import com.capstone.child.insurance.system.entity.EndowmentClaim.endowmentApproval;
import com.capstone.child.insurance.system.entity.HealthClaim;
import com.capstone.child.insurance.system.entity.HealthClaim.healthApproval;
import com.capstone.child.insurance.system.entity.Parent;
import com.capstone.child.insurance.system.entity.Payment;
import com.capstone.child.insurance.system.entity.Policy;
import com.capstone.child.insurance.system.entity.Policy.claimType;
import com.capstone.child.insurance.system.entity.PremiumCalculation;
import com.capstone.child.insurance.system.entity.Reminder;


//@ComponentScan("com.capstone.Child.Insurance.System")
@SpringBootApplication

public class ChildInsuranceSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ChildInsuranceSystemApplication.class, args);
	}

	@Autowired
	AdminRepository adminRepo;

	@Autowired
	ChildRepository childRepo;

	@Autowired
	ChildPolicyEnrollmentRepository childPolicyRepo;

	@Autowired
	EducationClaimRepository educationClaimRepo;

	@Autowired
	EndowmentClaimRepository endowmentClaimRepo;

	@Autowired
	HealthClaimRepository healthClaimRepo;

	@Autowired
	ParentRepository parentRepo;

	@Autowired
	PaymentRepository paymentRepo;

	@Autowired
	PolicyRepository policyRepo;

	@Autowired
	PremiumCalculationRepository premiumCalculationRepo;

//	@Autowired
//	ReminderRepository reminderRepo;

	@Override
	public void run(String... args) throws Exception {
//
//		// ADMINS
//
//		Admin a1 = this.adminRepo.save(new Admin("admin@gmail.com", "abcd"));
//		Admin a2 = this.adminRepo.save(new Admin("admin2@gmail.com", "abcd1"));
//		Admin a3 = this.adminRepo.save(new Admin("admin3@gmail.com", "abcd2"));
//		Admin a4 = this.adminRepo.save(new Admin("admin4@gmail.com", "abcd3"));
//
//		// POLICIES
//
//		Policy p1 = this.policyRepo.save(new Policy("Health Policy", 5, 1000.00, true, claimType.HealthClaim,null,null));
//		Policy p2 = this.policyRepo.save(new Policy("Endowment Policy", 10, 10000.00, false, claimType.EndowmentClaim,null,null));
//		Policy p3 = this.policyRepo.save(new Policy("Eduaction Policy", 18, 5000.00, true, claimType.EducationClaim,null,null));
//
//		// PARENTS
//
//		Parent par1 = this.parentRepo.save(new Parent("Sapana", "Bhate", "123", "Pune", "9988224411",
//				"sapana@gmail.com", "pass1", "SBI", "123", "SBIN123"));
//		Parent par2 = this.parentRepo.save(new Parent("Parent2", "Surname2", "1234", "Mumbai", "1133224411",
//				"parent2@gmail.com", "pass2", "Axis", "123", "Axis123"));
//		Parent par3 = this.parentRepo.save(new Parent("Parent3", "Surname3", "1114", "Delhi", "7722334411",
//				"parent3@gmail.com", "pass2", "ICICI", "3232", "ICICI123"));
//
//		// CHILDEREN
//
//		Child c1 = this.childRepo.save(
//				new Child("Child1", LocalDate.parse("2020-01-01"), "1234", gender.Female, relationship.Parent, par1,null,null,null,null));
//		Child c2 = this.childRepo.save(
//				new Child("Child2", LocalDate.parse("2017-01-01"), "1224", gender.Male, relationship.Parent, par1,null,null,null,null));
//		Child c3 = this.childRepo.save(
//				new Child("Child3", LocalDate.parse("2016-01-01"), "2134", gender.Female, relationship.Parent, par2,null,null,null,null));
//		Child c4 = this.childRepo.save(
//				new Child("Child4", LocalDate.parse("2012-01-01"), "4134", gender.Male, relationship.Parent, par2,null,null,null,null));
//		Child c5 = this.childRepo.save(
//				new Child("Child5", LocalDate.parse("2012-01-01"), "9134", gender.Male, relationship.Parent, par3,null,null,null,null));
//		Child c6 = this.childRepo.save(
//				new Child("Child6", LocalDate.parse("2011-01-01"), "7134", gender.Female, relationship.Parent, par3,null,null,null,null));
//		
//		// PREMIUM
//		
//				PremiumCalculation Pc1 = this.premiumCalculationRepo.save(new PremiumCalculation(45, 15, 500000.00, 10, 5000.00));
//				PremiumCalculation Pc2 = this.premiumCalculationRepo.save(new PremiumCalculation(35, 12, 500000.00, 2, 2000.00));
//		
//		//  ENROLLMENT
//		
//		ChildPolicyEnrollment En1 = this.childPolicyRepo.save(new ChildPolicyEnrollment(LocalDate.parse("2022-01-01"), LocalDate.parse("2025-01-01"), 10000.00, 100.00, status.Active, null, null, c1, p1)); 
//		ChildPolicyEnrollment En2 = this.childPolicyRepo.save(new ChildPolicyEnrollment(LocalDate.parse("2023-01-01"), LocalDate.parse("2026-01-01"), 15000.00, 200.00, status.Active, null, null, c1, p2)); 
//		ChildPolicyEnrollment En3 = this.childPolicyRepo.save(new ChildPolicyEnrollment(LocalDate.parse("2021-01-01"), LocalDate.parse("2024-01-01"), 10000.00, 500.00, status.Active, null, null, c1, p3)); 
//		ChildPolicyEnrollment En4 = this.childPolicyRepo.save(new ChildPolicyEnrollment(LocalDate.parse("2023-02-02"), LocalDate.parse("2026-01-01"), 12000.00, 400.00, status.Active, null, null, c2, p1));
//		ChildPolicyEnrollment En5 = this.childPolicyRepo.save(new ChildPolicyEnrollment(LocalDate.parse("2023-02-02"), LocalDate.parse("2026-01-01"), 17000.00, 200.00, status.Active, null, null, c2, p2));
//		ChildPolicyEnrollment En6 = this.childPolicyRepo.save(new ChildPolicyEnrollment(LocalDate.parse("2023-01-02"), LocalDate.parse("2026-02-01"), 12000.00, 300.00, status.Active, null, null, c2, p3));
//		
//		//PAYMENT
//		
//		Payment pay1 = this.paymentRepo.save(new Payment(true, 10000.00, LocalDate.parse("2022-01-01"), En1));
//		Payment pay2 = this.paymentRepo.save(new Payment(true, 2000.00, LocalDate.parse("2023-01-01"), En2));
//		Payment pay3 = this.paymentRepo.save(new Payment(true, 1000.00, LocalDate.parse("2021-01-01"), En3));
//		Payment pay4 = this.paymentRepo.save(new Payment(true, 200.00, LocalDate.parse("2021-02-01"), En4));
//		
//		//REMINDER
//		
//		Reminder r1 = this.reminderRepo.save(new Reminder(LocalDate.parse("2023-09-09"), 200.00, En1));
//		Reminder r2 = this.reminderRepo.save(new Reminder(LocalDate.parse("2024-08-09"), 200.00, En2));
//		Reminder r3 = this.reminderRepo.save(new Reminder(LocalDate.parse("2023-08-09"), 200.00, En3));
//		
//		//HEALTHCLAIM
//		HealthClaim h1=this.healthClaimRepo.save(new HealthClaim(LocalDate.parse("2023-05-01"), "Patenkar", "duplex", "accident", LocalDate.parse("2023-05-01"), LocalDate.parse("2023-05-10"), null, 100000.0, 50000.0, 2000.0, healthApproval.Verifying, c1, p1, null, null, null, null));
//		HealthClaim h2=this.healthClaimRepo.save(new HealthClaim(LocalDate.parse("2023-06-01"), "Deenanath", "ddouble", "kidney-stone", LocalDate.parse("2023-06-01"), LocalDate.parse("2023-06-10"), null, 10000.0, 5000.0, null, healthApproval.Verifying, c2, p1, null, null, null, null));
//		
//		//ENDOWNMENTCLAIM
//
//		EndowmentClaim e1=this.endowmentClaimRepo.save(new EndowmentClaim(20, endowmentApproval.Approved, c1, p2));
//		EndowmentClaim e2=this.endowmentClaimRepo.save(new EndowmentClaim(18, endowmentApproval.Approved, c2, p2));
//		
//		//EDUCATIONCLAIM
//		
//		EducationClaim ed1 = this.educationClaimRepo.save(new EducationClaim("COEP", 80000.0, 20000.0, 3000.0, educationApproval.Verifying, c1, p3, null, null, null, null));
//		EducationClaim ed2 = this.educationClaimRepo.save(new EducationClaim("PCCOE", 90000.0, 19000.0, 4000.0, educationApproval.Verifying, c2, p3, null, null, null, null));
//		
//		
//		
//		
	
		
		
	}

}
