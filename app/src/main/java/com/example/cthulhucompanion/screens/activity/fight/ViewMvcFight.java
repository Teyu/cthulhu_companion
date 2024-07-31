/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.screens.activity.fight;

import com.example.cthulhucompanion.screens.common.mvcviews.observable.ObservableViewMvc;

public interface ViewMvcFight extends ObservableViewMvc<ViewMvcFight.Listener> {

    interface Listener{
        void OnContinueClicked();
    }
}
