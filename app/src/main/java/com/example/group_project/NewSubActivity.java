package com.example.group_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

public class NewSubActivity extends AppCompatActivity {

    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newsub);

        submitButton = findViewById(R.id.add);
        submitButton.setOnClickListener(this::addSubscription);
    }

   public void addSubscription(View view){
        TextView SubName  = findViewById(R.id.SubName);
        TextView SubDate  = findViewById(R.id.SubDate);
        TextView SubPrice = findViewById(R.id.SubPrice);
        RadioGroup rg     = findViewById(R.id.radioGroup);

       int selectedId = rg.getCheckedRadioButtonId();
       String radioType = "";
       if(selectedId == R.id.radioWeekly){
           radioType = "Weekly";
       }else if (selectedId == R.id.radioMonthly){
           radioType = "Monthly";
       }else if (selectedId == R.id.radioYearly){
           radioType = "Yearly";
       }


       MyDBHandler dbHandler = new MyDBHandler(this);
        String name = SubName.getText().toString();
        String date = SubDate.getText().toString();
        String price = "$" + SubPrice.getText().toString();


        dbHandler.addHandler(name, date, price, radioType );
        SubName.setText("");
        SubDate.setText("");
        SubPrice.setText("");

    }
}
