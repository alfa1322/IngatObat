package com.example.medicationreminder.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "medication_reminder.db";
    private static final int DATABASE_VERSION = 1;

    // Table name
    public static final String TABLE_MEDICATION = "medication";
    public static final String TABLE_USER = "user";

    // Common columns
    public static final String KEY_ID = "id";

    // Medication table columns
    public static final String KEY_MEDICATION_NAME = "medication_name";
    public static final String KEY_DOSE = "dose";
    public static final String KEY_TIME = "time";

    // User table columns
    public static final String KEY_USERNAME = "username";
    public static final String KEY_PASSWORD = "password";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_USER = "CREATE TABLE " + TABLE_USER + " (" +
                KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                KEY_USERNAME + " TEXT, " +
                KEY_PASSWORD + " TEXT)";
        db.execSQL(CREATE_TABLE_USER);

        String CREATE_TABLE_MEDICATION = "CREATE TABLE " + TABLE_MEDICATION + " (" +
                KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                KEY_MEDICATION_NAME + " TEXT, " +
                KEY_DOSE + " TEXT, " +
                KEY_TIME + " TEXT)";
        db.execSQL(CREATE_TABLE_MEDICATION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MEDICATION);
        onCreate(db);
    }
}
