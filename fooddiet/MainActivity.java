import static java.sql.Types.NULL;

public class MainActivity extends AppCompatActivity {
    private Button btnFemale,btnMale,btnno,btnone,btntwo,btnthree,add;
    private EditText edtAns,Inage,Inheight,Inweight,edtansdee;
    private TextView txtHeight,txtWeight,txtAge,txtBmr,txttdee;
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout=findViewById(R.id.drawer_layout);
        add=(Button)findViewById(R.id.add);
        btnFemale=(Button)findViewById(R.id.btnFemale);
        btnMale=(Button)findViewById(R.id.btnMale);
        edtAns=(EditText)findViewById(R.id.edtAns);
       Inage=(EditText)findViewById(R.id.edtInage);
        edtansdee=(EditText)findViewById(R.id.edtansdee);
       Inheight=(EditText)findViewById(R.id.edtInheight);
        Inweight=(EditText)findViewById(R.id.edtInweight);
        txtAge=(TextView)findViewById(R.id.txtAge);
        txtBmr=(TextView)findViewById(R.id.txtBmr);
        txtWeight=(TextView)findViewById(R.id.txtWeight);
        txtHeight=(TextView)findViewById(R.id.txtHeight);
        //txttdee=(TextView)findViewById(R.id.edtdee);
        btnno=(Button)findViewById(R.id.btnno);
        btnone=(Button)findViewById(R.id.btnone);
        btntwo=(Button)findViewById(R.id.btntwo);
        btnthree=(Button)findViewById(R.id.btnthree);

       //* double myDouble;

       // String myString = ((EditText) findViewById(R.id.editText1)).getText().toString();

        //if (myString != null && !myString.equals("")) {
           // myDouble = Double.valueOf(myString);
        //}// else {
           // myDouble = 0;
       // }*//
        btnMale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                   float weight ;
                float height;
                float age;
                float bmr1;

                String height1 = Inheight.getText().toString();
                String weight1 = Inweight.getText().toString();
                String age1 = Inage.getText().toString();

                if(height1.equals("")){Inheight.setError("Please enter your height");
                    Inheight.requestFocus();
                    return;}
                else if(weight1.equals("")){Inweight.setError("Please enter your weight");
                    Inweight.requestFocus();
                    return;}
                else if(age1.equals("")){Inage.setError("Please enter your age");
                    Inage.requestFocus();
                    return;}


                height =Float.parseFloat(height1);
                weight = Float.parseFloat(weight1);
                age = Float.parseFloat(age1);

                    // bmr1 = ((10 * weight) + (6.25 * height) - (5 * age) + 5);
                    bmr1= (float) (88.362+(13.397*weight)+(4.799*height)-(5.677*age));
                    edtAns.setText( bmr1 + "");

                float bmiValue = calculateBMI(weight, height);


//Define the meaning of the bmi value
                String bmiInterpretation = interpretBMI(bmiValue);

                Toast toast = Toast.makeText(MainActivity.this, "Your BMI " + bmiValue+"-"+bmiInterpretation, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();




                }


        });

        btnFemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float weight;
                float height;
                double age;
                double bmr3;
                String height1 = Inheight.getText().toString();
                String weight1 = Inweight.getText().toString();
                String age1 = Inage.getText().toString();
                if(height1.equals("")){Inheight.setError("Please enter your height");
                    Inheight.requestFocus();
                    return;}
                else if(weight1.equals("")){Inweight.setError("Please enter your weight");
                    Inweight.requestFocus();
                    return;}

                else if(age1.equals("")){Inage.setError("Please enter your age");
                    Inage.requestFocus();
                    return;}

                height =Float.parseFloat(height1);
                weight =Float.parseFloat(weight1);
                age = Float.parseFloat(age1);
                bmr3=((10*weight)+(6.25*height)-(5*age)-161);
                // bmr1 = ((10 * weight) + (6.25 * height) - (5 * age) + 5);
               // bmr3=(447.597+(9.247*weight)+(3.098*height)-(4.330*age));
                edtAns.setText( bmr3+"");

                float bmiValue = calculateBMI(weight, height);


//Define the meaning of the bmi value
                String bmiInterpretation = interpretBMI(bmiValue);

                Toast toast = Toast.makeText(MainActivity.this, "Your BMI " + bmiValue+"-"+bmiInterpretation, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();



            }
        });

        btnno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float no;
                float Anstd;

                String bttnno = edtAns.getText().toString();
                if (bttnno.equals("")) {
                    edtAns.setError("You must check your BMR first!");
                    edtAns.requestFocus();
                    return;}

                Anstd = Float.parseFloat(bttnno);

                        no = (float) (Anstd * 1.2);

                        edtansdee.setText(no + " Calories is needed");

                        float get = no;
                        Intent intent = new Intent(MainActivity.this, graph.class);
                        intent.putExtra("keyname", get);
                        startActivity(intent);

                }

        });

        btnone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float no;
                float Anstd;

                String bttnno = edtAns.getText().toString();
                if (bttnno.equals("")) {
                    edtAns.setError("You must check your BMR first!");
                    edtAns.requestFocus();
                    return;}

                Anstd = Float.parseFloat(bttnno);



                no= (float) (Anstd*1.375);

                edtansdee.setText(no +" Calories is needed");

                float get=no;
                Intent intent=new Intent(MainActivity.this,graph.class);
                intent.putExtra("keyname",get);
                startActivity(intent);
            }



        });

        btntwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float no;
                float Anstd;

                String bttnno = edtAns.getText().toString();
                if (bttnno.equals("")) {
                    edtAns.setError("You must check your BMR first!");
                    edtAns.requestFocus();
                    return;}

                Anstd = Float.parseFloat(bttnno);

                no= (float) (Anstd*1.55);

                edtansdee.setText(no +" Calories is needed");

               float get=no;
                Intent intent=new Intent(MainActivity.this,graph.class);
                intent.putExtra("keyname",get);
                startActivity(intent);
                }

        });

        btnthree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float no;
                float Anstd;

                String bttnno = edtAns.getText().toString();
                if (bttnno.equals("")) {
                    edtAns.setError("You must check your BMR first!");
                    edtAns.requestFocus();
                    return;}

                Anstd = Float.parseFloat(bttnno);

                no= (float) (Anstd*1.725);

                edtansdee.setText(no +" Calories is needed");

               float get=no;

                Intent intent=new Intent(MainActivity.this,graph.class);
               intent.putExtra("keyname",get);
                //intent.putExtra("keyname",get);
                startActivity(intent);

               // Intent intent2=new Intent(MainActivity.this,AnalysisActivity.class);
               // intent2.putExtra("keyname",get);
                //intent.putExtra("keyname",get);
               // startActivity(intent2);
            }



        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String get=edtansdee.getText().toString();
                if(get!=null){
                Intent intent=new Intent(MainActivity.this,graph.class);
                intent.putExtra("keyname", Double.parseDouble(get));
                startActivity(intent);
                }
                else{
                    Toast.makeText(MainActivity.this, "You must check your BMR!", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private float calculateBMI (float weight, float height) {
        return  (weight*10000 / (height * height ));
    }

    // Interpret what BMI means
    private String interpretBMI(float bmiValue) {

        if (bmiValue < 16) {
            return "Severely underweight";
        } else if (bmiValue < 18.5) {

            return "Underweight";
        } else if (bmiValue < 25) {

            return "Normal";
        } else if (bmiValue < 30) {

            return "Overweight";
        } else {
            return "Obese";
        }
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
        recreate();
    }

    public void ClickDashboard(View view){
        redirectActivity(this,AnalysisActivity.class);
    }

    public void ClickGraph(View view){
        MainActivity.redirectActivity(this,graph.class);
    }

    public void ClickAboutUs(View view){
        redirectActivity(this,FoodActivity.class);
    }
    public void ClickReminder(View view){
        MainActivity.redirectActivity(this,SetActivity.class);
    }
    public void ClickFriends(View view){
        MainActivity.redirectActivity(this,InviteActivity.class);
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
