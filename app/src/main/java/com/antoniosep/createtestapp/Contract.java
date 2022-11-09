package com.antoniosep.createtestapp;

import android.provider.BaseColumns;

public final class Contract {
    private Contract(){}

    public static abstract class Entry implements BaseColumns {
        public static final String TABLE_NAME = "Nombre_Tabla";
        public static final String COLUMN_NAME_KEY= "Clave";
        public static final String COLUMN_NAME_VAL= "Valor";
    }
}
