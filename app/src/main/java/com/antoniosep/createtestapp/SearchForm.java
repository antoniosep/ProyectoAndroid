package com.antoniosep.createtestapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SearchForm extends AppCompatActivity
{

    Button searchButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_form);

        searchButton2 = (Button) findViewById(R.id.searchButton2);
    }

    public void onClick(View view)
    {
        Toast.makeText(getApplicationContext(), "pito", Toast.LENGTH_SHORT).show();
    }
}