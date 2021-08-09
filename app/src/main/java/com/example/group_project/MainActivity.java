package com.example.group_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void addButtonOnClick (View v) {
        Intent i = new Intent(getApplicationContext(),NewSubActivity.class);
        startActivity(i);
    }
    public void viewButtonOnClick (View v){
        Intent i = new Intent(getApplicationContext(),ListActivity.class);
        startActivity(i);
    }

}

