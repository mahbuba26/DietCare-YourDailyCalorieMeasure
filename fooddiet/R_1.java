package com.example.fooddiet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class R_1 extends AppCompatActivity {

    Toolbar mtool;
    TextView res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r_1);

        mtool = (Toolbar)findViewById(R.id.tbr1);
        //mtool.setTitleTextColor();
        res = (TextView)findViewById(R.id.tv);
        loadText();
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null)
        {
            mtool.setTitle(bundle.getString("RecipeName"));
            if(mtool.getTitle().toString().equalsIgnoreCase("Carbohydrate")){
                String rec1=
                        " •\t Sugar - 4 Calories\n" +
                                "\n" +
                                " •\t Cookies - 5 calories\n" +
                                "\n" +
                                " •\t Cooked rice - 1 calories\n" +
                                "\n" +
                                " •\t White bread - 3 calories\n" +
                                "\n" +
                                " •\t Corn - 1 calories\n" +
                                "\n" +
                                " •\t Cake - 3 calories\n" +
                                "\n" +
                                " •\t Chocolate - 5 calories\n" +
                                "\n" +
                                " •\t Fruit juice - 1 calories\n" +
                                "\n" +
                                " •\t Wheat floar - 4 calories\n" +
                                "\n" +
                                " •\t Yogurt - 1 calories\n" +
                                "\n" +
                                " •\t Honey - 3 calories\n" +
                                "\n" +
                                " •\t Fruits - 1 calories\n" +
                                "\n" +
                                " •\t Vegetables - 1 calories\n";
                res.setText(rec1);
            }
            else if(mtool.getTitle().toString().equalsIgnoreCase("Protein")){
                String rec1=
                        " •\t Chicken - 2390 calories\n" +
                                "\n" +
                                " •\t Fish - 2054 calories\n" +
                                "\n" +
                                " •\t Cheese - 4025 calories\n" +
                                "\n" +
                                " •\t Egg - 1551 calories\n" +
                                "\n" +
                                " •\t Beans - 3470 calories\n" +
                                "\n" +
                                " •\t Almonds - 6 calories\n" +
                                "\n" +
                                " •\t Oats - 4 calories\n" +
                                "\n" +
                                " •\t Milk - 4230 calories\n" +
                                "\n" +
                                " •\t Broccoli - 6 calories\n" +
                                "\n" +
                                " •\t Leaf bean - 2505 calories\n" +
                                "\n" +
                                " •\t Lentils - 1164 calories\n" +
                                "\n" +
                                " •\t Pumpkin seeds - 4460 calories\n";
                res.setText(rec1);
            }
            else if(mtool.getTitle().toString().equalsIgnoreCase("Fat")){
                String rec1=
                        " •\t avocados - 1061 calories\n" +
                                "\n" +
                                " •\t Chia seeds - 4861 calories\n" +
                                "\n" +
                                " •\t  Dark chocolate - 6 calories\n" +
                                "\n" +
                                " •\t Fatty fish - 2054 calories\n" +
                                "\n" +
                                " •\t Nuts - 6064 calories\n" +
                                "\n" +
                                " •\t Olives - 10 calories\n" +
                                "\n" +
                                " •\t Cheese - 4025 calories\n" +
                                "\n" +
                                " •\t Butter - 7168 calories\n" +
                                "\n" +
                                " •\t Soybean - 4460 calories\n" +
                                "\n" +
                                " •\t Eggs - 9 calories\n" +
                                "\n" +
                                " •\t Olive oil - 4481 calories\n";

                res.setText(rec1);
            }
            else if(mtool.getTitle().toString().equalsIgnoreCase("Vitamin")){
                String rec1=
                        " •\tFish - Vitamins A, B1, B2, B3, B5, B6, B12, D, and E\n" +
                                " •\tDark Leafy Greens – Vitamins A, B2, B3, B6, B9, C, E, K, and Beta-Carotene\n" +
                                " •\tSeeds – Vitamins B1, B2, B3, B5, B5, B6, and E\n" +
                                " •\tBroccoli –  Vitamins A, B9, C, E, K, and Beta Carotene\n" +
                                " •\tPork – Vitamins B1, B2, B3, B5, B6, and D\n" +
                                " •\tBeef and Lamb – Vitamins B2, B3, B5, B6, and B9\n" +
                                " •\tMushrooms –  Vitamins B2, B3, B5, and D\n" +
                                " •\tNuts –  Vitamins B1, B2, B6, and E\n" +
                                " •\tEggs - Vitamins B2, B5, B12, and D\n" +
                                " •\tSweet Bell Peppers - Vitamins A, and C, Beta-Carotene, and Lycopene\n" +
                                " •\tAvocados - Vitamins B5, B6, B9, and E\n" +
                                " •\tGreen Peas - Vitamins A, B1, E, and Beta Carotene\n" +
                                " •\tWinter Squash -  Vitamins A, B1, E, and Beta Carotene\n" +
                                " •\tTropical Fruits -  Vitamins A, B1, E, and Lycopene\n" +
                                " •\tDried fruits - Vitamins A, B6, K, and Beta Carotene\n" ;
                res.setText(rec1);
            }
            else if(mtool.getTitle().toString().equalsIgnoreCase("Mineral")){
                String rec1=
                        " •\tAlmonds\n" +
                                " •\tNuts and seeds\n" +
                                " •\tShellfish\n" +
                                " •\tDark Leafy Greens\n" +
                                " •\tSalmon\n" +
                                " •\tSeeds\n" +
                                " •\tMushrooms\n" +
                                " •\tMustard seeds \n" +
                                " •\tWhole Grains\n" +
                                " •\tYogurt\n" +
                                " •\tBeef and Lamb\n" +
                                " •\tAvocados\n" +
                                " •\tDark Chocolate and Cocoa Powder\n" +
                                " •\tTofu\n" +
                                " •\tDried Fruits\n" +
                                " •\t Cruciferous vegetables \n";
                res.setText(rec1);
            }
            else if(mtool.getTitle().toString().equalsIgnoreCase("Water")) {
                String rec1 =
                        " •\tCucumbers\n" +
                                " •\tCarrots\n" +
                                " •\tZucchini\n" +
                                " •\tIceberg Lettuce\n" +
                                " •\tSpinach\n" +
                                " •\tCelery\n" +
                                " •\tCauliflower\n" +
                                " •\tSoup\n" +
                                " •\tTomatoes\n" +
                                " •\tSpinach\n" +
                                " •\tStrawberries\n" +
                                " •\tYogurt\n" +
                                " •\tOatmeal\n" +
                                " •\tGrapefruit\n";
                res.setText(rec1);
            }


        }
    }
    private void loadText(){
        res.setMovementMethod(new ScrollingMovementMethod());
    }


}


