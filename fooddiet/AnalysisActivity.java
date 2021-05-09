package com.example.fooddiet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

import static android.widget.Toast.LENGTH_LONG;
import static android.widget.Toast.makeText;

public class AnalysisActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    EditText quantity;
    TextView calories;
    Button calculate,calthis;
    Button add;
    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;
   float total =0;
    dietclass dbhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analysis);

        drawerLayout=findViewById(R.id.drawer_layout);
        quantity = (EditText) findViewById(R.id.etquantity);
        calories = (TextView) findViewById(R.id.calories);
        calculate = (Button) findViewById(R.id.calculate);
        add = (Button) findViewById(R.id.add);
        calthis =(Button) findViewById(R.id.calthis);
        spinner = (Spinner) findViewById(R.id.spinner);
        adapter = ArrayAdapter.createFromResource(this,R.array.itemcal,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(),parent.getItemAtPosition(position)+" selected ",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        if(!prefs.getBoolean("firstTime", false)) {

            dbhelper = new dietclass(this);
            dbhelper.insertCal_ValEntry("Porridge", "1cup",150);
            dbhelper.insertCal_ValEntry("Cake","500g", 1285);
            dbhelper.insertCal_ValEntry("Egg Boiled","1", 80);
            dbhelper.insertCal_ValEntry("Egg Poached","1", 80);
            dbhelper.insertCal_ValEntry("Egg Fried","1", 110);
            dbhelper.insertCal_ValEntry("Egg Omelet","1", 120);
            dbhelper.insertCal_ValEntry("Bread Slice","1", 45);
            dbhelper.insertCal_ValEntry("Bread Slice with butter","1", 90);
            dbhelper.insertCal_ValEntry("Chapati","1", 60);
            dbhelper.insertCal_ValEntry("Puri","1", 75);
            dbhelper.insertCal_ValEntry("Paratha","1", 150);
            dbhelper.insertCal_ValEntry("Subji","1cup", 150);
            dbhelper.insertCal_ValEntry("Idli","1", 100);
            dbhelper.insertCal_ValEntry("Dosa Plain","1", 120);
            dbhelper.insertCal_ValEntry("Dosa Masala","1", 250);
            dbhelper.insertCal_ValEntry("Sambhar","1cup", 150);
            dbhelper.insertCal_ValEntry("Cooked Plain Rice","1", 120);
            dbhelper.insertCal_ValEntry("Coocked Fried Rice","1", 150);
            dbhelper.insertCal_ValEntry("Nan","1", 150);
            dbhelper.insertCal_ValEntry("Dal","1", 150);
            dbhelper.insertCal_ValEntry("Curd","1cup", 100);
            dbhelper.insertCal_ValEntry("Vegetable Curry","1", 150);
            dbhelper.insertCal_ValEntry("Meat Curry","1", 175);
            dbhelper.insertCal_ValEntry("Salad","1cup", 100);
            dbhelper.insertCal_ValEntry("Papad","1", 45);
            dbhelper.insertCal_ValEntry("Cutlet","1", 75);
            dbhelper.insertCal_ValEntry("Pickle","1tsp", 30);
            dbhelper.insertCal_ValEntry("Soup","1", 75);
            dbhelper.insertCal_ValEntry("Tea without sugar","1", 10);
            dbhelper.insertCal_ValEntry("Coffee without sugar","1",10);
            dbhelper.insertCal_ValEntry("Tea with sugar","1", 45);
            dbhelper.insertCal_ValEntry("Coffee with sugar","1", 45);
            dbhelper.insertCal_ValEntry("Milk with sugar","1", 60);
            dbhelper.insertCal_ValEntry("Milk with sugar and horlicks","1",120 );
            dbhelper.insertCal_ValEntry("Milk without sugar","1", 75);
            dbhelper.insertCal_ValEntry("Fruit Juice","1", 120);
            dbhelper.insertCal_ValEntry("Soft Drinks","1", 90);
            dbhelper.insertCal_ValEntry("Beer","1", 200);
            dbhelper.insertCal_ValEntry("Soda","1", 10);
            dbhelper.insertCal_ValEntry("Alcohol Neat","1", 75);
            dbhelper.insertCal_ValEntry("Jam","1tsp", 30);
            dbhelper.insertCal_ValEntry("Butter","1tsp", 50);
            dbhelper.insertCal_ValEntry("Ghee","1tsp", 50);
            dbhelper.insertCal_ValEntry("Sugar","1tsp", 30);
            dbhelper.insertCal_ValEntry("Biscuit","1", 30);
            dbhelper.insertCal_ValEntry("Fried Nuts","1", 300);
            dbhelper.insertCal_ValEntry("Pudding","1cup",200 );
            dbhelper.insertCal_ValEntry("Ice-cream","1cup", 200);
            dbhelper.insertCal_ValEntry("Milk-shake","1glass", 200);
            dbhelper.insertCal_ValEntry("Wafers","1pkt", 100);
            dbhelper.insertCal_ValEntry("Samosa","1", 100);
            dbhelper.insertCal_ValEntry("Bhel-puri","1", 150);
            dbhelper.insertCal_ValEntry("Pani-puri","1", 150);
            dbhelper.insertCal_ValEntry("Kebab","1plate", 150);
            dbhelper.insertCal_ValEntry("Indian Sweets","1pc", 150);
            dbhelper.insertCal_ValEntry("Potato Fried","1cup", 200);
            dbhelper.insertCal_ValEntry("Potato Mash","1cup", 100);
            dbhelper.insertCal_ValEntry("Sandwich","1large", 250);
            dbhelper.insertCal_ValEntry("Hamburger","1pc", 250);
            dbhelper.insertCal_ValEntry("Spaghetti and Meat","1", 450);
            dbhelper.insertCal_ValEntry("Fried Chicken","1", 200);
            dbhelper.insertCal_ValEntry("Chinese Noodles","1plate", 450);
            dbhelper.insertCal_ValEntry("Fried Rice","1plate", 450);
            dbhelper.insertCal_ValEntry("Pizza","1plate", 400);
            dbhelper.insertCal_ValEntry("Sausage","1", 120);
            dbhelper.insertCal_ValEntry("Apple","1medium", 65);
            dbhelper.insertCal_ValEntry("Banana","1medium", 50);
            dbhelper.insertCal_ValEntry("Blackberries","1cup", 50);
            dbhelper.insertCal_ValEntry("Blueberries","1cup", 50);
            dbhelper.insertCal_ValEntry("Cabbage","1cup", 20);
            dbhelper.insertCal_ValEntry("Carrot","1medium", 55);
            dbhelper.insertCal_ValEntry("Cherries","1cup", 270);
            dbhelper.insertCal_ValEntry("Corn","1cob", 60);
            dbhelper.insertCal_ValEntry("Cucumber","1medium", 10);
            dbhelper.insertCal_ValEntry("Grapefruit","1medium", 20);
            dbhelper.insertCal_ValEntry("Grapes","1largebunch", 310);
            dbhelper.insertCal_ValEntry("Green Beans","1", 30);
            dbhelper.insertCal_ValEntry("Kiwi","1", 40);
            dbhelper.insertCal_ValEntry("Mango","1", 100);
            dbhelper.insertCal_ValEntry("Onion","1", 30);
            dbhelper.insertCal_ValEntry("Orange","1", 80);
            dbhelper.insertCal_ValEntry("Papaya","1", 80);
            dbhelper.insertCal_ValEntry("Peach","1", 40);
            dbhelper.insertCal_ValEntry("Pear","1", 75);
            dbhelper.insertCal_ValEntry("Peas","1", 60);
            dbhelper.insertCal_ValEntry("Pineapple","1", 55);
            dbhelper.insertCal_ValEntry("Plum","1", 35);
            dbhelper.insertCal_ValEntry("Potato","1", 125);
            dbhelper.insertCal_ValEntry("Raspberries","1", 35);
            dbhelper.insertCal_ValEntry("Biryani veg","1", 200);
            dbhelper.insertCal_ValEntry("Biryani mutton","1", 225);
            dbhelper.insertCal_ValEntry("Carrot Halwa","1", 165);
            dbhelper.insertCal_ValEntry("Jalebi","1", 100);
            dbhelper.insertCal_ValEntry("Kheer","1", 180);
            dbhelper.insertCal_ValEntry("Rasgulla","1", 140);
            dbhelper.insertCal_ValEntry("Mineral Water","1",350);
            dbhelper.insertCal_ValEntry("Cereal Bar","1", 250);
            dbhelper.insertCal_ValEntry("Arugula","1", 5);
            dbhelper.insertCal_ValEntry("Honey dew Melon","1",61);
            dbhelper.insertCal_ValEntry("Bulgar","1", 152);
            dbhelper.insertCal_ValEntry("Soba Noodles","1", 113);
            dbhelper.insertCal_ValEntry("Wheat Bran","1", 124);
            dbhelper.insertCal_ValEntry("Rice Cake","1", 35);
            dbhelper.insertCal_ValEntry("Cod","1", 701);
            dbhelper.insertCal_ValEntry("Mussels","1", 73);
            dbhelper.insertCal_ValEntry("Thyme","1", 3);

            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("firstTime", true);
            editor.apply();
        }
        else {
            dbhelper = new dietclass(this);
        }


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String itemnew = spinner.getSelectedItem().toString();
                String quannew = quantity.getText().toString();
                float calnew = dbhelper.databaseToString(itemnew,quannew);
                Toast.makeText(getApplicationContext(),"Successfully added",Toast.LENGTH_LONG).show();
                total = total + calnew;
            }
        });
        calthis.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String item1 = spinner.getSelectedItem().toString();
                String quan1 = quantity.getText().toString();
                float cal1 = dbhelper.databaseToString(item1, quan1);
                String dbstr = cal1 +"\n"+ "calories";
                calories.setText(String.valueOf(dbstr));
            }
        });

        calculate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                float calvalue = total;

                String dbstring = calvalue +"\n"+ "calories";
                calories.setText(String.valueOf(dbstring));
                Date currentDate = Calendar.getInstance().getTime();
                dbhelper.insert_total(currentDate,Float.toString(calvalue));
                makeText(getApplicationContext(),"Total added in DB !", LENGTH_LONG).show();
                float my;
                //Intent intent2 = getIntent();
               // my = intent2.getFloatExtra("keyname", 0);

                Intent intent=new Intent(AnalysisActivity.this,graph.class);
                intent.putExtra("keyname2",calvalue);
                //intent.putExtra("keyname3",my);
                startActivity(intent);

            }
        });
    }



    public void ClickMenu(View view){
        MainActivity.openDrawer(drawerLayout);

    }

    public void ClickLogo(View view){
        MainActivity.closeDrawer(drawerLayout);
    }

    public void ClickReminder(View view){
        MainActivity.redirectActivity(this,SetActivity.class);
    }
    public void ClickFriends(View view){
        MainActivity.redirectActivity(this,InviteActivity.class);
    }

    public void ClickHome(View view){
        MainActivity.redirectActivity(this,MainActivity.class);
    }

    public void ClickDashboard(View view){
        recreate();
    }

    public void ClickGraph(View view){
        MainActivity.redirectActivity(this,graph.class);
    }

    public void ClickAboutUs(View view){
        MainActivity.redirectActivity(this,FoodActivity.class);
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
