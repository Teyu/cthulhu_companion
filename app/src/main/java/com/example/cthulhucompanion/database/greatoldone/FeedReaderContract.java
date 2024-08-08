package com.example.cthulhucompanion.database.greatoldone;

import static com.example.cthulhucompanion.database.greatoldone.FeedReaderContract.GreatOldOneEntry.TABLE_GREAT_OLD_ONES;

import android.provider.BaseColumns;

public final class FeedReaderContract {

    private FeedReaderContract() {} // prevent someone from accidentally creating an instance

    public static class GreatOldOneEntry implements BaseColumns {
        public static final String TABLE_GREAT_OLD_ONES = "greatoldone";
        public static final String COLUMN_NAME = "name";
    }

    public static final String SQL_CREATE_GREAT_OLD_ENTRIES = "INSERT INTO " + TABLE_GREAT_OLD_ONES + " VALUES "
            + "('Cthulhu'), "
            + "('Hastur'), "
            + "('Schwarze Ziege der Wälder'), "
            + "('Yog-Sothoth')";
}
