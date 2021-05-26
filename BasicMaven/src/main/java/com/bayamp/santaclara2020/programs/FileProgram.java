package com.bayamp.santaclara2020.programs;

import com.bayamp.santaclara2020.generic.Constants;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileProgram {

    //private static final String RELATIVE_FILE_PATH = "src/main/resources/data/myfile.txt";
    public static void main(String[] args) throws IOException{

        File filePath = new File(Constants.RELATIVE_FILE_PATH);
        List<String> myList = new ArrayList<String>();

        Reader myReader = new FileReader(filePath);
        BufferedReader reader = new BufferedReader(myReader);
        //Stream<String> streamOfStrings = reader.lines();
       // Iterator itr = streamOfStrings.iterator();

        //while (itr.hasNext()) {
            //String line = (String)itr.next();
            //System.out.println(line);
        String str;
        while ((str = reader.readLine()) != null) {
            myList.add(str);
        }
        File file = new File(Constants.SAMPLE_FILE_PATH);
       // file.createNewFile();
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        for (String value : myList)
        {
            bw.write(value);
        }
    }
}
