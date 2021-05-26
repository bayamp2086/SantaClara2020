package com.bayamp.santaclara2020.programs;

import com.bayamp.santaclara2020.generic.Constants;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class MyProduceProgram {

    public static void main(String[] args) throws IOException {
        HashMap<String, String> map = new HashMap<String, String>();
        String line;
        BufferedReader reader = new BufferedReader(new FileReader(Constants.PRODUCE_FILE_PATH));
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split("-", 2);
            if (parts.length >= 2) {
                String key = parts[0];
                String value = parts[1];
                map.put(key, value);
            } else {
                System.out.println("ignoring line: " + line);
            }
        }

        map.forEach((key, value) -> System.out.println(key + " " + value));

        Scanner sc = new Scanner(System.in);    //System.in is a standard input stream
        System.out.print("Enter Apple/Kale/Orange/Spinach:");
        String str = sc.nextLine();

        if (map.containsKey(str)) {
            String typeOfProduce = map.get(str);
            System.out.println(typeOfProduce);
        }
        reader.close();
    }
}
