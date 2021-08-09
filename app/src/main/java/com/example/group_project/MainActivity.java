package com.example.group_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

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

    /*public void addButtonOnClick(View v) {
        Intent i = new Intent(getApplicationContext(), AddSubActivity.class);
        startActivity(i);
    }*/

    public void backButtonOnClick(View v) {
        Intent i = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(i);
    }

    public void addSubscription(View view){
        TextView SubName = (TextView) findViewById(R.id.SubName);
        TextView SubDate = (TextView) findViewById(R.id.SubDate);
        TextView SubPrice = (TextView) findViewById(R.id.SubPrice);

        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
        String name = SubName.getText().toString();
        String date = SubDate.getText().toString();
        String price = SubPrice.getText().toString();

        Subscription subscription = new Subscription(name, date, price);
        dbHandler.addHandler(subscription);
        SubName.setText("");
        SubDate.setText("");
        SubPrice.setText("");

    }

}

