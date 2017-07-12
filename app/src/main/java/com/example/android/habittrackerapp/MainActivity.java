package com.example.android.habittrackerapp;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.android.habittrackerapp.data.HabitContract;
import com.example.android.habittrackerapp.data.HabitHelper;

public class MainActivity extends AppCompatActivity {

    // provides access to database
    private HabitHelper mDbHelper;

    // hardcoded variables
    int distance = 50;
    String destination = "work";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //instance of subclass of SQLiteOpenHelper
        mDbHelper = new HabitHelper(this);
    }

    // method for inserting trips to database
    private void insertTrip() {

        // puts the database in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        // Create a ContentValues object where column names are the keys,
        // and trip attributes from the hardcoded variables are the values.
        ContentValues values = new ContentValues();
        values.put(HabitContract.BikingEntry.COLUMN_DISTANCE, distance);
        values.put(HabitContract.BikingEntry.COLUMN_DESTINATION, destination);

        // Insert a new row for trip in the database
        db.insert(HabitContract.BikingEntry.TABLE_NAME, null, values);
    }

    // Reading from the table
    private Cursor readTable() {

        // Create and/or open a database to read from it
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // will be used
        String[] projection = {
                HabitContract.BikingEntry._ID,
                HabitContract.BikingEntry.COLUMN_DISTANCE,
                HabitContract.BikingEntry.COLUMN_DESTINATION};

        // Perform a query on the table
        Cursor cursor = db.query(
                HabitContract.BikingEntry.TABLE_NAME,   // The table to query
                projection,            // The columns to return
                null,                  // The columns for the WHERE clause
                null,                  // The values for the WHERE clause
                null,                  // Don't group the rows
                null,                  // Don't filter by row groups
                null);                   // The sort order

        // get ids of columns
        int idColumnIndex = cursor.getColumnIndex(HabitContract.BikingEntry._ID);
        int distanceColumnIndex = cursor.getColumnIndex(HabitContract.BikingEntry.COLUMN_DISTANCE);
        int destinationColumnIndex = cursor.getColumnIndex(HabitContract.BikingEntry.COLUMN_DESTINATION);

        // Iterate through all the returned rows in the cursor
        while (cursor.moveToNext()) {
            // Use that index to extract the String or Int value of the word
            // at the current row the cursor is on.
            int currentID = cursor.getInt(idColumnIndex);
            int currentDistance = cursor.getInt(distanceColumnIndex);
            String currentDestination = cursor.getString(destinationColumnIndex);

        }

        // close cursor to avoid mess!
        cursor.close();

        // return statement
        return cursor;
    }

}


