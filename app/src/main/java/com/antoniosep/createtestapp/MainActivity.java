package com.antoniosep.createtestapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Helper dbHelper;
    SQLiteDatabase db;
    Button searchButton, loadButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new Helper(getApplicationContext(), "Base de datos xuli");
        db = dbHelper.getWritableDatabase();

        searchButton = (Button) findViewById(R.id.searchButton);
        loadButton = (Button) findViewById(R.id.seeAllButton);
    }

    public void onClick(View view){
        int id = view.getId();
        switch (id){
            case R.id.searchButton:
                Toast.makeText(getApplicationContext(), "Search Button", Toast.LENGTH_SHORT).show();
                setContentView(R.layout.search_form);
                break;
            case R.id.seeAllButton:
                Toast.makeText(getApplicationContext(), "Load Button", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        db.close();
    }
}