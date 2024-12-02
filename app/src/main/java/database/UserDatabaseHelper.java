package com.example.medicationreminder.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UserDatabaseHelper extends SQLiteOpenHelper {

    private static final String CREATE_TABLE_USER =
            "CREATE TABLE users (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "username TEXT UNIQUE NOT NULL, password TEXT NOT NULL);";

    private static final String CREATE_TABLE_MEDICATION =
            "CREATE TABLE medications (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "medication_name TEXT NOT NULL, dose TEXT NOT NULL, time TEXT NOT NULL);";

    public UserDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USER);  // Create users table
        db.execSQL(CREATE_TABLE_MEDICATION);  // Create medications table
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + "users");
        db.execSQL("DROP TABLE IF EXISTS " + "medications");
        onCreate(db);
    }
}
