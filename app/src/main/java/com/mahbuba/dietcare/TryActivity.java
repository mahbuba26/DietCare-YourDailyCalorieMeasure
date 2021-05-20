package com.mahbuba.dietcare;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;
import java.util.Date;



import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class TryActivity extends AppCompatActivity {

        BarChart barChart;
        BarData barData;
        BarDataSet barDataSet;
        ArrayList barEntries;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_try);
            barChart = findViewById(R.id.graph1);

            getEntries();

            barDataSet = new BarDataSet(barEntries,"Data Set");
            barData = new BarData((List<String>) barDataSet);

            barChart.setData(barData);

      //      barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
            barDataSet.setValueTextColor(Color.BLACK);
            barDataSet.setValueTextSize(16f);



        }


        private void getEntries(){

            barEntries = new ArrayList<>();
            barEntries.add(new BarEntry(1f,2));
            barEntries.add(new BarEntry(2f,4));
            barEntries.add(new BarEntry(3f,1));
            barEntries.add(new BarEntry(5f,5));
            barEntries.add(new BarEntry(6f,3));
            barEntries.add(new BarEntry(7f,2));


        }



}

