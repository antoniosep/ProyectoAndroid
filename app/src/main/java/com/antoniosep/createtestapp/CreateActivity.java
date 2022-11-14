package com.antoniosep.createtestapp;

import android.annotation.SuppressLint;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


public class CreateActivity extends AppCompatActivity {
    SQLiteDatabase db;
    EditText titulo, cuerpo;
    Helper dbHelper;
    Button createButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_form);

        dbHelper = new Helper(getApplicationContext(), "Base de datos xuli");
        db = dbHelper.getWritableDatabase();

        titulo = findViewById(R.id.editTextTitleText);
        cuerpo = findViewById(R.id.editTextBodyText);
        //createButton = findViewById(R.id)
    }

    public void onClick(View view){
        int id = view.getId();
        if(id == createButton.getId()){

        }

    }

    private void hideSoftKeyboard(View v) {
        InputMethodManager inputMethodManager;
        inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }

    @SuppressLint("Range")
    public void createNote(){

    }

}
