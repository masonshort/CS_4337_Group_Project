package com.example.group_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class MainActivity extends AppCompatActivity {

    Button addButton;
    Button listButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addButton  = findViewById(R.id.add);
        listButton = findViewById(R.id.view);

        addButton.setOnClickListener(this::addButtonOnClick);
        listButton.setOnClickListener(this::viewButtonOnClick);
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