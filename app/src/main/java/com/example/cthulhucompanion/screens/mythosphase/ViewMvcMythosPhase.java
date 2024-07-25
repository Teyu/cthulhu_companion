/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.screens.mythosphase;

import com.example.cthulhucompanion.screens.common.mvcviews.ObservableViewMvc;

public interface ViewMvcMythosPhase extends ObservableViewMvc<ViewMvcMythosPhase.Listener> {

    interface Listener{
        void OnFightClicked();

        void OnInvestigateClicked();
    }
}
