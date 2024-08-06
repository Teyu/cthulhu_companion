package com.example.cthulhucompanion.database.feedreadercontract;

import android.provider.BaseColumns;

public final class FeedReaderContract {

    // prevent someone from accidentally creating an instance
    private FeedReaderContract() {}

    public static class FeedEntry implements BaseColumns {
        public static final String TABLE_NAME = "entry";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_SUBTITLE = "subtitle";
    }

}
