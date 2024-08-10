package com.example.cthulhucompanion.database.characters;

import android.provider.BaseColumns;

import com.example.cthulhucompanion.R;

public final class FeedReaderContract {

    private FeedReaderContract() {} // prevent someone from accidentally creating an instance

    public static class CharactersFeedEntry implements BaseColumns {
        public static final String TABLE_CHARACTERS = "characters";
        public static final String COLUMN_IMAGE_RESOURCE = "image_resource";
        public static final String COLUMN_IMAGE_BUTTON_ID = "image_button_id";
    }

    public static final String SQL_CREATE_CHARACTERS_ENTRIES = "INSERT INTO " + CharactersFeedEntry.TABLE_CHARACTERS + " VALUES "
            + "(" + R.drawable.avatar_ahmed_yasin + ", " + R.id.avatar_ahmed_yasin_btn + "), "
            + "(" + R.drawable.avatar_borden + ", " + R.id.avatar_borden_btn +  "), "
            + "(" + R.drawable.avatar_elizabeth_ives + ", " + R.id.avatar_elizabeth_ives_btn + "), "
            + "(" + R.drawable.avatar_rasputin + ", " + R.id.avatar_rasputin_btn + "), "
            + "(" + R.drawable.avatar_fatima_safar + ", " + R.id.avatar_fatima_safar_btn + "), "
            + "(" + R.drawable.avatar_lord_adam_benchley + ", " + R.id.avatar_lord_benchley_btn + "), "
            + "(" + R.drawable.avatar_sergeant_ian_welles + ", " + R.id.avatar_sergeant_welles_btn + "), "
            + "(" + R.drawable.avatar_sister_beth + ", " + R.id.avatar_sister_beth_btn + "), "
            + "(" + R.drawable.avatar_the_kid + ", " + R.id.avatar_the_kid_btn + "), "
            + "(" + R.drawable.avatar_john_morgan + ", " + R.id.avatar_john_morgan_btn +  ")";
}
