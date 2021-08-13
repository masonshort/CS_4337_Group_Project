package com.example.group_project;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Button calSwitch;

    MyDBHandler db;
    ArrayList<String> subId, subName, subDate, subPrice, subType;
    DisplayAdapter displayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        calSwitch = findViewById(R.id.calendarButton);
        recyclerView = findViewById(R.id.recyclerView);
        db = new MyDBHandler(ListActivity.this);

        subId = new ArrayList<>();
        subName = new ArrayList<>();
        subDate = new ArrayList<>();
        subPrice = new ArrayList<>();
        subType = new ArrayList<>();

        displayData();
        displayAdapter = new DisplayAdapter(ListActivity.this, this, subId, subName, subDate, subPrice, subType);
        recyclerView.setAdapter(displayAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(ListActivity.this));

        calSwitch.setOnClickListener(this::calendarSwitchClick);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent intent){
        super.onActivityResult(requestCode,resultCode,intent);
        if(requestCode == 0){
            recreate();
        }
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
                subId.add(cursor.getString(0));
                subName.add(cursor.getString(1));
                subDate.add(cursor.getString(2));
                subPrice.add(cursor.getString(3));
                subType.add(cursor.getString(4));
            }
        }
    }
}
