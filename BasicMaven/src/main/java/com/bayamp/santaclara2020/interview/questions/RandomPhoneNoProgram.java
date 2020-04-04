package com.bayamp.santaclara2020.interview.questions;

import java.util.Set;
import java.util.TreeSet;

import com.bayamp.santaclara2020.utils.RandomUtil;

/**
 * @author swatipathak
 *
 */
public class RandomProgram {

    public static void main(String[] args) {
        
    	// Random Date
        String date = RandomUtil.getDate();
		System.out.println(date);

		// Random number of length
		Set<String> randomNumbers = new TreeSet<>();
		for (int i = 0; i < 5; i++) {
			String randomString = RandomUtil.getRandomStringOfLen(8);
			randomNumbers.add(randomString);
		}
		System.out.println(randomNumbers);

		// Random SSN
		for (int i = 0; i < 5; i++) {
			String randomSSN = RandomUtil.generateRandomSSN();
			System.out.println(randomSSN);
		}

		// Random Phone Number
		for (int i = 0; i < 5; i++) {
			String randomPhoneNumber = RandomUtil.generateRandomPhoneNumber();
			System.out.println(randomPhoneNumber);
		}
    }

}
