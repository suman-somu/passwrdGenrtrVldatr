package com.example.passwordgeneratorandvalidator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn1 = findViewById(R.id.button1);
        Button btn2 = findViewById(R.id.button2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passGenerator();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passValidator();
            }
        });
    }

    private void passValidator() {
        Intent intent = new Intent(this,passValidator.class);
        startActivity(intent);
    }

    private void passGenerator() {
        Intent intent = new Intent(this, passGenerator.class);
        startActivity(intent);
    }
}