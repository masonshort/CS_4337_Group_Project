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

    void updateHandler(String id, String name, String date, String price, String type){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, id);
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_DATE, date);
        values.put(COLUMN_PRICE, price);
        values.put(COLUMN_TYPE, type);

        long result = database.update(TABLE_NAME, values, "SubId=?", new String[]{id});

        if (result == -1) {
            Toast.makeText(context, "Failed to Update", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Update Successful", Toast.LENGTH_SHORT).show();
        }
    }

    void deleteHandler(String rowId){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME, "SubId=?", new String[]{rowId});
        if (result == -1) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Delete Successful", Toast.LENGTH_SHORT).show();
        }
        db.close();
    }
}


