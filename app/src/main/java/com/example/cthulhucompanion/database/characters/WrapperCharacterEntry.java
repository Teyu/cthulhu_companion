package com.example.cthulhucompanion.database.characters;

public class WrapperCharacterEntry {

    private final int mImageResource;
    private final int mImageButtonId;

    public WrapperCharacterEntry(int imageResource, int imageButtonId) {
        this.mImageResource = imageResource;
        this.mImageButtonId = imageButtonId;
    }

    public int getImageResource() {
        return mImageResource;
    }

    public int getImageButtonId() {
        return mImageButtonId;
    }
}
