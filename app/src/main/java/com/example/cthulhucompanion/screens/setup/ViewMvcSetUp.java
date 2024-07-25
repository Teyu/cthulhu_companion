/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.screens.setup;

import com.example.cthulhucompanion.screens.common.mvcviews.observable.ObservableViewMvc;

public interface ViewMvcSetUp extends ObservableViewMvc<ViewMvcSetUp.Listener> {

    interface Listener{
        void OnFinishSetUp();
    }
}
