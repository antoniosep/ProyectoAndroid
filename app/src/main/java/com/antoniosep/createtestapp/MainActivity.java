package com.antoniosep.createtestapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    Helper dbHelper;
    SQLiteDatabase db;
    Button searchButton, loadButton;
    FloatingActionButton createButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new Helper(getApplicationContext(), "Base de datos xuli");
        db = dbHelper.getWritableDatabase();

        searchButton = findViewById(R.id.searchButton);
        loadButton = findViewById(R.id.seeAllButton);
        createButton = findViewById(R.id.FloatingButton);
    }

    public void onClick(View view){
        int id = view.getId();
        Intent switchActivityIntent;
        switch (id){
            case R.id.searchButton:
                Toast.makeText(getApplicationContext(), "Search Button", Toast.LENGTH_SHORT).show();
                switchActivityIntent = new Intent(this,SearchForm.class);
                startActivity(switchActivityIntent);
                break;
            case R.id.seeAllButton:
                switchActivityIntent = new Intent(this, ViewAllActivity.class);
                startActivity(switchActivityIntent);
                break;
            case R.id.FloatingButton:
                switchActivityIntent = new Intent(this, CreateActivity.class);
                startActivity(switchActivityIntent);
                break;
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        db.close();
    }

}