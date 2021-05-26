package com.bayamp.santaclara2020.programs;

import com.bayamp.santaclara2020.generic.Constants;

import java.io.*;

public class MyFileProgram {

    private static String txtSplitBy = "-";

    public static void main(String[] args) throws IOException {
        File file = new File(Constants.RELATIVE_FILE_PATH);
        FileInputStream fileStream = new FileInputStream(file);
        InputStreamReader input = new InputStreamReader(fileStream);
        BufferedReader reader = new BufferedReader(input);

        String line;
        int sentenceCount = 0;
        int counter = 1;
        String[] wordList = null;
        String delimiters = "?!.";
        StringBuilder sb = new StringBuilder();

        while ((line = reader.readLine()) != null) {
            wordList = line.split("\\s+");

            for (int d = 0; d < line.length(); d++) {
                // If the delimiters string contains the character
                if (delimiters.indexOf(line.charAt(d)) != -1) {
                    sentenceCount++;
                }

                for (int i = 0; i < wordList.length; i++) {
                    counter = 1;
                    for (int j = i + 1; j < wordList.length; j++) {
                        if (wordList[i].equals(wordList[j])) {
                            counter = counter + 1;
                        } else {
                            continue;
                        }
                    }
                    if ((!contains(sb, wordList[i])) && (counter > 1)) {
                        sb.append(wordList[i] + ":" + counter + " ");
                    }
                }
            }
        }
        System.out.println("Total number of sentences = " + sentenceCount);
        System.out.println(sb);
    }

    public static boolean contains(StringBuilder sb, String findString) {

        /*
         * if the substring is found, position of the match is
         * returned which is >=0, if not -1 is returned
         */
        return sb.indexOf(findString) > -1;
    }
}
