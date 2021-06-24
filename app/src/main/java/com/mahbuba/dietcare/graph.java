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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.PointsGraphSeries;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class graph extends AppCompatActivity {
    DrawerLayout drawerLayout;
    private TextView edt;
    FirebaseAuth mAuth;
    FirebaseDatabase database;
    DatabaseReference reference;
    PointsGraphSeries<DataPoint> series;
    SimpleDateFormat sdf = new SimpleDateFormat("dd");
    GraphView graphView;
    //  LineGraphSeries series;


    private static final String TAG = "graph";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph2);

        // initializing our variable for graph view.
        graphView = findViewById(R.id.scatterPlot);
        drawerLayout = findViewById(R.id.drawer_layout);
        //PointsGraphSeries<DataPoint> series = new PointsGraphSeries<>();
        series = new PointsGraphSeries<>();
        // below line is to add series
        // to our graph view.
        graphView.addSeries(series);
        //     series = new LineGraphSeries();
        //      graphView.addSeries(series);
        //    mAuth=FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        //reference = database.getReference("graph");
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        String userID = user.getUid();
        reference = database.getReference(userID);

        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        //  TextView textViewDate = findViewById(R.id.textView56);
        //    textViewDate.setText(currentDate);

        String id = reference.push().getKey();
        int y = (int) AnalysisActivity.getValue();
        long x = new Date().getTime();


        graphView.getGridLabelRenderer().setNumHorizontalLabels(5);

    }


    @Override
    protected void onStart() {
        super.onStart();

        reference.limitToLast(30).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapShot) {

                DataPoint[] db = new DataPoint[(int) dataSnapShot.getChildrenCount()];
                int index = 0;

                for (DataSnapshot myDataSnapShot : dataSnapShot.getChildren()) {
                    Pointvalue pointvalue = myDataSnapShot.getValue(Pointvalue.class);

                    db[index] = new DataPoint(pointvalue.getX(), pointvalue.getTotal());
                    index++;

                }
                series.resetData(db);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



        graphView.getViewport().setXAxisBoundsManual(true);
        graphView.getViewport().setMaxX(30);
        graphView.getViewport().setMinX(0);


        graphView.getViewport().setYAxisBoundsManual(true);
        graphView.getViewport().setMaxY(10000);
        graphView.getViewport().setMinY(0);

        // below line is to activate
        // horizontal scrolling.
        graphView.getViewport().setScrollable(true);

        // below line is to activate horizontal
        // zooming and scrolling.
        graphView.getViewport().setScalable(true);

        // below line is to activate vertical and
        // horizontal zoom with scrolling.
        graphView.getViewport().setScalableY(true);

        // below line is to activate vertical scrolling.
        graphView.getViewport().setScrollableY(true);

        // below line is to set shape
        // for the point of graph view.
        series.setShape(PointsGraphSeries.Shape.POINT);

        // below line is to set
        // the size of our shape.
        series.setSize(12);

        // below line is to add color
        // to our shape of graph view.
        series.setColor(Color.MAGENTA);
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
        recreate();}
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