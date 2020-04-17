package com.bayamp.santaclara2020.generic;

import com.bayamp.santaclara2020.data.utils.RandomUtil;

import java.util.Set;
import java.util.TreeSet;

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
		Set<Integer> uniqueNumbers = new TreeSet<>();
		int number;
		for (int i = 0; i < 5; i++) {
			number = RandomUtil.getRandomStringOfLen(7);
			uniqueNumbers.add(number);
		}
		System.out.println(uniqueNumbers);

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
