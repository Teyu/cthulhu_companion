/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.screens.activity.setup;

import android.util.Pair;

import com.example.cthulhucompanion.screens.common.mvcviews.observable.ObservableViewMvc;
import com.example.cthulhucompanion.screens.popup.selectcharacter.PopUpViewMvcSelectCharacter;
import com.example.cthulhucompanion.screens.popup.selectcharacter.PopUpViewMvcSelectCharacterImpl;

import java.util.ArrayList;

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
    }

    void setPlayerAvatar(PlayerColor playerColor, PopUpViewMvcSelectCharacter.Character character);
    void removePlayerAvatar(PlayerColor playerColor);

    void setEpisodeList(final ArrayList<Pair<String, Integer>> titleAndCountPairs);

    void setGreatOldOnesList(final ArrayList<String> names);

    void setCharacterSelectionPopUpList(ArrayList<Pair<Integer, PopUpViewMvcSelectCharacterImpl.Character>> characterImageResources, PopUpViewMvcSelectCharacter.PopUpListener popUpListener);
}
