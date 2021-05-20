package com.mahbuba.dietcare;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public class InviteActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invite);

        drawerLayout=findViewById(R.id.drawer_layout);
    }

    public void onSendMessage(View view){
        EditText messageView=(EditText)findViewById(R.id.message);
        String messageText=messageView.getText().toString();

        Intent intent=new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT,messageText);
        String chooserTitle=getString(R.string.chooser);
        Intent chosenIntent=Intent.createChooser(intent,chooserTitle);
        startActivity(chosenIntent);
    }

    public void ClickMenu(View view){
        FoodActivity.openDrawer(drawerLayout);

    }

    public void ClickLogo(View view){
        FoodActivity.closeDrawer(drawerLayout);
    }

    public void ClickReminder(View view){
       // FoodActivity.redirectActivity(this,SetActivity.class);
    }
    public void ClickFriends(View view){
        recreate();
    }

    public void ClickHome(View view){
        FoodActivity.redirectActivity(this,Profile.class);
    }

    public void ClickDashboard(View view){
        FoodActivity.redirectActivity(this,AnalysisActivity.class);
    }

    public void ClickGraph(View view){
        FoodActivity.redirectActivity(this,GoActivity.class);
    }

    public void ClickAboutUs(View view){
        FoodActivity.redirectActivity(this,FoodActivity.class);
    }

    public void ClickLogout(View view){
        FoodActivity.logout(this);
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
        finish();
    }

    @Override
    protected void onPause() {
        super.onPause();
        FoodActivity.closeDrawer(drawerLayout);
    }
}
