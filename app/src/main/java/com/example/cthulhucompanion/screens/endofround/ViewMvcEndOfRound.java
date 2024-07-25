/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.screens.endofround;

import com.example.cthulhucompanion.screens.common.mvcviews.ObservableViewMvc;

public interface ViewMvcEndOfRound extends ObservableViewMvc<ViewMvcEndOfRound.Listener> {

    interface Listener{
        void OnNextPlayerClicked();
    }
}
