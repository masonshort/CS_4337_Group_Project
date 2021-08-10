package com.example.group_project;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    MyDBHandler db;
    ArrayList<String> subName, subDate, subPrice, subType;
    DisplayAdapter displayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        recyclerView = findViewById(R.id.recyclerView);

        db = new MyDBHandler(ListActivity.this);

        subName = new ArrayList<>();
        subDate = new ArrayList<>();
        subPrice = new ArrayList<>();
        subType = new ArrayList<>();

        displayData();
        displayAdapter = new DisplayAdapter(ListActivity.this, subName, subDate, subPrice, subType);
        recyclerView.setAdapter(displayAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(ListActivity.this));

    }


    public void calendarSwitchClick(View v){
        Intent i = new Intent(getApplicationContext(), CalendarActivity.class);
        startActivity(i);
    }

    void displayData(){
        Cursor cursor = db.readAllData();
        if (cursor.getCount() == 0){
            Toast.makeText(this, "No Data to display", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                subName.add(cursor.getString(1));
                subDate.add(cursor.getString(2));
                subPrice.add(cursor.getString(3));
                subType.add(cursor.getString(4));
            }
        }
    }
}
