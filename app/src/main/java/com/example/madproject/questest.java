package com.example.madproject;

import java.util.ArrayList;

public class questest {

    public static String questions[] = {
            "Where is UIU situated?", "Which Facility UIU doesn't have?", "Which department UIU doesn't have?"
    };

    public static String options[][] = {
            {"Dhanmondi", "Sylhet", "Mohammadpur", "Near Gulshan"},
            {"Playground", "Air Conditioned Canteen", "Library", "Indoor Games"},
            {"Medical", "CSE", "Law", "BBA"}
    };

    public static String correct[] = {
            "Near Gulshan", "Air Conditioned Canteen", "Law"
    };
    private static String qt, ot1, ot2, ot3, ot4, at;

    ArrayList<String> ques3 = new ArrayList<String>();
    ArrayList<String> opt13 = new ArrayList<String>();
    ArrayList<String> opt23 = new ArrayList<String>();
    ArrayList<String> opt33 = new ArrayList<String>();
    ArrayList<String> opt43 = new ArrayList<String>();
    ArrayList<String> ans3 = new ArrayList<String>();

    public void getvals(String q, String o1, String o2, String o3, String o4, String a){
        qt = q;
        ot1 = o1;
        ot2 = o2;
        ot3 = o3;
        ot4 = o4;
        at = a;

        ques3.add(qt);
        opt13.add(ot1);
        opt23.add(ot2);
        opt33.add(ot3);
        opt43.add(ot4);
        ans3.add(at);
    }



}
