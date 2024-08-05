/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.screens.activity.setup;

import android.view.View;

import com.example.cthulhucompanion.screens.common.mvcviews.observable.ObservableViewMvc;

import java.util.List;

public interface ViewMvcSetUp extends ObservableViewMvc<ViewMvcSetUp.Listener> {

    interface Listener{
        void OnFinishSetUp();
        void onPlayerColorButtonClicked(int position);

        void onCharacterAvatarClicked();
    }

    void bindAddPlayerPopUpsToPlayerColorButtons();

    void dismissAddPlayerPopUp();
}
