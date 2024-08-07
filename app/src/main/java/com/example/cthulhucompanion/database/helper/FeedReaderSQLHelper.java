package com.example.cthulhucompanion.database.helper;

import static com.example.cthulhucompanion.database.episodes.FeedReaderContract.EpisodesFeedEntry.COLUMN_NAME_SUBTITLE;
import static com.example.cthulhucompanion.database.episodes.FeedReaderContract.EpisodesFeedEntry.COLUMN_NAME_TITLE;
import static com.example.cthulhucompanion.database.episodes.FeedReaderContract.EpisodesFeedEntry.TABLE_NAME;
import static com.example.cthulhucompanion.database.episodes.FeedReaderContract.SQL_CREATE_ENTRIES;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class FeedReaderSQLHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "CthulhuCompanion.db";

    public FeedReaderSQLHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " ( " + COLUMN_NAME_TITLE + " String, " + COLUMN_NAME_SUBTITLE + " Integer )");
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // discard data and start over
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

}
