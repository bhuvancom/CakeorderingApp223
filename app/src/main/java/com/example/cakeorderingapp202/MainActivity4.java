package com.example.cakeorderingapp202;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity {
    TextView invoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        invoice = findViewById(R.id.textView2);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String phone_number = intent.getStringExtra("phone");
        String address = intent.getStringExtra("address");
        String result1 = intent.getStringExtra("result");
        String date = intent.getStringExtra("date");
        invoice.setText(new StringBuilder().append("Customer Name : ").append(name).append("\n").append("Phone Number : ").append(phone_number).append("\n").append("Address : ").append(address).append("\n").append(result1).append("\n").append("Delivery Date : ").append(date).append("\n").toString());

    }
}