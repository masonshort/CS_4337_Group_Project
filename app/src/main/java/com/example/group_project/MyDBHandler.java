package com.example.group_project;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;
import android.widget.Toast;

import androidx.annotation.Nullable;


public class MyDBHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "SubInfo.db";
    private static final String TABLE_NAME = "SubInfo";
    private static final String COLUMN_ID = "SubId";
    private static final String COLUMN_NAME = "SubName";
    private static final String COLUMN_DATE = "Date";
    private static final String COLUMN_PRICE = "SubPrice";
    private static final String COLUMN_TYPE = "SubType";
    private final Context context;

    public MyDBHandler(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ("
                + COLUMN_ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," + COLUMN_NAME
                + " TEXT NOT NULL," + COLUMN_DATE + " TEXT NOT NULL," + COLUMN_PRICE + " TEXT NOT NULL," + COLUMN_TYPE + " TEXT NOT NULL )";
        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }


    public String loadHandler() {
        String result = "";
        String query = "Select * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()) {
            int result_0 = cursor.getInt(0);
            String result_1 = cursor.getString(1);
            result += String.valueOf(result_0) + " " + result_1 +
                    System.getProperty("line.separator");
        }
        cursor.close();
        db.close();
        return result;
    }

    public void addHandler(String name, String date, String price, String type) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_DATE, date);
        values.put(COLUMN_PRICE, price);
        values.put(COLUMN_TYPE, type);

        long result = db.insert(TABLE_NAME, null, values);
        if (result == -1) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Add Successful", Toast.LENGTH_SHORT).show();
        }
        db.close();
    }

    Cursor readAllData() {
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if (db != null) {
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }


}
/*
    public Subscription findHandler(String subName) {
        String query = "Select * FROM " + TABLE_NAME + "WHERE" + COLUMN_NAME + " = " + "'" + subName + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Subscription sub = new Subscription();
        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            //sub.setSubId(Integer.parseInt(cursor.getString(0)));
            sub.setSubName(cursor.getString(1));
            sub.setDate(cursor.getString(2));
            sub.setSubPrice(cursor.getString(3));
            sub.setSubPrice(cursor.getString(4));
            cursor.close();
        } else {
            sub = null;
        }
        db.close();
        return sub;
    }
    public boolean deleteHandler(int ID) {
        boolean result = false;
        String query = "Select*FROM" + TABLE_NAME + "WHERE" + COLUMN_ID + "= '" + String.valueOf(ID) + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Subscription student = new Subscription();
        if (cursor.moveToFirst()) {
            student.setSubId(Integer.parseInt(cursor.getString(0)));
            db.delete(TABLE_NAME, COLUMN_ID + "=?",
                    new String[] {
                String.valueOf(student.getSubId())
            });
            cursor.close();
            result = true;
        }
        db.close();
        return result;
    }
    public boolean updateHandler(int ID, String name, String date, String price, String type) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues args = new ContentValues();
        args.put(COLUMN_ID, ID);
        args.put(COLUMN_NAME, name);
        args.put(COLUMN_DATE, date);
        args.put(COLUMN_PRICE, price);
        args.put(COLUMN_TYPE, type);
        return db.update(TABLE_NAME, args, COLUMN_ID + "=" + ID, null) > 0;
    }

}
*/

