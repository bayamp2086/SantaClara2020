package com.bayamp.santaclara2020.data.utils;

import com.opencsv.CSVReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class BayampDataProvider {
    private final static String CSV_FILE_PATH = "src/test/resources/data/palindrome.csv";
    private final static String BOOK_CSV_FILE_PATH = "src/test/resources/data/book-details.csv";
    private final static String MAP_CSV_FILE_PATH = "src/test/resources/data/test-data.csv";
    private final static String REGISTRATION_XML_FILE_PATH = "src/test/resources/data/registration-details.xml";
    private final static String STUDENT_JSON_FILE_PATH = "src/test/resources/data/student-details.json";

    private static String line = "";
    private static String cvsSplitBy = ",";
    private static BufferedReader br;
    private static CSVReader reader = null;

    /**
     * Method retrieves data from palindrome csv file and creates a map object
     *
     * @return Two dimensional array object
     *
     * @throws IOException
     */
    @DataProvider(name = "getCSVData")
    public static Object[][] parseCSVFileToGetData() throws IOException {

        Object[][] myData = new Object[3][1];
        String[] values = null;

        br = new BufferedReader(new FileReader(CSV_FILE_PATH));

        // getting keys
        line = br.readLine();
        String[] keys = line.split(cvsSplitBy);

        // getting values
        for (int i = 0; i < myData.length; i++) {
            line = br.readLine();
            values = line.split(cvsSplitBy);
            Map<String, String> row = new HashMap<String, String>();
            // creating a map object for every row
            for (int j = 0; j < values.length; j++) {
                row.put(keys[j], values[j]);

            }
            myData[i][0] = row;
        }
        System.out.println(Arrays.deepToString(myData));
        return myData;
    }

    /**
     * Method retrieves data from book-details csv file and creates a book object
     *
     * @return Two dimensional array object
     *
     * @throws IOException
     */
    @DataProvider(name = "getBookCSVData")
    public static Object[][] parseCSVFileToGetBookData() throws IOException {
        String[] values = null;
        Object[][] books = new Object[3][1];

        br = new BufferedReader(new FileReader(BOOK_CSV_FILE_PATH));
        line = br.readLine();
        String[] keys = line.split(cvsSplitBy);
        for (int i = 0; i < books.length; i++) {
            line = br.readLine();
            values = line.split(cvsSplitBy);
            String title = values[0];
            String author = values[1];
            String pageCount = values[2];
            String price = values[3];
            Book book = new Book(title, author, pageCount, price);
            books[i][0] = book;

        }
        return books;
    }

    /**
     * Method retrieves data from registration-details xml file and creates a student object
     *
     * @return Two dimensional array object
     *
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     */
    @DataProvider(name = "getXMLData")
    public static Object[][] parseXMLFileToGetData() throws ParserConfigurationException, IOException, SAXException {
        Object[][] students = new Object[3][1];

        // Get Document Builder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Build Document
        Document document = builder.parse(new File(REGISTRATION_XML_FILE_PATH));

        // Normalize the XML Structure
        document.getDocumentElement().normalize();

        // List of all students
        NodeList nList = document.getElementsByTagName("student");
        for (int temp = 0; temp < nList.getLength(); temp++) {

            // Get First Student from List of Students
            Node node = nList.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) node;

                String firstName = eElement.getElementsByTagName("firstName").item(0).getTextContent();
                String lastName = eElement.getElementsByTagName("lastName").item(0).getTextContent();
                String userName = eElement.getElementsByTagName("userName").item(0).getTextContent();
                String pwd = eElement.getElementsByTagName("pwd").item(0).getTextContent();
                Student student = new Student(firstName, lastName, userName, pwd);
                students[temp][0] = student;

            }
        }
        return students;

    }

    /**
     * Method retrieves data from student-details xml file and creates a student object
     *
     * @return Two dimensional array object
     *
     * @throws IOException
     * @throws ParseException
     */
    @DataProvider(name = "getJSONData")
    public Object[][] parseJSONFileToGetData() throws IOException, ParseException {
        Object[][] students = new Object[3][1];

        JSONParser parser = new JSONParser();

        //Parsing the contents of the JSON file
        Object obj = parser.parse(new FileReader(STUDENT_JSON_FILE_PATH));

        // type casting obj to JSONArray
        JSONArray ja = (JSONArray) obj;

        for (int i = 0; i < students.length; i++) {

            //type casting first element of JSONArray to JSONObject
            JSONObject jo = (JSONObject) ja.get(i);
            String firstName = (String) jo.get("firstName");
            String lastName = (String) jo.get("lastName");
            String id = (String) jo.get("id");
            Student student = new Student(firstName, lastName, id);
            students[i][0] = student;
        }
        return students;
    }

    /**
     * Method retrieves data from palindrome csv file and add it to List
     *
     * @return Iterator object array
     *
     * @throws InterruptedException
     * @throws IOException
     */
    @DataProvider(name = "provideData")
    public Iterator<Object[]> provider() throws InterruptedException, IOException {

        List<Object[]> myList = new ArrayList<>();
        String[] data = null;

        // this loop is pseudo code
        br = new BufferedReader(new FileReader(CSV_FILE_PATH));
        while ((line = br.readLine()) != null) {
            // use comma as separator
            data = line.split(cvsSplitBy);
            myList.add(data);
        }

        return myList.iterator();
    }

    /*
     * @DataProvider(name = "getMapCSVData") public static Object[][]
     * parseCSVFileToGetMapData() throws IOException {
     *
     * Object[][] myData = new Object[3][1]; String[] values = null;
     *
     * br = new BufferedReader(new FileReader("src/test/resources/TestData.csv"));
     *
     * // getting keys line = br.readLine(); String[] keys = line.split(cvsSplitBy);
     *
     * // getting values for (int i = 0; i < myData.length; i++) { line =
     * br.readLine(); values = line.split("\"(,\")?");
     * System.out.println(values.length); Map<String, String> row = new
     * HashMap<String, String>(); // creating a map object for every row for (int j
     * = 0; j < values.length; j++) { row.put(keys[j], values[j]);
     *
     * } myData[i][0] = row; } System.out.println(Arrays.deepToString(myData));
     * return myData; }
     */

}

