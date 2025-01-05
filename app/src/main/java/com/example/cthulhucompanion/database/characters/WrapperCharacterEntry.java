package com.example.cthulhucompanion.database.characters;

import com.example.cthulhucompanion.screens.activity.setup.playeravatar.ViewMvcPlayerAvatar;

public class WrapperCharacterEntry {

    private final int mImageResource;
    private final ViewMvcPlayerAvatar.Character mCharacterId;

    public WrapperCharacterEntry(int imageResource,
                                 ViewMvcPlayerAvatar.Character characterId) {
        this.mImageResource = imageResource;
        this.mCharacterId = characterId;
    }

    public int getImageResource() {
        return mImageResource;
    }

    public ViewMvcPlayerAvatar.Character getCharacterId() { return mCharacterId;}
}
