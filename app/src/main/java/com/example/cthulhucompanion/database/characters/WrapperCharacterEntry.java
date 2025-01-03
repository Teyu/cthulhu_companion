package com.example.cthulhucompanion.database.characters;

import com.example.cthulhucompanion.screens.popup.selectcharacter.PopUpViewMvcSelectCharacter;
import com.example.cthulhucompanion.screens.popup.selectcharacter.PopUpViewMvcSelectCharacterImpl;

public class WrapperCharacterEntry {

    private final int mImageResource;
    private final PopUpViewMvcSelectCharacter.Character mCharacterId;

    public WrapperCharacterEntry(int imageResource,
                                 PopUpViewMvcSelectCharacter.Character characterId) {
        this.mImageResource = imageResource;
        this.mCharacterId = characterId;
    }

    public int getImageResource() {
        return mImageResource;
    }

    public PopUpViewMvcSelectCharacter.Character getCharacterId() { return mCharacterId;}
}
