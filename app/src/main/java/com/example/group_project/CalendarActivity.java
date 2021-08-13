package com.example.group_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class CalendarActivity extends AppCompatActivity {

    Button listSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        listSwitch = findViewById(R.id.backToListButton);
        listSwitch.setOnClickListener(this::listSwitchClick);

    }
    public void listSwitchClick(View v){
        Intent i = new Intent(getApplicationContext(),ListActivity.class);
        startActivity(i);
    }

}
