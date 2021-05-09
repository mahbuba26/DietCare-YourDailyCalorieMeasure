package com.example.fooddiet;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.PointsGraphSeries;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static android.widget.Toast.LENGTH_LONG;
import static android.widget.Toast.makeText;
import static com.example.fooddiet.MainActivity.openDrawer;
import static com.example.fooddiet.MainActivity.redirectActivity;
import static com.example.fooddiet.SetActivity.closeDrawer;

public class graph extends AppCompatActivity {
    DrawerLayout drawerLayout;
    private TextView edt;
    dietclass dbhelper;




    private static final String TAG="graph";
    PointsGraphSeries<DataPoint> xySeries;

    private Button btnAddPt;
    private EditText mX,mY;
    GraphView mScatterPlot;

    private ArrayList<XYValue> xyValueArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        drawerLayout=findViewById(R.id.drawer_layout);

        //edt=(TextView)findViewById(R.id.edt);
        btnAddPt=(Button)findViewById(R.id.btnAddPt);
        mX=(EditText)findViewById(R.id.numX);
        mY=(EditText)findViewById(R.id.numY);
        mScatterPlot=(GraphView)findViewById(R.id.scatterPlot);
        xyValueArray=new ArrayList<>();

        String user=getIntent().getStringExtra("keyname");

        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        TextView textViewDate = findViewById(R.id.text_view_date);
        textViewDate.setText(currentDate);
float myLat;
float myLong;
        Intent intent = getIntent();

        if(intent!=null) {
             //HAVE TO EAT CALORIE
            myLat = intent.getFloatExtra("keyname", 0);

            for (int i = 0; i < 30; i++) {
                xyValueArray.add(new XYValue(i, myLat));
            }
        }

        Intent intent2=getIntent();
            // myLong = intent.getDoubleExtra("keyname2", 0);
        if(intent2!=null) {
            //EATEN CALORIE
            myLong = intent.getFloatExtra("keyname2", 0);
           // Toast.makeText(graph.this, "You must fill out both fields!", Toast.LENGTH_SHORT).show();

            for (int i = 0; i < 30; i++) {
                xyValueArray.add(new XYValue(i, myLong));
            }
        }
       // }

        // double try=double.getDou()
//        edt.setText(user);
       // double xb =Double.parseDouble(user);
       // Log.d(TAG,"BBBB "+user);
       // double d = Double.parseDouble(user);
       try {//double xb =Double.parseDouble(user);

        }catch (NumberFormatException e) {

        }

        try {



            dbhelper = new dietclass(this);
            Cursor cursor=dbhelper.databaseToString1();

            if(cursor.getCount()==0){
                makeText(getApplicationContext(),"No data !", LENGTH_LONG).show();
            }
            else{
while(cursor.moveToNext()){
    makeText(getApplicationContext(),"Total Calorie !"+cursor.getDouble(3) ,Toast.LENGTH_SHORT).show();

    makeText(getApplicationContext(),"Date !"+cursor.getString(2) ,Toast.LENGTH_SHORT).show();
}
            }
            //dbhelper.insert_total(currentDate,calval);
            List<EatenItem> ei = dbhelper.getAllEatenData();
            //Log.d(TAG,"BBBB "+ei.size());
            for(int d=1;d<30;d++){
                for (int i = 0; i < ei.size(); i++) {
                //   qwertyuiop[]\78    EatenItem e = ei.get(i);-+
                            //.0  `   1azwaaaa2wz2wwx4rf f5v 6yb b7un  l/

                        //   \
                      //     `

                     //   20+
                                //+qwertyu0.
                                     //   azSXDFGHJMKL;'
                //456`123457890-/*`'
                    int cal = e.getCal();
                    String date = e.getDate();
                    String datestring = "16-02-2021";
                    /*
                    dateArr = date.split('-');
                    dateArr[0] = 16;
                    dateArr[1] = 02;.pppppppppppppppppppppppppppp....c
                    dateArr[2] = 2021
                    if(date.d  == d&&year==date.year && month==date.m) {
                        xyValueArray.add(new XYValue(d, cal));
                    }
                    */
                // Log.d(TAG,"BBBB "+cal);
                // Toast.makeText(graph.this, "cal is " + cal, Toast.LENGTH_SHORT).show();
                //}
            }
        }catch (Exception e){
            Log.d(TAG,"BBBB in exception "+e.getMessage());
        }
        init();

    }
    private void init(){

        xySeries=new PointsGraphSeries<>();

        btnAddPt.setOnClickListener(new View.OnClickListener() {
            @Override
           public void onClick(View v) {

                Intent intent=new Intent(graph.this,AnalysisActivity.class);
                startActivity(intent);
                if(!mX.getText().toString().equals("") && !mY.getText().toString().equals("")){

                    double x =Double.parseDouble(mX.getText().toString());
                    double y=Double.parseDouble(mY.getText().toString());
                    Log.d(TAG,"onClick: Adding a new point.(x,y):(" + x + ","+ y +")");
                    xyValueArray.add(new XYValue(x,y));

                    /*for(int i=0;i<30;i++){
                            xyValueArray.add(i,user);
                    }

                    init();*/

                    if(xyValueArray.size()!=0){
                        createScatterPlot();
                    }
                }
                else{
                    //Toast.makeText(graph.this, "You must fill out both fields!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        if(xyValueArray.size()!=0){
            createScatterPlot();
        }
        else{
            Log.d(TAG,"oncreate: No data to plot .");
        }
    }

    private void createScatterPlot() {
        Log.d(TAG,"createScatterPlot : Creating scatter plot .");
        xyValueArray=sortArray(xyValueArray);
        for(int i=0;i<xyValueArray.size();i++){
            try{
                double x= xyValueArray.get(i).getX();
                double y= xyValueArray.get(i).getY();
                xySeries.appendData(new DataPoint(x, (y)),true,1000);

            }
            catch (IllegalArgumentException e){
                Log.e(TAG,"createScatterPlot: IllegalArgumentException: "+ e.getMessage());
            }
        }
        xySeries.setShape(PointsGraphSeries.Shape.POINT);
        xySeries.setColor(Color.MAGENTA);
        xySeries.setSize(10f);

        mScatterPlot.getViewport().setScalable(true);
        mScatterPlot.getViewport().setScalableY(true);
        mScatterPlot.getViewport().setScrollable(true);
        mScatterPlot.getViewport().setScrollableY(true);

        mScatterPlot.getViewport().setYAxisBoundsManual(true);
        mScatterPlot.getViewport().setMaxX(30);
        mScatterPlot.getViewport().setMinX(0);


        mScatterPlot.getViewport().setYAxisBoundsManual(true);
        mScatterPlot.getViewport().setMaxY(5000);
        mScatterPlot.getViewport().setMinY(0);

        mScatterPlot.addSeries(xySeries);

    }
    private ArrayList<XYValue> sortArray(ArrayList<XYValue> array){
        int factor= Integer.parseInt(String.valueOf(Math.round(Math.pow(array.size(),2))));
        int m=array.size()-1;
        int count=0;
        Log.d(TAG,"sortArray:Sorting the XYArray. ");

        while(true){
            m--;
            if(m<=0){
                m=array.size()-1;
            }
            Log.d(TAG,"sortArray:m="+ m);
            try{
                double tempY=array.get(m-1).getY();
                double tempX=array.get(m-1).getX();
                if (tempX > array.get(m).getX()) {
                    array.get(m - 1).setY(array.get(m).getY());
                    array.get(m).setY(tempY);
                    array.get(m - 1).setX(array.get(m).getX());
                    array.get(m).setX(tempX);
                } else if (tempX == array.get(m).getX()) {
                    count++;
                    Log.d(TAG, "sortArray: count = " + count);
                } else if (array.get(m).getX() > array.get(m - 1).getX()) {
                    count++;
                    Log.d(TAG, "sortArray: count = " + count);
                }
                //break when factorial is done
                if (count == factor) {
                    break;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                Log.e(TAG, "sortArray: ArrayIndexOutOfBoundsException. Need more than 1 data point to create Plot." +
                        e.getMessage());
                break;
            }


        }
        return array;
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
        redirectActivity(this,MainActivity.class);
    }

    public void ClickDashboard(View view){
        redirectActivity(this,AnalysisActivity.class);
    }

    public void ClickGraph(View view){ recreate(); }
    public void ClickReminder(View view){
        redirectActivity(this,SetActivity.class);
    }
    public void ClickFriends(View view){
        redirectActivity(this,InviteActivity.class);
    }

    public void ClickAboutUs(View view){
        redirectActivity(this,FoodActivity.class);
    }

    public void ClickLogout(View view){
        logout(this);
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
