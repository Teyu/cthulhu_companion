package com.example.cthulhucompanion.database.episodes;

public class WrapperEpisodeEntry {

    private final String mTitle;
    private final int mCount;

    public WrapperEpisodeEntry(String title, int count){
        this.mTitle = title;
        this.mCount = count;
    }

    public String getTitle() {
        return mTitle;
    }

    public int getCount() {
        return mCount;
    }
}
