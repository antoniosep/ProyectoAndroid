package com.antoniosep.createtestapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ViewItemActivity extends AppCompatActivity {

    TextView titulo, cuerpo;
    Button button;

    Helper dbHelper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_item);

        dbHelper = new Helper(getApplicationContext(), "DB");
        db = dbHelper.getWritableDatabase();

        titulo = findViewById(R.id.viewTitleText);
        cuerpo = findViewById(R.id.viewBodyText);
        button = findViewById(R.id.button);

        button.setOnClickListener(view -> {
            borrarMensaje();
            finish();
        });

        cuerpo.setMovementMethod(new ScrollingMovementMethod());

        Bundle extras = getIntent().getExtras();

        titulo.setText((String) extras.get("titulo"));
        cuerpo.setText((String) extras.get("cuerpo"));
    }

    protected void borrarMensaje() {
        String where = Contract.Entry.COLUMN_NAME_TITLE + " = ?";
        String[] whereArgs = {(String) titulo.getText()};

        db.delete(Contract.Entry.TABLE_NAME, where, whereArgs);
        Toast.makeText(getApplicationContext(), getString(R.string.deletedMessage), Toast.LENGTH_SHORT).show();
    }
}