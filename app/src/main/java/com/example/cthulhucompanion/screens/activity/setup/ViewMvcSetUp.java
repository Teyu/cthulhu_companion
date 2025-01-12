/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.screens.activity.setup;

import android.util.Pair;

import com.example.cthulhucompanion.screens.activity.setup.playeravatar.ViewMvcPlayerAvatar;
import com.example.cthulhucompanion.screens.common.mvcviews.observable.ObservableViewMvc;

import java.util.*;

public interface ViewMvcSetUp extends ObservableViewMvc<ViewMvcSetUp.Listener> {

    enum PlayerColor{
        PLAYER_RED,
        PLAYER_BLUE,
        PLAYER_ORANGE,
        PLAYER_VIOLET,
        PLAYER_GREEN
    }

    interface Listener{
        void onPlayerAvatarClicked(PlayerColor playerColor);
        void OnFinishSetUp();
        void onCharacterSelected(PlayerColor playerBlue, ViewMvcPlayerAvatar.Character character);
        void onCharacterDeleted(PlayerColor playerColor);
    }

    void setPlayerAvatar(PlayerColor playerColor, ViewMvcPlayerAvatar.Character character);
    ViewMvcPlayerAvatar.Character getSelectedCharacter(PlayerColor playerColor);
    void removePlayerAvatar(PlayerColor playerColor);

    void setEpisodeList(final ArrayList<Pair<String, Integer>> titleAndCountPairs);

    void setGreatOldOnesList(final ArrayList<String> names);
    void bindCharacterSelectionPopUp();
    void dismissPopUpAddPlayer(PlayerColor playerColor);

    void setCharacterSelectionPopUp(PlayerColor color, HashMap<Integer, ViewMvcPlayerAvatar.Character> characterImageResources);

    void addCharacterToPopUpSelection(ViewMvcPlayerAvatar.Character character);

    void removeCharacterFromPopUpSelection(ViewMvcPlayerAvatar.Character character);
    boolean selectionContainsCharacter(PlayerColor playerColor, ViewMvcPlayerAvatar.Character character);

    void provideCharacterDelete();

    void disableCharacterDelete();
}
