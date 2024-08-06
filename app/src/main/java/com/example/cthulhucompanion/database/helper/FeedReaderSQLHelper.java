package com.example.cthulhucompanion.database.helper;

import static com.example.cthulhucompanion.database.feedreadercontract.FeedReaderContract.FeedEntry.COLUMN_NAME_SUBTITLE;
import static com.example.cthulhucompanion.database.feedreadercontract.FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE;
import static com.example.cthulhucompanion.database.feedreadercontract.FeedReaderContract.FeedEntry.TABLE_NAME;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class FeedReaderSQLHelper extends SQLiteOpenHelper {

    //TODO: create wrapper class that hides database
    // static access via composition root

    // https://developer.android.com/codelabs/basic-android-kotlin-compose-sql#0

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "CthulhuCompanion.db";
    private static final String SQL_CREATE_ENTRIES = "INSERT INTO " + TABLE_NAME + " VALUES ('My Title', NULL)";
    //private static final String SQL_DELETE_ENTRIES = "some sql command";

    public FeedReaderSQLHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " ( " + COLUMN_NAME_TITLE + " String, " + COLUMN_NAME_SUBTITLE + " datatype )");
        db.execSQL(SQL_CREATE_ENTRIES);
    }
    /*  "MyTitle"   Filter results WHERE COLUMN_NAME_TITLE = 'My Title'*/

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // discard data and start over
        /*db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);*/
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    //might want to use this:
    public void onOpen() {}

}
