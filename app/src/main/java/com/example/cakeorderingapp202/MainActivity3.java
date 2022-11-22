package com.example.cakeorderingapp202;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity3 extends AppCompatActivity {
    CheckBox chocolate, blackforest, redvelvet, strawberry;
    Button button;
    EditText deliverydate;
    ImageView imageView;
    private int mDate, mMonth, mYear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        chocolate = findViewById(R.id.cb1);
        blackforest = findViewById(R.id.cb2);
        redvelvet = findViewById(R.id.cb3);
        strawberry = findViewById(R.id.cb4);
        button = findViewById(R.id.button1);
        deliverydate = findViewById(R.id.date);
        imageView = findViewById(R.id.iv1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int total = 0;
                StringBuilder result = new StringBuilder();
                result.append("Cake flavours Selected are\n");
                if (chocolate.isChecked()) {
                    result.append("Chocolate Rs 600 \n");
                    total += 600;
                }
                if (blackforest.isChecked()) {
                    result.append("Almond Delight Rs 800 \n");
                    total += 800;
                }
                if (redvelvet.isChecked()) {
                    result.append(" Red Velvet Rs 850\n");
                    total += 850;
                }
                if (strawberry.isChecked()) {
                    result.append(" Fresh Fruit Rs 700\n");
                    total += 700;
                }
                if (total == 0) {
                    Toast.makeText(MainActivity3.this, "Select at least one cake", Toast.LENGTH_SHORT).show();
                    return;
                }

                result.append("Total Amount: Rs ").append(total);
                String result1 = String.valueOf(result);
                selectDate(result1);
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar cal = Calendar.getInstance();
                mDate = cal.get(Calendar.DATE);
                mMonth = cal.get(Calendar.MONTH);
                mYear = cal.get(Calendar.YEAR);

                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity3.this, android.R.style.Theme_DeviceDefault_Dialog, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int date) {
                        deliverydate.setText(date + "-" + month + "-" + year);
                    }
                }, mYear, mMonth, mDate);
                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
                datePickerDialog.show();
            }
        });
    }

    private void selectDate(String result1) {
        final Calendar cal = Calendar.getInstance();
        mDate = cal.get(Calendar.DATE);
        mMonth = cal.get(Calendar.MONTH);
        mYear = cal.get(Calendar.YEAR);

        DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity3.this, android.R.style.Theme_DeviceDefault_Dialog, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dateO) {
                deliverydate.setText(dateO + "-" + month + "-" + year);
                String date = deliverydate.getText().toString();
                if (date.trim().isEmpty()) {
                    Toast.makeText(MainActivity3.this, "Select at the delivery date", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent intent = new Intent(MainActivity3.this, MainActivity2.class);
                intent.putExtra("date", date);
                intent.putExtra("result", result1);
                startActivity(intent);
            }
        }, mYear, mMonth, mDate);
        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
        datePickerDialog.show();
    }
}