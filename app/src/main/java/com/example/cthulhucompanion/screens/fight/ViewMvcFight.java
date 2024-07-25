/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.screens.fight;

import com.example.cthulhucompanion.screens.common.mvcviews.ObservableViewMvc;

public interface ViewMvcFight extends ObservableViewMvc<ViewMvcFight.Listener> {

    interface Listener{
        void OnContinueClicked();
    }
}
