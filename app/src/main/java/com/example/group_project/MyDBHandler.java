package com.example.group_project;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;






public class MyDBHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "subInfoDB.db";
    public static final String TABLE_NAME = "SubInfo";
    public static final String COLUMN_ID = "SubId";
    public static final String COLUMN_NAME = "SubName";
    public static final String COLUMN_DATE = "Date";
    public static final String COLUMN_PRICE = "SubPrice";
    public static final String COLUMN_TYPE = "SubType";

    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ("
                + COLUMN_ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," + COLUMN_NAME
                + " STRING NOT NULL," + COLUMN_DATE + " STRING NOT NULL," + COLUMN_PRICE + " STRING NOT NULL," + COLUMN_TYPE + " STRING NOT NULL )";
        db.execSQL(CREATE_TABLE);

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){}
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
    public void addHandler(Subscription sub) {
        ContentValues values = new ContentValues();
        //values.put(COLUMN_ID, sub.getSubId());
        values.put(COLUMN_NAME, sub.getSubName());
        values.put(COLUMN_DATE, sub.getDate());
        values.put(COLUMN_PRICE, sub.getSubPrice());
        values.put(COLUMN_TYPE, sub.getSubType());

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_NAME, null, values);
        db.close();
    }
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


