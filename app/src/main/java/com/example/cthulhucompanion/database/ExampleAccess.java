package com.example.cthulhucompanion.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import com.example.cthulhucompanion.database.feedreadercontract.FeedReaderContract;
import com.example.cthulhucompanion.database.helper.FeedReaderSQLHelper;

import java.util.ArrayList;
import java.util.List;

public class ExampleAccess {

    public List<Long> readData(Context context) {

        FeedReaderSQLHelper helper = new FeedReaderSQLHelper(context);
        SQLiteDatabase db = helper.getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                //BaseColumns._ID,
                FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE,
                FeedReaderContract.FeedEntry.COLUMN_NAME_SUBTITLE
        };

        // Filter results WHERE "title" = 'My Title'
        String selection = FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE + " = ?";
        String[] selectionArgs = { "My Title" };

        // How you want the results sorted in the resulting Cursor
        /*String sortOrder =
                FeedReaderContract.FeedEntry.COLUMN_NAME_SUBTITLE + " DESC";*/

        //starts at position -1
        Cursor cursor = db.query(
                FeedReaderContract.FeedEntry.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                selection,              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                /*sortOrder*/null               // The sort order
        );

        List itemIds = new ArrayList<>();
        while(cursor.moveToNext()) { // moveToNext starts returning first element
            long itemId = cursor.getLong(
                    //TODO: here the ID is COLUMN_NAME_TITLE -> getString
                    cursor.getColumnIndexOrThrow(/*FeedReaderContract.FeedEntry._ID*/FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE)); //retrieve IDs
            itemIds.add(itemId);
        }
        cursor.close();

        return itemIds;
    }

    /*Since getWritableDatabase() and getReadableDatabase() are expensive to call when the database is closed,
    you should leave your database connection open for as long as you possibly need to access it: */

    /* @Override
    protected void onDestroy() {
        dbHelper.close();
        super.onDestroy();
    }*/
}
