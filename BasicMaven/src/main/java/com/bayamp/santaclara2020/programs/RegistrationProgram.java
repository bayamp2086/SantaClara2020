package com.bayamp.santaclara2020.programs;

import com.bayamp.santaclara2020.data.utils.RegistrationUtil;

public class RegistrationProgram {

public static void main(String[] args) {
		
		String randomFirstName = RegistrationUtil.getRandomFirstName();
		System.out.println(randomFirstName);
		
		String randomLastName = RegistrationUtil.getRandomLastName();
		System.out.println(randomLastName);
		
		String randomUserID = RegistrationUtil.getRandomUserID();
		System.out.println(randomUserID);
		
		String randomPassword = RegistrationUtil.getRandomPassword();
		System.out.println(randomPassword);
		
	}
}
