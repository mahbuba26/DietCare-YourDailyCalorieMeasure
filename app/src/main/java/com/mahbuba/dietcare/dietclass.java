package com.mahbuba.dietcare;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Date;

public class dietclass extends SQLiteOpenHelper {
    private static final String TAG="dietclass";

    public static final String DATABASE_NAME = "diet7.db";
    public static final String TABLE_NAME = "Cal_val";
    public static final String EATEN_TABLE_NAME = "Eaten_Item";
    public static final String COL1 = "ID";
    public static final String COL2 = "ITEM";
    public static final String COL3 = "QUANTITY";
    public static final String COL4 = "CALORIES";
    public static final String COLu1 = "ID2";
    public static final String COLu3 = "QUANTITY2";
    SQLiteDatabase myDataBase;


    private Context MyContext;

    public dietclass(Context context) {
        super(context,DATABASE_NAME,null,1);
        myDataBase = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,ITEM TEXT,QUANTITY VARCHAR,CALORIES INTEGER)");
        db.execSQL("create table " + EATEN_TABLE_NAME + " (ID2 INTEGER PRIMARY KEY AUTOINCREMENT,QUANTITY2 VARCHAR)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME);
        onCreate(db);

        db.execSQL("DROP TABLE IF EXISTS " +EATEN_TABLE_NAME);
        onCreate(db);
    }

    public long insertCal_ValEntry(String item, String quantity, int calories) {
        ContentValues cv = new ContentValues();
        cv.put(COL2,item);
        cv.put(COL3,quantity);
        cv.put(COL4,calories);
        return myDataBase.insert(TABLE_NAME,null,cv);
    }
    public long insert_total( String calval) {
        ContentValues cv1 = new ContentValues();
        cv1.put(COLu3,calval);
        return myDataBase.insert(EATEN_TABLE_NAME,null,cv1);
    }


    public float databaseToString(String item_name, String quantity) {
        String add="";
        String query = "SELECT * FROM "+TABLE_NAME+" WHERE ITEM='"+item_name+"'"+"COLLATE NOCASE";
        Cursor c = myDataBase.rawQuery(query,null);

        if(c.moveToFirst()){
            add = c.getString(c.getColumnIndex("CALORIES"));
            c.close();
        }
        float quan=Float.parseFloat(quantity);
        float cal =Float.parseFloat(add);
        float calval = quan*cal;
        //add = calval +"\n"+ " calories";
        //return add;
        return calval;
    }
    public float databaseToString2(String calval) {
        String add="";
        String query = "SELECT * FROM "+TABLE_NAME+" WHERE QUANTITY2='"+calval+"'"+"COLLATE NOCASE";
        Cursor c = myDataBase.rawQuery(query,null);

        if(c.moveToFirst()){
            add = c.getString(c.getColumnIndex("CALORIES"));
            c.close();
        }
        float quan=Float.parseFloat(calval);

        //add = calval +"\n"+ " calories";
        //return add;
        return quan;
    }







    //public List<EatenItem> getAllEatenData() {
    //  String add="";
    // List<EatenItem> ei = new ArrayList<>();
    // String query = "SELECT * FROM "+EATEN_TABLE_NAME;
    //Log.d(TAG,"BBBB "+query);



//        Cursor c = myDataBase.rawQuery(query,null);
    // int ei_date = 1;
    // String c;
    //if(c.moveToNext()){
    //  String cal = c.getString(c.getColumnIndex("CALORIES"));
    //Log.i(TAG,"BBBB "+cal);
    //  ei_date++;
    //  ei.add(new EatenItem(e,ei_date));
    //c.close();
}

// c.close();
//return c;
//      }
//}



//public List<EatenItem> getAllEatenData() {
// String add="";
// List<EatenItem> ei = new ArrayList<>();
// String query = "SELECT * FROM "+EATEN_TABLE_NAME;
//Log.d(TAG,"BBBB "+query);



//        Cursor c = myDataBase.rawQuery(query,null);
// int ei_date = 1;
// String c;
//if(c.moveToNext()){
//  String cal = c.getString(c.getColumnIndex("CALORIES"));
//Log.i(TAG,"BBBB "+cal);
//  ei_date++;
//  ei.add(new EatenItem(e,ei_date));
//c.close();
//  }

// c.close();
//return c;
//      }
//}

