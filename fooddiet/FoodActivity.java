package com.example.fooddiet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FoodActivity extends AppCompatActivity {
DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        drawerLayout=findViewById(R.id.drawer_layout);
        Toolbar toolbar;
        final ListView listView;

        //toolbar = (Toolbar)findViewById(R.id.tbrecipe);
       // toolbar.setTitle("Food Calories Per Gram");
        listView = (ListView)findViewById(R.id.lvrecipe);
        ArrayAdapter<String> mAdapter= new ArrayAdapter<String>(FoodActivity.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.Rec));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View v, int i, long l){
                Intent intent = new Intent(FoodActivity.this,R_1.class);
                intent.putExtra("RecipeName",listView.getItemAtPosition(i).toString());
                startActivity(intent);

            }
        });
        listView.setAdapter(mAdapter);

    }

    public void ClickMenu(View view){
        MainActivity.openDrawer(drawerLayout);

    }

    public void ClickLogo(View view){
        MainActivity.closeDrawer(drawerLayout);
    }

    public void ClickHome(View view){
        MainActivity.redirectActivity(this,MainActivity.class);
    }

    public void ClickDashboard(View view){
        MainActivity.redirectActivity(this,AnalysisActivity.class);
    }
    public void ClickReminder(View view){
        MainActivity.redirectActivity(this,SetActivity.class);
    }
    public void ClickFriends(View view){
        MainActivity.redirectActivity(this,InviteActivity.class);
    }
    public void ClickGraph(View view){
        MainActivity.redirectActivity(this,graph.class);
    }

    public void ClickAboutUs(View view){
        recreate();
    }

    public void ClickLogout(View view){
        MainActivity.logout(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MainActivity.closeDrawer(drawerLayout);
    }
}
