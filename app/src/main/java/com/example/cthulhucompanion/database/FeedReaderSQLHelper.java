package com.example.cthulhucompanion.database;

import static com.example.cthulhucompanion.database.characters.FeedReaderContract.CharactersFeedEntry.COLUMN_CHARACTER_ID;
import static com.example.cthulhucompanion.database.characters.FeedReaderContract.CharactersFeedEntry.COLUMN_IMAGE_RESOURCE;
import static com.example.cthulhucompanion.database.characters.FeedReaderContract.CharactersFeedEntry.TABLE_CHARACTERS;
import static com.example.cthulhucompanion.database.characters.FeedReaderContract.SQL_CREATE_CHARACTERS_ENTRIES;
import static com.example.cthulhucompanion.database.episodes.FeedReaderContract.EpisodesFeedEntry.COLUMN_COUNT;
import static com.example.cthulhucompanion.database.episodes.FeedReaderContract.EpisodesFeedEntry.COLUMN_TITLE;
import static com.example.cthulhucompanion.database.episodes.FeedReaderContract.EpisodesFeedEntry.TABLE_EPISODES;
import static com.example.cthulhucompanion.database.episodes.FeedReaderContract.SQL_CREATE_EPISODE_ENTRIES;
import static com.example.cthulhucompanion.database.greatoldone.FeedReaderContract.GreatOldOneEntry.COLUMN_NAME;
import static com.example.cthulhucompanion.database.greatoldone.FeedReaderContract.GreatOldOneEntry.TABLE_GREAT_OLD_ONES;
import static com.example.cthulhucompanion.database.greatoldone.FeedReaderContract.SQL_CREATE_GREAT_OLD_ENTRIES;

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
        db.execSQL("CREATE TABLE " + TABLE_EPISODES + " ( " + COLUMN_TITLE + " String, " + COLUMN_COUNT + " Integer )");
        db.execSQL(SQL_CREATE_EPISODE_ENTRIES);

        db.execSQL("CREATE TABLE " + TABLE_GREAT_OLD_ONES + " ( " + COLUMN_NAME + " String )");
        db.execSQL(SQL_CREATE_GREAT_OLD_ENTRIES);

        db.execSQL("CREATE TABLE " + TABLE_CHARACTERS + " ( " + COLUMN_IMAGE_RESOURCE + " Integer, " + COLUMN_CHARACTER_ID + " String )");
        db.execSQL(SQL_CREATE_CHARACTERS_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // discard data and start over
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

}
