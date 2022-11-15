package com.antoniosep.createtestapp;

import android.provider.BaseColumns;

public final class Contract {
    private Contract(){}

    public static abstract class Entry implements BaseColumns {
        public static final String TABLE_NAME = "NOTAS";
        public static final String COLUMN_NAME_TITLE= "TITULO";
        public static final String COLUMN_NAME_BODY= "CUERPO";
    }
}
