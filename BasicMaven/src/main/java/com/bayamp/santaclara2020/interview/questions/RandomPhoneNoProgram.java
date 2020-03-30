package com.bayamp.santaclara2020.interview.questions;

import com.bayamp.santaclara2020.utils.RandomUtil;

public class RandomPhoneNoProgram {

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            String phoneNumber =RandomUtil.generateRandomPhoneNumber();
            System.out.println(phoneNumber);
        }
    }

}