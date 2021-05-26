package com.bayamp.santaclara2020.programs;

import java.util.zip.CRC32;
import java.util.zip.Checksum;

public class MyChecksumProgram  {

        public static void main(String[] args) {

            String input = "Hello Sir!";

            // get bytes from string
             byte[] bytes = input.getBytes();

            Checksum checksum = new CRC32();

            // update the current checksum with the specified array of bytes
            checksum.update(bytes, 0, bytes.length);

            // get the current checksum value
            long checksumValue = checksum.getValue();

            System.out.println("CRC32 checksum for input string is: " + checksumValue);

        }
}
