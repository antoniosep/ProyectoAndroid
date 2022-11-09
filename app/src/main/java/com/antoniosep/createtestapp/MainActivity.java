package com.antoniosep.createtestapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button createButton, loadButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createButton = (Button) findViewById(R.id.createTestButton);
        loadButton = (Button) findViewById(R.id.loadTestButton);
    }

    public void onClick(View view){
        int id = view.getId();
        switch (id){
            case R.id.createTestButton:
                Toast.makeText(getApplicationContext(), "Create Button", Toast.LENGTH_SHORT).show();
                setContentView(R.layout.form_test);
                break;
            case R.id.loadTestButton:
                Toast.makeText(getApplicationContext(), "Load Button", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}