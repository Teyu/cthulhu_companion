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

    }

    public List<WrapperEpisodeEntry> access(){
        return mEntries;
    }

    private String getSelection(String columnName){ //Example
        // selectionArgsExample = = { "My Column" }
        return columnName+ " = ?";
    }
}
