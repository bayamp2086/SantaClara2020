package com.bayamp.santaclara2020.generic;

import java.util.Set;
import java.util.TreeSet;

import com.bayamp.santaclara2020.utils.RandomUtil;

public class RandomProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Integer> uniqueNumbers = new TreeSet<>();
		int number;
		for (int i = 0; i < 5; i++) {
			number = RandomUtil.getRandomStringOfLen(7);
			uniqueNumbers.add(number);
		}
		System.out.println(uniqueNumbers);
	}

}
