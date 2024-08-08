package com.example.cthulhucompanion.database.greatoldone;

import static com.example.cthulhucompanion.database.greatoldone.FeedReaderContract.GreatOldOneEntry.COLUMN_NAME;
import static com.example.cthulhucompanion.database.greatoldone.FeedReaderContract.GreatOldOneEntry.TABLE_GREAT_OLD_ONES;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class DataBaseGreatOldOnes {

    private List<WrapperGreatOldOneEntry> mEntries = new ArrayList<>();

    @SuppressLint("Range")
    public List<WrapperGreatOldOneEntry> readData(SQLiteDatabase db) {

        String[] projection = { // specifies which columns from the database you will actually use after this query.
                COLUMN_NAME,
        };

        Cursor cursor = db.query(
                TABLE_GREAT_OLD_ONES,
                projection,
                null, //selection
                null, //selectionArgs
                null,null,null
        );

        while(cursor.moveToNext()) {
            String name = cursor.getString( cursor.getColumnIndex(
                    COLUMN_NAME)
            );

            mEntries.add(new WrapperGreatOldOneEntry(name));
        }
        cursor.close();

        return mEntries;
    }
}
