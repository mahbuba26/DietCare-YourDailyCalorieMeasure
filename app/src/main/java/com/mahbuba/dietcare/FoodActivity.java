package com.mahbuba.dietcare;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;

public class FoodActivity extends AppCompatActivity {
DrawerLayout drawerLayout;
    FirebaseAuth fAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        drawerLayout = findViewById(R.id.drawer_layout);
        Toolbar toolbar;
        final ListView listView;
        fAuth = FirebaseAuth.getInstance();
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
        openDrawer(drawerLayout);
    }

    public static void openDrawer(DrawerLayout drawerLayout) {
        drawerLayout.openDrawer(GravityCompat.START);
    }
    public void ClickLogo(View view){
        closeDrawer(drawerLayout);
    }

    public static void closeDrawer(DrawerLayout drawerLayout) {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    public void ClickHome(View view){
        redirectActivity(this,Profile.class);
    }

    public void ClickDashboard(View view){
        redirectActivity(this,AnalysisActivity.class);
    }

    public void ClickGraph(View view){
       redirectActivity(this,graph.class);
    }

    public void ClickAboutUs(View view){
        recreate();
    }
    public void ClickReminder(View view){
     //   redirectActivity(this,SetActivity.class);
    }
    public void ClickFriends(View view){
        redirectActivity(this,InviteActivity.class);
    }

    public void ClickLogout(View view){
               FirebaseAuth.getInstance().signOut();
    startActivity(new Intent(getApplicationContext(),MainActivity.class));
    finish();
     }

    public static void logout(final Activity activity) {
        AlertDialog.Builder builder=new AlertDialog.Builder(activity);
        builder.setTitle("Logout");
        builder.setMessage("Are you sure you want to logout ?");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                activity.finishAffinity();
                System.exit(0);
            }
        });
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
        FirebaseAuth.getInstance().signOut();//logout
        //startActivity(new Intent(getApplicationContext(),Login.class));
       // finish();
    }

    public static void redirectActivity(Activity activity,Class aClass) {
        Intent intent=new Intent(activity,aClass);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);


    }

    @Override
    protected void onPause() {
        super.onPause();
        closeDrawer(drawerLayout);
    }
}


