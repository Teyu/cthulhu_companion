/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.common.dependencyinjection;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.NonNull;

import com.example.cthulhucompanion.database.FeedReaderSQLHelper;

public class CompositionRoot {

    private FeedReaderSQLHelper mFeedReaderSQlHelper;

    public SQLiteDatabase accessReadableDataBase(@NonNull Context context){
        if (mFeedReaderSQlHelper == null){
            mFeedReaderSQlHelper = new FeedReaderSQLHelper(context);
        }

        return mFeedReaderSQlHelper.getReadableDatabase();
    }
}
