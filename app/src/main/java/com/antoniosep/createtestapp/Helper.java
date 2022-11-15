package com.antoniosep.createtestapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Helper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;

    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + Contract.Entry.TABLE_NAME + " (" +
                    Contract.Entry._ID + " INTEGER PRIMARY KEY," +
                    Contract.Entry.COLUMN_NAME_TITLE + " TEXT UNIQUE," +
                    Contract.Entry.COLUMN_NAME_BODY + " TEXT" +
                    ")";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + Contract.Entry.TABLE_NAME;

    public Helper(Context context, String database_name) {
        super(context, database_name, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) { //Nueva versión de la base de datos
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
}
