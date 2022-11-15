package com.antoniosep.createtestapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ViewAllActivity extends AppCompatActivity {
    SQLiteDatabase db;
    Helper dbHelper;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);

        dbHelper = new Helper(getApplicationContext(), "Base de datos xuli");
        db = dbHelper.getWritableDatabase();

        listView = findViewById(R.id.ListView);
        listAll();
    }

    @SuppressLint("Range")
    public void listAll() {
        String[] columns = {
                Contract.Entry._ID,
                Contract.Entry.COLUMN_NAME_TITLE,
                Contract.Entry.COLUMN_NAME_BODY
        };

        Cursor cursor = db.query(Contract.Entry.TABLE_NAME, columns, null, null, null, null, null);
        List<String> titulosList = new ArrayList<>();
        try {
            while (cursor.moveToNext()) {
                titulosList.add(cursor.getString(cursor.getColumnIndex(Contract.Entry.COLUMN_NAME_TITLE)));
            }
        } finally {
            cursor.close();
        }

        ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, titulosList);
        listView.setAdapter(adapter);
    }
}