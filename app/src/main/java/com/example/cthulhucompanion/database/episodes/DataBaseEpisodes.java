package com.example.cthulhucompanion.database.episodes;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.cthulhucompanion.database.helper.FeedReaderSQLHelper;

import java.util.ArrayList;
import java.util.List;

public class DataBaseEpisodes {

    private final ArrayList<WrapperEpisodeEntry> mEntries = new ArrayList<>();

    @SuppressLint("Range")
    public void readData(Context context) {

        FeedReaderSQLHelper helper = new FeedReaderSQLHelper(context);
        SQLiteDatabase db = helper.getReadableDatabase();

        String[] projection = { // specifies which columns from the database you will actually use after this query.
                FeedReaderContract.EpisodesFeedEntry.COLUMN_NAME_TITLE,
                FeedReaderContract.EpisodesFeedEntry.COLUMN_NAME_SUBTITLE
        };

        Cursor cursor = db.query(
                FeedReaderContract.EpisodesFeedEntry.TABLE_NAME,
                projection,
                null, //selection
                null, //selectionArgs
                null,null,null
        );

        List<Long> itemIds = new ArrayList<>();
        while(cursor.moveToNext()) {
            long itemId = cursor.getLong(
                    cursor.getColumnIndexOrThrow(FeedReaderContract.EpisodesFeedEntry.COLUMN_NAME_SUBTITLE));
            itemIds.add(itemId);

            String title = cursor.getString( cursor.getColumnIndex(
                    FeedReaderContract.EpisodesFeedEntry.COLUMN_NAME_TITLE)
            );

            int count = cursor.getInt( cursor.getColumnIndex(
                    FeedReaderContract.EpisodesFeedEntry.COLUMN_NAME_SUBTITLE)
            );

            mEntries.add(new WrapperEpisodeEntry(title, count));
        }
        cursor.close();

    }

    public List<WrapperEpisodeEntry> access(){
        return mEntries;
    }

    private String getSelection(String columnName){ //Example
        // selectionArgsExample = = { "My Column" }
        return columnName+ " = ?";
    }
}
