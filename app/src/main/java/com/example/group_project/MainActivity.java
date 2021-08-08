package com.example.group_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calButtonOnClick(View v) {
        Intent i = new Intent(getApplicationContext(),CalendarActivity.class);
        startActivity(i);
    }

    public void listButtonOnClick(View v) {
        Intent i = new Intent(getApplicationContext(), ListActivity.class);
        startActivity(i);
    }

    public void backButtonOnClick(View v) {
        Intent i = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(i);
    }
}