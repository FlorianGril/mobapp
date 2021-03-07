package com.example.bankapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class accounts extends AppCompatActivity {
    String test= WebService.getAccounts();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accounts);
        TextView result = findViewById(R.id.result);
        Toast.makeText(getApplicationContext(), "your accounts", Toast.LENGTH_LONG).show();
        //result.setText(test);
    }
}