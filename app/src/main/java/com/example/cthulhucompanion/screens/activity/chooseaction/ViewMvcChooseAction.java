/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.screens.activity.chooseaction;

import com.example.cthulhucompanion.screens.common.mvcviews.observable.ObservableViewMvc;

public interface ViewMvcChooseAction extends ObservableViewMvc<ViewMvcChooseAction.Listener> {

    interface Listener{
        void OnContinueClicked();
        void onMoveButtonClicked();
    }


}
