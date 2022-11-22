package com.example.cakeorderingapp202;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    EditText name, phone_number, address;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        name = findViewById(R.id.et_name);
        phone_number = findViewById(R.id.et_mobile);
        address = findViewById(R.id.et_address);
        button = findViewById(R.id.btn_proceed);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cname = name.getText().toString();
                String cp = phone_number.getText().toString();
                String cad = address.getText().toString();
                if (cname.trim().isEmpty() || cp.trim().isEmpty() || cad.trim().isEmpty()) {
                    Toast.makeText(MainActivity2.this, "One of filed is empty", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent intent1 = new Intent(MainActivity2.this, MainActivity4.class);
                intent1.putExtra("name", cname);
                intent1.putExtra("phone", cp);
                intent1.putExtra("address", cad);
                intent1.putExtra("date", getIntent().getStringExtra("date"));
                intent1.putExtra("result", getIntent().getStringExtra("result"));
                startActivity(intent1);
            }
        });
    }
}