package com.bayamp.santaclara2020.generic;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CSVReaderProgram {
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub

        /*
         * File myFile = new File("src/main/resources/data/Address.csv"); String
         * myString = FileUtils.readFileToString(myFile); System.out.println(myString);
         */

        final String CSV_FILE_PATH = "src/main/resources/data/address.csv";
        int count=0;
        try (Reader reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH));
             CSVParser csvParser = new CSVParser(reader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {
            for (CSVRecord csvRecord : csvParser) {
                // Accessing values by Header names
                String buildingNo = csvRecord.get("Building Number");
                String city = csvRecord.get("City");
                String state = csvRecord.get("State");
                String streetName = csvRecord.get("Street Name");
                String suite = csvRecord.get("Suite");
                String zipCode = csvRecord.get("ZipCode");
                count++;

                System.out.println("Record No - " + csvRecord.getRecordNumber());
                System.out.println("---------------");
                System.out.println("Building Number : " + buildingNo);
                System.out.println("Street Name : " + streetName);
                System.out.println("Suite : " + suite);
                System.out.println("City : " + city);
                System.out.println("State : " + state);
                System.out.println("Zip Code : " + zipCode);
                System.out.println("---------------\n\n");
            }
            System.out.println("The number of records in the csv file is: " +count);
        }
    }
}


