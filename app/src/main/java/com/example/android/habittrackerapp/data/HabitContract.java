package com.example.android.habittrackerapp.data;

import android.provider.BaseColumns;

public class HabitContract {

    // inner class for biking table (each record is a single bike trip)
    public static final class BikingEntry implements BaseColumns {

        // table name
        public static final String TABLE_NAME = "biking";

        // id for each trip
        public static final String _ID = BaseColumns._ID;

        // distance of each trip
        public static final String COLUMN_DISTANCE = "distance";

        // destination of each trip
        public static final String COLUMN_DESTINATION = "destination";

    }
}

