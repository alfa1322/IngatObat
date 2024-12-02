package com.example.medicationreminder.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.example.medicationreminder.models.Medication;
import com.example.medicationreminder.models.User;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper {

    private static final String DATABASE_NAME = "medication_reminder.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_USER = "users";
    private static final String TABLE_MEDICATION = "medications";

    private SQLiteDatabase db;
    private final Context context;
    private final UserDatabaseHelper dbHelper;

    public DatabaseHelper(Context context) {
        this.context = context;
        dbHelper = new UserDatabaseHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Open the database
    public void open() throws SQLException {
        db = dbHelper.getWritableDatabase();
    }

    // Close the database
    public void close() {
        if (db != null) {
            db.close();
        }
    }

    // Register new user
    public boolean registerUser(String username, String password) {
        ContentValues values = new ContentValues();
        values.put("username", username);
        values.put("password", password);

        long result = db.insert(TABLE_USER, null, values);
        return result != -1;
    }

    // Validate user login
    public boolean validateUser(String username, String password) {
        Cursor cursor = db.query(TABLE_USER, null, "username = ? AND password = ?",
                new String[]{username, password}, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            cursor.close();
            return true;
        }
        return false;
    }

    // Add new medication
    public boolean addMedication(String medicationName, String dose, String time) {
        ContentValues values = new ContentValues();
        values.put("medication_name", medicationName);
        values.put("dose", dose);
        values.put("time", time);

        long result = db.insert(TABLE_MEDICATION, null, values);
        return result != -1;
    }

    // Get all medications
    public List<Medication> getAllMedications() {
        List<Medication> medicationList = new ArrayList<>();
        Cursor cursor = db.query(TABLE_MEDICATION, null, null, null, null, null, null);

        if (cursor != null) {
            while (cursor.moveToNext()) {
                Medication medication = new Medication(
                        cursor.getString(cursor.getColumnIndex("medication_name")),
                        cursor.getString(cursor.getColumnIndex("dose")),
                        cursor.getString(cursor.getColumnIndex("time"))
                );
                medicationList.add(medication);
            }
            cursor.close();
        }
        return medicationList;
    }
}
