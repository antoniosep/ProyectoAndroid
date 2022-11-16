package com.antoniosep.createtestapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class SearchForm extends AppCompatActivity
{

    Button searchButton2;
    EditText editTextTitleText;
    private TextView tituloNota;
    private TextView descNota;

    private Helper dbHelper;
    private SQLiteDatabase db;

    @SuppressLint("Range")
    public void search()
    {
        String titulo = editTextTitleText.getText().toString();

        if(titulo.isEmpty())
        {
            Toast.makeText(getApplicationContext(), getString(R.string.invalidTitleSearchToast), Toast.LENGTH_SHORT).show();
            hideSoftKeyboard(editTextTitleText);
        }
        else
        {
            String[] columns = {
                    Contract.Entry._ID,
                    Contract.Entry.COLUMN_NAME_TITLE,
                    Contract.Entry.COLUMN_NAME_BODY
            };

            String where = Contract.Entry.COLUMN_NAME_TITLE + " = ?";
            String[] whereArgs = { titulo };
            Cursor cursor = db.query(Contract.Entry.TABLE_NAME, columns, where, whereArgs, null, null, null);
            String meaning = "";
            try {
                while (cursor.moveToNext()) {
                    meaning = cursor.getString(cursor.getColumnIndex(Contract.Entry.COLUMN_NAME_BODY));
                }
            } finally {
                cursor.close();
            }

            tituloNota.setText(titulo);
            if (meaning.isEmpty()) {
                Toast.makeText(getApplicationContext(), getString(R.string.noNoteFound), Toast.LENGTH_SHORT).show();
                descNota.setText(R.string.notaNoEncontrada);
            } else {
                descNota.setText(meaning);
            }
            editTextTitleText.setText("");

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

        editTextTitleText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideSoftKeyboard(v);
                }
            }
        });

        dbHelper = new Helper(getApplicationContext(), "bdNotas");
        db = dbHelper.getWritableDatabase();
        
        tituloNota = (TextView) findViewById(R.id.tituloNota);
        descNota = (TextView) findViewById(R.id.descNota);
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.searchButton2: search(); break;
        }
    }


}