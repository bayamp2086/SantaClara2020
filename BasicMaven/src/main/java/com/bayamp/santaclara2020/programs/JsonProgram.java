package com.bayamp.santaclara2020.programs;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;


public class JsonProgram {

    public static void main(String[] args) throws ParseException, IOException {

        String jsonContentAsString = "[ {\"id\":\"NkzLzR-ke\"},{\"id\":\"Nyyo2oTse\"},{\"id\":\"NklSxXRix\"},{\"id\":\"EyNX8mAox\",\"name\":\"ASF\"} ]";
        JSONParser jsonParser = new JSONParser();
        Object jsonObj = jsonParser.parse(new FileReader(jsonContentAsString));
        JSONArray arrayObj = (JSONArray) jsonObj;

        JSONObject obj1 = (JSONObject) arrayObj.get(0);
        System.out.println(obj1.get("id"));
        JSONObject obj2 = (JSONObject) arrayObj.get(1);
        System.out.println(obj2.get("id"));
    }
}

