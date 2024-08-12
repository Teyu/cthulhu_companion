package com.example.cthulhucompanion.database.characters;

import com.example.cthulhucompanion.screens.popup.selectcharacter.PopUpViewMvcSelectCharacterImpl;

public class WrapperCharacterEntry {

    private final int mImageResource;

    public WrapperCharacterEntry(int imageResource) {
        this.mImageResource = imageResource;
    }

    public int getImageResource() {
        return mImageResource;
    }
}
