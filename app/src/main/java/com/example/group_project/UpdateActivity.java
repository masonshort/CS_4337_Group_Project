package com.example.group_project;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class UpdateActivity extends AppCompatActivity {

    EditText editName, editDate, editPrice;
    Button updateButton, deleteButton;
    RadioGroup rg;
    String  id, name, date, price, type;



    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        editName = findViewById(R.id.UpdateSubName);
        editDate = findViewById(R.id.UpdateSubDate);
        editPrice = findViewById(R.id.UpdateSubPrice);

        getData();
        updateButton = findViewById(R.id.add);
        updateButton.setOnClickListener(view -> {
            rg = findViewById(R.id.radioGroupUpdate);
            int selectedId = rg.getCheckedRadioButtonId();
            String radioType = "";
            if(selectedId == R.id.radioWeeklyUpdate){
                radioType = "Weekly";
            }else if (selectedId == R.id.radioMonthlyUpdate){
                radioType = "Monthly";
            }else if (selectedId == R.id.radioYearlyUpdate){
                radioType = "Yearly";
            }
                MyDBHandler db = new MyDBHandler(UpdateActivity.this);
                name  = editName.getText().toString().trim();
                date  = editDate.getText().toString().trim();
                price = editPrice.getText().toString().trim();
                type = radioType;
                db.updateHandler(id, name, date, price, type);
                db.close();
                Intent i = new Intent(getApplicationContext(), ListActivity.class);
                startActivity(i);
            }
        );

        deleteButton = findViewById(R.id.DeleteButton);
        deleteButton.setOnClickListener(view -> confirmDelete());
    }

    void getData(){
        if(getIntent().hasExtra("id") && getIntent().hasExtra("name") && getIntent().hasExtra("date")
            && getIntent().hasExtra("price") && getIntent().hasExtra("type")){
            id = getIntent().getStringExtra("id");
            name = getIntent().getStringExtra("name");
            date = getIntent().getStringExtra("date");
            price = getIntent().getStringExtra("price");
            type = getIntent().getStringExtra("type");
            RadioGroup rg = findViewById(R.id.radioGroupUpdate);



            editName.setText(name);
            editDate.setText(date);
            editPrice.setText(price);

            switch (type) {
                case "Weekly":
                    rg.check(R.id.radioWeeklyUpdate);
                    break;
                case "Monthly":
                    rg.check(R.id.radioMonthlyUpdate);
                    break;
                case "Yearly":
                    rg.check(R.id.radioYearlyUpdate);
                    break;
            }



        }else {
            Toast.makeText(this, "Did not receive data", Toast.LENGTH_SHORT).show();
        }
    }

    void confirmDelete(){
        AlertDialog.Builder alert = new AlertDialog.Builder(UpdateActivity.this);
        alert.setTitle("Delete " + name + "?");
        alert.setMessage("Are you sure you want to delete the subscription " + name + "?");
        alert.setPositiveButton("Yes", (dialog, which) -> {
            MyDBHandler db = new MyDBHandler(UpdateActivity.this);
            db.deleteHandler(id);
            db.close();
            Intent i = new Intent(getApplicationContext(), ListActivity.class);
            startActivity(i);
        });
        alert.setNegativeButton("Cancel", (dialog, which) -> {

        });
        alert.create().show();
    }

}
