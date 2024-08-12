package com.example.cthulhucompanion.database.characters;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.cthulhucompanion.screens.popup.selectcharacter.PopUpViewMvcSelectCharacterImpl;

import java.util.AbstractList;
import java.util.ArrayList;

public class DataBaseCharacters {

    private final AbstractList<WrapperCharacterEntry> mEntries = new ArrayList<>();

    @SuppressLint("Range")
    public AbstractList<WrapperCharacterEntry> readData(SQLiteDatabase db){

        String[] projection = { // specifies which columns from the database you will actually use after this query.
                FeedReaderContract.CharactersFeedEntry.COLUMN_IMAGE_RESOURCE
        };

        Cursor cursor = db.query(
                FeedReaderContract.CharactersFeedEntry.TABLE_CHARACTERS,
                projection,
                null, //selection
                null, //selectionArgs
                null,null,null
        );

        while(cursor.moveToNext()) {

            int imageResource = cursor.getInt( cursor.getColumnIndex(
                    FeedReaderContract.CharactersFeedEntry.COLUMN_IMAGE_RESOURCE)
            );

            mEntries.add(new WrapperCharacterEntry(imageResource));
        }
        cursor.close();

        return mEntries;
    }
}
