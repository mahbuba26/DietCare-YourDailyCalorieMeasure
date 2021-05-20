package com.mahbuba.dietcare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {
    public static final String TAG = "TAG";
    EditText mFullName, mEmail, mPassword, mPhone,mWeight,mAge;
    Button mRegisterBtn;
    TextView mLoginBtn,mAg;
    FirebaseAuth fAuth;
    ProgressBar progressBar;
    FirebaseFirestore fStore;
    String userID,bmr,bmr1,bmr2,bmr3,bmr4;
    Float weii,heii,agg;
    String gender="";
    RadioButton male,female;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mFullName = findViewById(R.id.fullName);
        mEmail = findViewById(R.id.Email);
        mPassword = findViewById(R.id.password);
        mPhone = findViewById(R.id.phone);
        mRegisterBtn = findViewById(R.id.registerBtn);
        mLoginBtn = findViewById(R.id.createText);
        mWeight=findViewById(R.id.weight);
        mAge=findViewById(R.id.age);
        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        progressBar = findViewById(R.id.progressBar);
        mAg=findViewById(R.id.textView3);
        male=(RadioButton)findViewById(R.id.male);
        female=(RadioButton)findViewById(R.id.female);

        //if (fAuth.getCurrentUser() != null) {
          //  startActivity(new Intent(getApplicationContext(), AllActivity.class));
            //finish();
        //}

        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();
                final String fullName = mFullName.getText().toString();
                final String hei = mPhone.getText().toString();
                final String wei = mWeight.getText().toString();
                final String ag = mAge.getText().toString();


                if (TextUtils.isEmpty(email)) {
                    mEmail.setError("Please Enter Email ");
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    mPassword.setError("Please Enter Password ");
                    return;
                }
                if(password.length() < 6){
                    mPassword.setError("Password Must be >= 6 Characters");
                    return;
                }



                if (TextUtils.isEmpty(fullName)) {
                    mFullName.setError("Please Enter FullName ");
                    return;
                }
                if (TextUtils.isEmpty(hei)) {
                    mPhone.setError("Please Enter Height ");
                    return;
                }

                if (TextUtils.isEmpty(wei)) {
                    mWeight.setError("Please Enter Weight ");
                    return;
                }

                if (TextUtils.isEmpty(ag)) {
                    mAge.setError("Please Enter Age ");
                    return;
                }


                if (male.isChecked()) {
                    gender = "Male";
                }
               else if (female.isChecked()) {
                    gender = "Female";
                }
 else{
     //Toast.makeText(Register.this,"Please select Gender !",Toast.LENGTH_LONG).show();
                    mAg.setError("Please Enter Age ");
                    return;
                }


                weii=Float.parseFloat(wei);
heii=Float.parseFloat(hei);
agg=Float.parseFloat(ag);
                final float bmiValue = calculateBMI(weii, heii);

final String bmi= String.valueOf(bmiValue);
//Define the meaning of the bmi value
                final String bmiInterpretation = interpretBMI(bmiValue);
                if(gender == "Male"){
                    final Double bmrr= (Double) (88.362+(13.397*weii)+(4.799*heii)-(5.677*agg));

                    bmr= String.valueOf(bmrr);
                   }
                else{
                    final Double bmrr22= (Double)(447.597+(9.247*weii)+(3.098*heii)-(4.330*agg));

                   bmr= String.valueOf(bmrr22);
                   }

            progressBar.setVisibility(View.VISIBLE);
                fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            Toast.makeText(Register.this, "Registration Completed  " , Toast.LENGTH_SHORT).show();
                            userID = fAuth.getCurrentUser().getUid();
                            DocumentReference documentReference = fStore.collection("users").document(userID);

                            Map<String,Object> user=new HashMap<>();
                            user.put("fName",fullName);
                            user.put("email",email);
                            user.put("height",hei);
                            user.put("weight",wei);
                            user.put("age",ag);
                            user.put("gender",gender);
                            user.put("bmi",bmi);
                            user.put("bmi_inter",bmiInterpretation);
                            user.put("bmr_inter",bmr);


                            documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Log.d(TAG, "onSuccess: user Profile is created for "+ userID);
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.d(TAG, "onFailure: " + e.toString());
                                }
                            });
                            //progressBar.setVisibility(View.GONE);
                            startActivity(new Intent(getApplicationContext(), AllActivity.class));

                        } else {
                            Toast.makeText(Register.this, "Error ! Please Try Again ... " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }


                });
            }

        });

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Login.class));
            }
        });}

    private float calculateBMI (float weight, float height) {
        return  (weight*10000 / (height * height ));
    }

    // Interpret what BMI means
    private String interpretBMI(float bmiValue) {

        if (bmiValue < 16) {
            return "Severely underweight ";
        } else if (bmiValue < 18.5) {

            return "Underweight ";
        } else if (bmiValue < 25) {

            return "Normal ";
        } else if (bmiValue < 30) {

            return "Overweight ";
        } else {
            return "Obese ";
        }
    }
}