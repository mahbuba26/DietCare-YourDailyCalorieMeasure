package com.mahbuba.dietcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AllActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all);
    }

    public void buttonClick(View view){
        Intent intent =new Intent(AllActivity.this,Profile.class);
        startActivity(intent);
    }
    public void buttonClick2(View view){
        Intent intent =new Intent(AllActivity.this,AnalysisActivity.class);
        startActivity(intent);
    }
    public void buttonClick3(View view){
        Intent intent =new Intent(AllActivity.this,FoodActivity.class);
        startActivity(intent);
    }
    public void buttonClick4(View view){
        Intent intent =new Intent(AllActivity.this,GoActivity.class);
        startActivity(intent);
    }
}
