/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.screens.activity.setup;

import android.util.Pair;

import com.example.cthulhucompanion.screens.common.mvcviews.observable.ObservableViewMvc;
import com.example.cthulhucompanion.screens.common.popupmanager.PopUpManager;
import com.example.cthulhucompanion.screens.popup.selectcharacter.PopUpViewMvcSelectCharacter;
import com.example.cthulhucompanion.screens.popup.selectcharacter.PopUpViewMvcSelectCharacterImpl;

import java.util.ArrayList;
import java.util.HashMap;

public interface ViewMvcSetUp extends ObservableViewMvc<ViewMvcSetUp.Listener> {

    enum PlayerColor{
        PLAYER_RED,
        PLAYER_BLUE,
        PLAYER_ORANGE,
        PLAYER_VIOLET,
        PLAYER_GREEN
    }

    interface Listener{
        void OnFinishSetUp();
        void onCharacterSelected(PlayerColor playerBlue, PopUpViewMvcSelectCharacter.Character character);
        void onCharacterDeleted(PlayerColor playerColor, PopUpViewMvcSelectCharacter.Character character);
    }

    void setPlayerAvatar(PlayerColor playerColor, PopUpViewMvcSelectCharacter.Character character);
    void removePlayerAvatar(PlayerColor playerColor);

    void setEpisodeList(final ArrayList<Pair<String, Integer>> titleAndCountPairs);

    void setGreatOldOnesList(final ArrayList<String> names);
    void bindCharacterSelectionPopUp(PopUpManager mPopUpManagerMock);

    void setCharacterSelectionPopUp(HashMap<Integer, PopUpViewMvcSelectCharacterImpl.Character> characterImageResources, PopUpViewMvcSelectCharacter.PopUpListener popUpListener);

    void addCharacterToPopUpSelection(PopUpViewMvcSelectCharacter.Character character);

    void removeCharacterFromPopUpSelection(PopUpViewMvcSelectCharacter.Character character);

    void provideCharacterDeleteButton();

    void disableCharacterDeleteButton();
}
