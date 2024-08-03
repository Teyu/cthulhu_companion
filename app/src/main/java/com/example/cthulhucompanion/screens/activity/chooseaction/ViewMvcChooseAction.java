/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.screens.activity.chooseaction;

import android.view.View;
import android.widget.Button;

import com.example.cthulhucompanion.screens.common.mvcviews.observable.ObservableViewMvc;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public interface ViewMvcChooseAction extends ObservableViewMvc<ViewMvcChooseAction.Listener> {

    interface Listener{
        void OnMythosPhaseClicked();
        void onMoveButtonClicked();
        void onAttackButtonClicked();
        void onRestButtonClicked();
        void onTradeButtonClicked();
        void onLastActionButtonClicked();
        void onPopupConfirmButtonClicked();
    }

    void addFloatingActionButton();
    boolean canAddFloatingActionButton();
    FloatingActionButton getLastActionButton(); //TODO: controller should not be aware of View -> onLastActionButtonClicked
}
