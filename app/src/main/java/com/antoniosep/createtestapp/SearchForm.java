package com.antoniosep.createtestapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class SearchForm extends AppCompatActivity
{

    Button searchButton2;
    EditText editTextTitleText;

    @SuppressLint("Range")
    public void search()
    {
        String titulo = editTextTitleText.getText().toString().trim().toLowerCase();

        if(titulo.isEmpty())
        {
            Toast.makeText(getApplicationContext(), "Introduzca un título para buscar", Toast.LENGTH_SHORT).show();
            hideSoftKeyboard(editTextTitleText);
        }
        else
        {
            hideSoftKeyboard(editTextTitleText);
        }
    }

    private void hideSoftKeyboard(View v) {
        InputMethodManager inputMethodManager;
        inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_form);

        searchButton2 = (Button) findViewById(R.id.searchButton2);
        editTextTitleText = (EditText) findViewById(R.id.editTextTitleText);
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.searchButton2: search(); break;
        }
    }


}