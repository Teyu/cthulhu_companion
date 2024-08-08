package com.example.cthulhucompanion.database.episodes;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DataBaseEpisodes {

    private final ArrayList<WrapperEpisodeEntry> mEntries = new ArrayList<>();

    @SuppressLint("Range")
    public ArrayList<WrapperEpisodeEntry> readData(SQLiteDatabase db) {

        String[] projection = { // specifies which columns from the database you will actually use after this query.
                FeedReaderContract.EpisodesFeedEntry.COLUMN_TITLE,
                FeedReaderContract.EpisodesFeedEntry.COLUMN_COUNT
        };

        Cursor cursor = db.query(
                FeedReaderContract.EpisodesFeedEntry.TABLE_EPISODES,
                projection,
                null, //selection
                null, //selectionArgs
                null,null,null
        );

        while(cursor.moveToNext()) {

            String title = cursor.getString( cursor.getColumnIndex(
                    FeedReaderContract.EpisodesFeedEntry.COLUMN_TITLE)
            );

            int count = cursor.getInt( cursor.getColumnIndex(
                    FeedReaderContract.EpisodesFeedEntry.COLUMN_COUNT)
            );

            mEntries.add(new WrapperEpisodeEntry(title, count));
        }
        cursor.close();

        return mEntries;
    }
}
