package com.example.cthulhucompanion.database.episodes;

import static com.example.cthulhucompanion.database.episodes.FeedReaderContract.EpisodesFeedEntry.TABLE_EPISODES;

import android.provider.BaseColumns;

public final class FeedReaderContract {

    private FeedReaderContract() {} // prevent someone from accidentally creating an instance

    public static class EpisodesFeedEntry implements BaseColumns {
        public static final String TABLE_EPISODES = "episodes";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_COUNT = "count";
    }

    public static final String SQL_CREATE_EPISODE_ENTRIES = "INSERT INTO " + TABLE_EPISODES + " VALUES "
            + "('Blasphemische Alchemie', 1), "
            + "('Folianten des Wahnsinns', 2), "
            + "('Totentanz', 3), "
            + "('Unheimliche Götzen', 4), "
            + "('Verfluchte Gezeiten', 5), "
            + "('Zu nachtschlafender Zeit', 6)";
}
