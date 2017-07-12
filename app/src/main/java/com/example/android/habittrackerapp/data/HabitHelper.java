package com.example.android.habittrackerapp.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class HabitHelper extends SQLiteOpenHelper {

    // Name of the database file
    private static final String DATABASE_NAME = "habit.db";

    // Database version
    private static final int DATABASE_VERSION = 1;

    // Constructs a new instance of HabitHelper
    public HabitHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //This is called when the database is created for the first time.

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the biking table
        String SQL_CREATE_HABIT_TABLE = "CREATE TABLE " + HabitContract.BikingEntry.TABLE_NAME + " ("
                + HabitContract.BikingEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + HabitContract.BikingEntry.COLUMN_DISTANCE + " INTEGER NOT NULL, "
                + HabitContract.BikingEntry.COLUMN_DESTINATION + " TEXT NOT NULL);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_HABIT_TABLE);
    }

    //This is called when the database needs to be upgraded.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // nothing needed here for now
    }
}
