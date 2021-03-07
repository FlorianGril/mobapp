package com.example.bankapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button enter =null;
    String testname="unmotdepassecompliqué";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView result = findViewById(R.id.result);

        enter = (Button) findViewById(R.id.buttonEnter);


        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name = (EditText) findViewById(R.id.name);
                String nametext = name.getText().toString();
                if (nametext.equals(testname))
                {
                    Intent secondeActivite = new Intent(MainActivity.this, accounts.class);
                    startActivity(secondeActivite);
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "The name doesn't correspond", Toast.LENGTH_LONG).show();
                    result.setText(nametext);
                }

            }
        });
    }
}