/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.screens.activity.endofround;

import com.example.cthulhucompanion.screens.common.mvcviews.observable.ObservableViewMvc;

public interface ViewMvcEndOfRound extends ObservableViewMvc<ViewMvcEndOfRound.Listener> {

    interface Listener{
        void OnNextPlayerClicked();
    }
}
