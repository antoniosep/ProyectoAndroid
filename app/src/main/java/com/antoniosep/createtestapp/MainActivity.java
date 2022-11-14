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
        switch (id){
            case R.id.searchButton:
                Toast.makeText(getApplicationContext(), "Search Button", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this,SearchForm.class);
                startActivity(intent);
                break;
            case R.id.seeAllButton:
                Toast.makeText(getApplicationContext(), "Load Button", Toast.LENGTH_SHORT).show();
                break;
            case R.id.FloatingButton:
                Intent switchActivityIntent = new Intent(this, CreateActivity.class);
                startActivity(switchActivityIntent);
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        db.close();
    }

}