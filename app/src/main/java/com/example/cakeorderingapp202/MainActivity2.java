package com.example.cakeorderingapp202;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    EditText name,phone_number,address;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        name=findViewById(R.id.editTextTextPersonName);
        phone_number=findViewById(R.id.editTextTextPersonName2);
        address=findViewById(R.id.editTextTextPersonName3);
        button=findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cname = name.getText().toString();
                String cp= phone_number.getText().toString();
                String cad = address.getText().toString();
                Intent intent1 = new Intent(MainActivity2.this,MainActivity3.class);
                intent1.putExtra("name",cname);
                intent1.putExtra("phone",cp);
                intent1.putExtra("address",cad);
                startActivity(intent1);
            }
        });
    }
}