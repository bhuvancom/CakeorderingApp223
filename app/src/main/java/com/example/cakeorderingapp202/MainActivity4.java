package com.example.cakeorderingapp202;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity {
    TextView invoice;
    TextView contactDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        invoice = findViewById(R.id.tv_package);
        contactDetails = findViewById(R.id.tv_contact_details);
        findViewById(R.id.btn_home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity4.this, MainActivity2.class));
                finishAffinity();
            }
        });

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String phone_number = intent.getStringExtra("phone");
        String address = intent.getStringExtra("address");
        String result1 = intent.getStringExtra("result");
        String date = intent.getStringExtra("date");
        contactDetails.setText(getString(R.string.contact_details, name, phone_number, address, date));
        invoice.setText(getString(R.string.delivery_content, result1));
    }
}