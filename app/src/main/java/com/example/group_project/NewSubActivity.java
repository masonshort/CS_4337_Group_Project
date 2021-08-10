package com.example.group_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class NewSubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newsub);
    }

    public void listButtonOnClick(View v) {
        Intent i = new Intent(getApplicationContext(), ListActivity.class);
        startActivity(i);
    }

    public void backButtonOnClick(View v) {
        Intent i = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(i);
    }
   public void addSubscription(View view){
        TextView SubName = (TextView) findViewById(R.id.SubName);
        TextView SubDate = (TextView) findViewById(R.id.SubDate);
        TextView SubPrice = (TextView) findViewById(R.id.SubPrice);

        MyDBHandler dbHandler = new MyDBHandler(this);
        String name = SubName.getText().toString();
        String date = SubDate.getText().toString();
        String price = SubPrice.getText().toString();
        String type = "weekly";

        //Subscription subscription = new Subscription(name, date, price);
        dbHandler.addHandler(name, date, price, type );
        SubName.setText("");
        SubDate.setText("");
        SubPrice.setText("");

    }
}
