package com.bayamp.santaclara2020.programs;

import com.bayamp.santaclara2020.generic.Constants;

import java.io.*;
import java.util.Iterator;
import java.util.stream.Stream;

public class FileProgram {

    //private static final String RELATIVE_FILE_PATH = "src/main/resources/data/myfile.txt";


    public static void main(String args) throws IOException{

        File filePath = new File(Constants.RELATIVE_FILE_PATH);

        Reader myReader = new FileReader(filePath);
        BufferedReader reader = new BufferedReader(myReader);
        Stream<String> streamOfStrings = reader.lines();
        Iterator itr = streamOfStrings.iterator();

        while (itr.hasNext()) {
            String line = (String)itr.next();
            System.out.println(line);

        }
        File filePath1 = new File(Constants.RELATIVE_FILE_PATH);
    }
}
