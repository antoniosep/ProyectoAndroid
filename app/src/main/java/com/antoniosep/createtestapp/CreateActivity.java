package com.antoniosep.createtestapp;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class CreateActivity extends AppCompatActivity {
    SQLiteDatabase db;
    EditText title, body;
    Helper dbHelper;
    Button createButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_form);

        dbHelper = new Helper(getApplicationContext(), "Base de datos xuli");
        db = dbHelper.getWritableDatabase();

        title = findViewById(R.id.editTextTitleText);
        body = findViewById(R.id.editTextBodyText);
        createButton = findViewById(R.id.createButton);

        title.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideSoftKeyboard(v);
                }
            }
        });

        body.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideSoftKeyboard(v);
                }
            }
        });

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                create(view);
            }
        });
    }

    public void create(View view) {
        String title = this.title.getText().toString();
        String body = this.body.getText().toString();
        if (title.isEmpty()) {
            Toast.makeText(this, R.string.badTitleText, Toast.LENGTH_LONG).show();
        }else if (body.isEmpty()) {
            Toast.makeText(this, R.string.badBodyText, Toast.LENGTH_LONG).show();
        }else{
            ContentValues values = new ContentValues();
            values.put(Contract.Entry.COLUMN_NAME_TITLE, title);
            values.put(Contract.Entry.COLUMN_NAME_BODY, body);
            db.insert(Contract.Entry.TABLE_NAME, null, values);
            Toast.makeText(this, R.string.createConfirmed, Toast.LENGTH_LONG).show();
            finish();
        }

    }

    private void hideSoftKeyboard(View v) {
        InputMethodManager inputMethodManager;
        inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }

    @SuppressLint("Range")
    public void createNote() {

    }

}
