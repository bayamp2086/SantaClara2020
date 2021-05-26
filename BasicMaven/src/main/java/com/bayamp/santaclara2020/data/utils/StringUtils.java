package com.bayamp.santaclara2020.data.utils;

import org.testng.annotations.Test;

import java.util.*;

public class StringUtils {

    @Test //TimeComplexity :O(n)
    public static int addNumbers(String s1) {
        int sum = 0;
        //String s1 = "abc234ghi1";
        char[] chars = s1.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isDigit(chars[i])) {
                sum = sum + Character.getNumericValue(chars[i]);
            }
        }
        //System.out.println("The total sum of all numbers in the given string is: " + sum);
        return sum;
    }

    @Test //TimeComplexity :O(n)
    public static StringBuilder characterOccurence(String s1) {
        //String s1="aaabbccddef";
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char[] chars = s1.toCharArray();
        int len = s1.length();
        for (int i = 0; i < len - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                count++;
            } else {
                sb.append(chars[i]);
                sb.append(count);
                count = 1;
            }
        }
        sb.append(chars[len - 1]);
        sb.append(count);
        return sb;
        //System.out.println(sb);
    }

    @Test //Time Complexity : O(m*n)
    public static StringBuilder commonWords(String s1,String s2) {
        StringBuilder sb = new StringBuilder();
        String prefix = "";
        //String s1 = "Banana fruit is a ";
        //String s2 = "Cucumber is a vegetable";

        String[] wordsS1 = s1.split(" ");
        String[] wordsS2 = s2.split(" ");

        for (int i=0;i<wordsS1.length;i++) {
            for (int j=0;j<wordsS2.length;j++) {
                if(wordsS1[i].equals(wordsS2[j])){
                    sb.append(prefix);
                    sb.append(wordsS1[i]);
                    prefix = " , ";
                }
            }
        }
       //System.out.println(sb.toString());
        return sb;
    }

    @Test //Time Complexity : O(m+n) (prioritizing performance over memory consumption)
    public static HashSet commonWordsHS(String s1,String s2) {

        HashSet resultSet = new HashSet();
        //String s1 = "Banana fruit is a ";
        //String s2 = "Cucumber is a vegetable";

        String[] wordsS1 = s1.split(" ");
        String[] wordsS2 = s2.split(" ");
        HashSet set = new HashSet(Arrays.asList(wordsS2));

        for (String str : wordsS1) {
            if (set.contains(str)) {
                resultSet.add(str);
            }
        }
        //System.out.println(resultSet.toString());
        return resultSet;
    }

    @Test //Time Complexity : O(n^2)
    public static List<String> countCharacters(String str) {
        List<String> myList = new ArrayList<>();
        int count = 1;
        //String str = "abrakadabra";
        int len = str.length();
        char[] allChars = str.toCharArray();

        for (int i = 0; i < len; i++) {
            count = 1;
            boolean b = checkCharacterOccurence(myList,allChars[i]);
            if(b==false) {
                for (int j = i + 1; j < len; j++) {
                    if (allChars[i] == allChars[j]) {
                        count++;
                    }
                }
                    myList.add(allChars[i] + "=" + count);
            }
        }
        return myList;
        //System.out.println(myList);
    }

    @Test //TimeComplexity :O(n)
    public static HashMap<Character, Integer> countCharactersHM(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        int count = 1;
        //String s1 = "abrakadabrae";
        int len = str.length();
        char[] allChars = str.toCharArray();

        for (int i = 0; i < len; i++) {
            count = 1;
            if (!map.containsKey(allChars[i])) {
                for (int j = i + 1; j < len; j++) {
                    if (allChars[i] == allChars[j]) {
                        count++;
                    }
                }
                map.put(allChars[i], count);
            }
        }
        //System.out.println(Arrays.asList(map));
        return map;
    }

    @Test //TimeComplexity :O(n^2)
    public static List<String> countRepeatedOccurence(String str) {
        List<String> myList = new ArrayList<>();
        int count = 1;
        //String str = "abrakadabra";
        int len = str.length();
        char[] allChars = str.toCharArray();

        for (int i = 0; i < len; i++) {
            count = 1;
            boolean b = checkCharacterOccurence(myList,allChars[i]);
            if(b==false) {
                for (int j = i + 1; j < len; j++) {
                    if (allChars[i] == allChars[j]) {
                        count++;
                    }
                }
                if (count > 1) {
                    myList.add(allChars[i] + "=" + count);
                }
            }
        }
        //System.out.println(myList);
        return myList;
    }

    public static boolean checkCharacterOccurence(List<String> myList, char c){
        Iterator<String> checkCharIterator = myList.iterator();
        while(checkCharIterator.hasNext()) {
            String[] s = checkCharIterator.next().split("=");
            if(s.length > 0 && s[0].equals(String.valueOf(c))){
               return true;
           }
        }
        return false;
    }

    @Test //TimeComplexity :O(n)
    public static HashMap<Character, Integer> countRepeatedOccurenceHM(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        int count = 1;
        //String str = "Ranjini";
        int len = str.length();
        char[] allChars = str.toCharArray();

        for (int i = 0; i < len; i++) {
            count = 1;
            if (!map.containsKey(allChars[i])) {
                for (int j = i + 1; j < len; j++) {
                    if (allChars[i] == allChars[j]) {
                        count++;
                    }
                }
                if (count > 1) {
                    map.put(allChars[i], count);
                }
            }
        }
        //System.out.println(map);
        return map;
    }

    @Test //TimeComplexity :O(n+m)
    public static boolean anagramHM(String str1,String str2) {

        //String str1 = "Sadder";
        //String str2 = "Dreads";

        HashMap<Character, Integer> hmap1
                = new HashMap<Character, Integer>();
        HashMap<Character, Integer> hmap2
                = new HashMap<Character, Integer>();

        char[] arr1 = str1.toLowerCase().toCharArray();
        char[] arr2 = str2.toLowerCase().toCharArray();
        int n1 = str1.length();
        int n2 = str2.length();

        if (n1 != n2) {
            System.out.println("Not an anagram");
        }

        // Mapping first string
        for (int i = 0; i < arr1.length; i++) {
            if (hmap1.get(arr1[i]) == null) {
                hmap1.put(arr1[i], 1);
            } else {
                int c = hmap1.get(arr1[i]);
                hmap1.put(arr1[i], ++c);
            }
        }
        // Mapping second String
        for (int j = 0; j < arr2.length; j++) {

            if (hmap2.get(arr2[j]) == null)
                hmap2.put(arr2[j], 1);
            else {

                int d = hmap2.get(arr2[j]);
                hmap2.put(arr2[j], ++d);
            }
        }
        if (hmap1.equals(hmap2))
            return true;
            //System.out.println("Anagram");
        else
            return false;
           // System.out.println("Not an Anagram");

    }

    @Test //TimeComplexity :O(nlogn)
    public static boolean anagram(String str1,String str2)
    {
        //boolean found = false;
        //String str1="The Classroom";
        //String str2="School Master";

        char[] arr1 = str1.toLowerCase().toCharArray();
        char[] arr2 = str2.toLowerCase().toCharArray();

        int n1 = arr1.length;
        int n2 = arr2.length;

        if (n1 != n2) {
           return false;
            //System.out.println("Not an anagram");
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        for (int i = 0; i < n1; i++) {
            if (arr1[i] != arr2[i]) {
               return false;
                //found=true;
               // break;
            }
        }
        /*if(found==false) {
            System.out.println("Anagram");
        }
        else {
            System.out.println("Not an anagram");
        }*/
    return true;
    }

    @Test //TimeComplexity :O(n)
    public static boolean palindrome(String str) {
        boolean found = false;
       // String str = "mom";
        int i = 0;
        int n =str.length();
        int j = n-1;
        while (i < n/2) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
                /*found=true;
                break;*/
            }
            i++;
            j--;
        }
        /*if(found==false) {
            System.out.println("The given string is a Palindrome");
        }
        else{
            System.out.println("The given string is not a Palindrome");
        }*/
        return true;
    }

    @Test //TimeComplexity :O(1)
    public static boolean checkSubString(String s1) {
        //String s1="Ranjini";
        if(s1.contains("ini")){ //if(s1.indexOf("ini")!=-1) (we can use contains or indexOf method)
            //System.out.println("The sub string is present in given string");
            return true;
        }
        else{
           // System.out.println("The sub string is not present in given string");
            return false;
        }
    }

    @Test //TimeComplexity :O(n^2)
    public static String[] removeDuplicateWords(String s) {

        //String s = "She sells sea shells in the sea shore";
        String[] words = s.split(" ");

        for(int i=0;i<words.length;i++) {
            if (words[i] != null) {
                for (int j = i + 1; j < words.length; j++) {
                    if (words[i].equals(words[j])) {
                        words[j] = null;
                    }
                }
            }
        }
            /*for (int i = 0; i < words.length; i++) {

                if (words[i] != null) {
                    System.out.print(words[i]);
                }

            }*/
            return words;

        }

    @Test //TimeComplexity :O(n)
    public static HashSet removeDuplicateWordsHS(String s) {

        HashSet resultSet = new HashSet();
        //String s = "She sells sea shells in the sea shore";
        String prefix="";

        String[] words = s.split(" ");

        /*for (String str : wordsS1) {
            if (!resultSet.contains(str)) {
                resultSet.add(str);
                System.out.print(prefix + str);
                prefix = " ";
            }
        }*/

        return resultSet;
    }
    @Test
    public static void ReverseAlternateWords() {
            String s1 = "one two three four";
            String[] ra = s1.split(" ");
            int len = ra.length;
            System.out.println(s1 + " ");

            System.out.println(" ");
            for (int i = 0; i < len / 2; i++) {

                String temp = ra[i];
                ra[i] = ra[i + 2];
                ra[i + 2] = temp;

            }
            for (int i = 0; i < len; i++) {
                System.out.print(ra[i] + " ");// Print as three four one two
            }
        }
    @Test
    public static void ReverseEachWords() {
            String s1 = "one two three four";
            // eno owt eerht ruof
            String[] s = s1.split(" ");

            for(String word: s) {
                StringBuilder build = new StringBuilder();
                build.append(word);
                build.append(" ");
                System.out.print(build.reverse().toString());
            }

            System.out.println();
            /*StringBuffer sb = new StringBuffer();

            for (String a : s) {
                char[] ch = a.toCharArray();
                int l = ch.length;
                for (int i = 0; i <= l / 2; i++){
                    char temp = ch[i];
                    ch[i] = ch[l - i - 1];
                    ch[l - i - 1] = temp;
                }
                sb.append(ch);
                sb.append(" ");
            }
            System.out.println(sb);*/
        }

    @Test
    public static void ReverseStringWithSpace() {

            String s1 = "I love Rishu";
            // o/p u hsiR evolI

            char[] str = s1.toCharArray();
            int len = str.length;
            char[] result = new char[len];

            //store the same spaces from str to result
            for (int i = 0; i < len; i++) {
                if (str[i] == ' ') {
                    result[i] = ' ';

                }
            }

            //take input string str from begining and put characters in result from end
            int j = len - 1;
            for (int i = 0; i < len; i++) {

                //ignore the spaces from input string 'str'
                if (str[i] != ' ') {


                    if (result[j] == ' ') {
                        j--;
                    }
                    result[j] = str[i];
                    j--;
                }
            }
            // this method converts different types of values into string
            System.out.println(String.valueOf(result));
        }
}




