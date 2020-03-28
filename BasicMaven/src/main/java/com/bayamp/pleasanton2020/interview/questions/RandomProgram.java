package com.bayamp.pleasanton2020.interview.questions;

import com.bayamp.pleasanton2020.utils.RandomUtil;
import com.sun.javafx.binding.StringFormatter;

import java.util.*;

public class RandomProgram {

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            String phoneNumber =RandomUtil.generateRandomPhoneNumber();
            System.out.println(phoneNumber);
        }
    }

}
