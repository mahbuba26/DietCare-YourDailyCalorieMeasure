package com.mahbuba.dietcare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.PointsGraphSeries;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class GoActivity extends AppCompatActivity {


    FirebaseAuth mAuth;
    EditText x_v, y_v;
    Button btn_insert;
    DrawerLayout drawerLayout;
    FirebaseDatabase database;
    DatabaseReference reference;
    PointsGraphSeries<DataPoint> xySeries;
    SimpleDateFormat sdf = new SimpleDateFormat("dd");
    GraphView graphView;
    LineGraphSeries series;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go);

        graphView = (GraphView) findViewById(R.id.scatterPlot);

        drawerLayout = findViewById(R.id.drawer_layout);
        series = new LineGraphSeries();
        graphView.addSeries(series);
        //    mAuth=FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        //reference = database.getReference("graph");
        mAuth=FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        String userID = user.getUid();
        reference = database.getReference(userID);

        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        TextView textViewDate = findViewById(R.id.textView56);
        textViewDate.setText(currentDate);

        //  setListeners();
        String id = reference.push().getKey();
        long x = new Date().getTime();
        int y = (int) AnalysisActivity.getValue();




        graphView.getGridLabelRenderer().setNumHorizontalLabels(10);
        graphView.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter() {
            @Override
            public String formatLabel(double value, boolean isValueX) {
                if (isValueX) {
                    return sdf.format(new Date((long) value));
                } else {
                    return super.formatLabel(value, isValueX);
                }
            }
        });
    }

    private void setListeners() {

        btn_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = reference.push().getKey();
                // float cal1 = dbhelper.databaseToString2();
                //   int y = (int) ProfileActivity.getValue();

                // Toast.makeText(TRYActivity.this, "The value of y is" + y, Toast.LENGTH_SHORT).show();
                long x = new Date().getTime();
                //    int y=Integer.parseInt(y_v.getText().toString());

                // Pointvalue pointvalue = new Pointvalue(x, y);

                // reference.child(id).setValue(pointvalue);


            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapShot) {

                DataPoint[] db = new DataPoint[(int) dataSnapShot.getChildrenCount()];
                int index = 0;

                for (DataSnapshot myDataSnapShot : dataSnapShot.getChildren()) {
                    Pointvalue pointvalue = myDataSnapShot.getValue(Pointvalue.class);

                    db[index] = new DataPoint(pointvalue.getX(), pointvalue.getY());
                    index++;

                }
                series.resetData(db);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        //    series.setShape(PointsGraphSeries.Shape.POINT);
        series.setColor(Color.MAGENTA);
        //series.setSize(10f);


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
        FoodActivity.redirectActivity(this,InviteActivity.class);
    }

    public void ClickHome(View view){
        FoodActivity.redirectActivity(this,Profile.class);
    }

    public void ClickDashboard(View view){
        FoodActivity.redirectActivity(this,AnalysisActivity.class);
    }

    public void ClickGraph(View view){
        recreate();
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
