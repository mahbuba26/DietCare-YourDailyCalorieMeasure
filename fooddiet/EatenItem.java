package com.example.fooddiet;

import android.content.Intent;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static com.example.fooddiet.dietclass.EATEN_TABLE_NAME;
import static com.example.fooddiet.dietclass.TABLE_NAME;

public class EatenItem {
    private String ei_date;
    private int cal;
    List<EatenItem> ei = new ArrayList<EatenItem>();

    EatenItem(String currentDate, int cal){
        this.ei_date = currentDate;
        this.cal = cal;
    }
    public String  getDate(){
        return ei_date;
    }

    public int getCal() {
        return cal;
    }
}
