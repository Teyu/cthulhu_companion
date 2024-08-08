/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.screens.activity.setup;

import android.util.Pair;

import com.example.cthulhucompanion.screens.common.mvcviews.observable.ObservableViewMvc;

import java.util.ArrayList;

public interface ViewMvcSetUp extends ObservableViewMvc<ViewMvcSetUp.Listener> {

    interface Listener{
        void OnFinishSetUp();
        void onPlayerColorButtonClicked(int position);

        void onCharacterAvatarClicked();
    }

    void bindAddPlayerPopUpsToPlayerColorButtons();

    void dismissAddPlayerPopUp();
    void setEpisodeList(final ArrayList<Pair<String, Integer>> titleAndCountPairs);

    void setGreatOldOnesList(final ArrayList<String> names);
}
