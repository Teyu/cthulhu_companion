package com.example.cthulhucompanion.database.characters;

import static com.example.cthulhucompanion.screens.popup.selectcharacter.PopUpViewMvcSelectCharacter.Character.*;
import static com.example.cthulhucompanion.screens.popup.selectcharacter.PopUpViewMvcSelectCharacter.Character;

import android.provider.BaseColumns;

import com.example.cthulhucompanion.R;
import com.example.cthulhucompanion.screens.popup.selectcharacter.PopUpViewMvcSelectCharacter;

public final class FeedReaderContract {

    private FeedReaderContract() {} // prevent someone from accidentally creating an instance

    public static class CharactersFeedEntry implements BaseColumns {
        public static final String TABLE_CHARACTERS = "characters";
        public static final String COLUMN_IMAGE_RESOURCE = "image_resource";
        public static final String COLUMN_CHARACTER_ID = "character_id";
    }

    public static final String SQL_CREATE_CHARACTERS_ENTRIES = "INSERT INTO " + CharactersFeedEntry.TABLE_CHARACTERS + " VALUES "
            + "(" + R.drawable.avatar_ahmed_yasin + "," + "'" + AHMED_YASIN.toString() + "'" + "), "
            + "(" + R.drawable.avatar_borden + "," + "'" + BORDEN.toString() + "'" +  "), "
            + "(" + R.drawable.avatar_elizabeth_ives + "," + "'" + ELIZABETH_IVES.toString() + "'" + "), "
            + "(" + R.drawable.avatar_rasputin + "," + "'" + RASPUTIN.toString() + "'" +  "), "
            + "(" + R.drawable.avatar_fatima_safar + "," + "'" + FATIMA_SAFAR.toString() + "'" +  "), "
            + "(" + R.drawable.avatar_lord_adam_benchley + "," + "'" + LORD_ADAM_BENCHLEY.toString() + "'" +  "), "
            + "(" + R.drawable.avatar_sergeant_ian_welles + "," + "'" + SERGEANT_IAN_WELLES.toString() + "'" +  "), "
            + "(" + R.drawable.avatar_sister_beth + "," + "'" + SISTER_BETH.toString() + "'" + "), "
            + "(" + R.drawable.avatar_the_kid + "," + "'" + THE_KID.toString() + "'" + "), "
            + "(" + R.drawable.avatar_john_morgan + "," + "'" + JOHN_MORGAN.toString() + "'" +  ")";
}
