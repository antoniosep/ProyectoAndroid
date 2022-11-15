package com.antoniosep.createtestapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ViewAllActivity extends AppCompatActivity {
    SQLiteDatabase db;
    Helper dbHelper;
    ListView listView;
    List<String> titulosList, cuerposList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);

        dbHelper = new Helper(getApplicationContext(), "bdNotas");
        db = dbHelper.getWritableDatabase();

        listView = findViewById(R.id.ListView);
        listView.setClickable(true);
        listAll();

        listView.setOnItemClickListener((adapterView, view, i, l) -> switchActivity(i));
    }

    protected void switchActivity(int pos) {
        String titulo = titulosList.get(pos);
        String cuerpo = cuerposList.get(pos);

        Intent viewActivity = new Intent(this,ViewItemActivity.class);
        viewActivity.putExtra("titulo", titulo);
        viewActivity.putExtra("cuerpo", cuerpo);
        startActivity(viewActivity);
    }

    @Override
    protected void onResume() {
        super.onResume();
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
        titulosList = new ArrayList<>();
        cuerposList = new ArrayList<>();
        try {
            while (cursor.moveToNext()) {
                titulosList.add(cursor.getString(cursor.getColumnIndex(Contract.Entry.COLUMN_NAME_TITLE)));
                cuerposList.add(cursor.getString(cursor.getColumnIndex(Contract.Entry.COLUMN_NAME_BODY)));
            }
        } finally {
            cursor.close();
        }

        if(titulosList.isEmpty()){
            Toast.makeText(getApplicationContext(), getString(R.string.noMessagesSaved), Toast.LENGTH_SHORT).show();
            finish();
        }
        ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, titulosList);
        listView.setAdapter(adapter);
    }
}