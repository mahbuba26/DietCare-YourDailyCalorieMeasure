package com.mahbuba.dietcare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class CalorieActivity extends AppCompatActivity {
    TextView BMR,BMR1,BMR2,BMR3,BMR4;
    FirebaseFirestore fStore;
    String userId, bmr_value;
    FirebaseAuth fAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorie);
        fStore = FirebaseFirestore.getInstance();
        BMR1=findViewById(R.id.full);
        BMR2=findViewById(R.id.height);
        BMR3=findViewById(R.id.weight);
        BMR4=findViewById(R.id.email);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        // storageReference = FirebaseStorage.getInstance().getReference();
        userId = fAuth.getCurrentUser().getUid();


        DocumentReference documentReference = fStore.collection("users").document(userId);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(DocumentSnapshot documentSnapshot, FirebaseFirestoreException e) {
                if (documentSnapshot.exists()) {
                  //  BMR1.setText("BMR :  " + documentSnapshot.getString("bmr_inter"));
                    bmr_value=documentSnapshot.getString("bmr_inter");
                   // float a= (float) (Float.parseFloat(bmr_value)*1.20);
                    //float b= (float) (Float.parseFloat(bmr_value)*1.3750);
                    //(float)(Float.parseFloat(bmr_value)*1.375)
                    //BMR1.setText("BMR :  " + bmr_value);
                    //BMR2.setText("BMR :  " + Double.parseDouble(bmr_value)*1.2);
                    //BMR3.setText("BMR :  " + Double.parseDouble(bmr_value)*1.375);
                    //BMR4.setText("BMR :  " + Double.parseDouble(bmr_value)*1.55);

                    BMR1.setText("If you don't do any exercise,\nthen you need   " + (float) (Float.parseFloat(bmr_value)*1.200) + " calorie daily" );
                    BMR2.setText("If you do exercise 1-3 day/week , \nthen you need  " + (float) (Float.parseFloat(bmr_value)*1.375) + " calorie daily" );
                    BMR3.setText("If you do exercise 3-5 day/week ,\nthen you need  " + (float)(Float.parseFloat(bmr_value)*1.550) + " calorie daily" );
                    BMR4.setText("If you do exercise 6-7 day/week ,\nthen you need  " + (float)(Float.parseFloat(bmr_value)*1.725) + " calorie daily" );

                }else {
                    Log.d("tag", "onEvent: Document do not exists");
                }
            }
        });

                }
            }

