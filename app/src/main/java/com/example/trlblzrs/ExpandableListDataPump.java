package com.example.trlblzrs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class ExpandableListDataPump {
    public static LinkedHashMap<String, List<String>> getData() {
        LinkedHashMap<String, List<String>> expandableListDetail = new LinkedHashMap<String, List<String>>();

        List<String> monday = new ArrayList<String>();
        monday.add("Subject");
        monday.add("Subject");
        monday.add("Subject");
        monday.add("Subject");
        monday.add("Subject");

        List<String> tuesday = new ArrayList<String>();
        tuesday.add("Subject");
        tuesday.add("Subject");
        tuesday.add("Subject");
        tuesday.add("Subject");
        tuesday.add("Subject");

        List<String> wednesday = new ArrayList<String>();
        wednesday.add("Subject");
        wednesday.add("Subject");
        wednesday.add("Subject");
        wednesday.add("Subject");
        wednesday.add("Subject");

        List<String> thursday = new ArrayList<String>();
        thursday.add("Subject");
        thursday.add("Subject");
        thursday.add("Subject");
        thursday.add("Subject");
        thursday.add("Subject");

        List<String> friday = new ArrayList<String>();
        friday.add("Subject");
        friday.add("Subject");
        friday.add("Subject");
        friday.add("Subject");
        friday.add("Subject");

        List<String> saturday= new ArrayList<String>();
        saturday.add("Subject");
        saturday.add("Subject");
        saturday.add("Subject");
        saturday.add("Subject");
        saturday.add("Subject");

        expandableListDetail.put("Monday", monday);
        expandableListDetail.put("Tuesday", tuesday);
        expandableListDetail.put("Wednesday", wednesday);
        expandableListDetail.put("Thursday", thursday);
        expandableListDetail.put("Friday", friday);
        expandableListDetail.put("Saturday", saturday);
        return expandableListDetail;
    }
}