/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.screens.investigate;

import com.example.cthulhucompanion.screens.common.mvcviews.observable.ObservableViewMvc;

public interface ViewMvcInvestigate extends ObservableViewMvc<ViewMvcInvestigate.Listener> {

    interface Listener{
        void OnContinueClicked();
    }
}
