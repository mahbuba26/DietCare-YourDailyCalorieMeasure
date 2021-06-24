package com.mahbuba.dietcare;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.HashMap;
import java.util.Map;

public class Profile extends AppCompatActivity {

    private static final int GALLERY_INTENT_CODE = 1023 ;
    TextView fullName,Email,Height,Weight,Age,Gender,BMI,BMI_IN,BMR,calorie;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userId;
    DrawerLayout drawerLayout;
    FirebaseUser user;
    ImageView profileImage;
  // StorageReference storageReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        drawerLayout=findViewById(R.id.drawer_layout);
        Age = findViewById(R.id.age);
        Height = findViewById(R.id.height);
        Weight = findViewById(R.id.weight);
        fullName = findViewById(R.id.full);
        Email    = findViewById(R.id.email);
        profileImage = findViewById(R.id.profileImage);
        Gender=findViewById(R.id.gender);
        BMI=findViewById(R.id.bmi);
BMR=findViewById(R.id.bmr);
calorie=findViewById(R.id.cal);
BMI_IN=findViewById(R.id.bmi_in);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
       // storageReference = FirebaseStorage.getInstance().getReference();
        userId = fAuth.getCurrentUser().getUid();
      //  user = fAuth.getCurrentUser();




        DocumentReference documentReference = fStore.collection("users").document(userId);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent( DocumentSnapshot documentSnapshot, FirebaseFirestoreException e) {
                if(documentSnapshot.exists()){
                    Age.setText("Age : "+ documentSnapshot.getString("age") +" years");
                    Height.setText("Height : "+ documentSnapshot.getString("height")+ " cm");
                    Weight.setText("Weight : "+ documentSnapshot.getString("weight") +" kg");
                    fullName.setText("FullName : "+ documentSnapshot.getString("fName"));
                    Email.setText("Email :  "+ documentSnapshot.getString("email"));
                    Gender.setText("Gender :  "+ documentSnapshot.getString("gender"));
                    BMI.setText("BMI :  "+ documentSnapshot.getString("bmi"));
                    BMI_IN.setText("          "+ documentSnapshot.getString("bmi_inter"));
                    BMR.setText("BMR :  "+ documentSnapshot.getString("bmr_inter"));


              //  String bmr_value=documentSnapshot.getString("bmr_inter");


                 //   Map<String,Object> user=new HashMap<>();
               //     user.put("bmr_value",bmr_value);

                }else {
                    Log.d("tag", "onEvent: Document do not exists");
                }
            }
        });






calorie.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(getApplicationContext(), CalorieActivity.class));
    }
});























































    }
 //   public void logout(View view) {
   //     FirebaseAuth.getInstance().signOut();
     //   startActivity(new Intent(getApplicationContext(),Login.class));
       // finish();
    //}


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
        FoodActivity.redirectActivity(this,InviteActivity.class);
    }

    public void ClickHome(View view){
        recreate();
    }

    public void ClickDashboard(View view){
        FoodActivity.redirectActivity(this,AnalysisActivity.class);
    }

    public void ClickGraph(View view){
        FoodActivity.redirectActivity(this,graph.class);
    }

    public void ClickAboutUs(View view){
        FoodActivity.redirectActivity(this,FoodActivity.class);
    }

    public void ClickLogout(View view){
        FoodActivity.logout(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        FoodActivity.closeDrawer(drawerLayout);
    }
}
