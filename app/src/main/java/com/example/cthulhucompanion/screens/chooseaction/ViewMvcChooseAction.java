/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.screens.chooseaction;

import com.example.cthulhucompanion.screens.common.mvcviews.ObservableViewMvc;

public interface ViewMvcChooseAction extends ObservableViewMvc<ViewMvcChooseAction.Listener> {

    interface Listener{
        void OnContinueClicked();
    }
}