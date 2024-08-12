package com.example.cthulhucompanion.database.characters;

import android.provider.BaseColumns;

import com.example.cthulhucompanion.R;
import com.example.cthulhucompanion.screens.popup.selectcharacter.PopUpViewMvcSelectCharacterImpl;

public final class FeedReaderContract {

    private FeedReaderContract() {} // prevent someone from accidentally creating an instance

    public static class CharactersFeedEntry implements BaseColumns {
        public static final String TABLE_CHARACTERS = "characters";
        public static final String COLUMN_IMAGE_RESOURCE = "image_resource";
    }

    public static final String SQL_CREATE_CHARACTERS_ENTRIES = "INSERT INTO " + CharactersFeedEntry.TABLE_CHARACTERS + " VALUES "
            + "(" + R.drawable.avatar_ahmed_yasin + "), "
            + "(" + R.drawable.avatar_borden +  "), "
            + "(" + R.drawable.avatar_elizabeth_ives + "), "
            + "(" + R.drawable.avatar_rasputin + "), "
            + "(" + R.drawable.avatar_fatima_safar + "), "
            + "(" + R.drawable.avatar_lord_adam_benchley + "), "
            + "(" + R.drawable.avatar_sergeant_ian_welles + "), "
            + "(" + R.drawable.avatar_sister_beth + "), "
            + "(" + R.drawable.avatar_the_kid + "), "
            + "(" + R.drawable.avatar_john_morgan +  ")";
}
