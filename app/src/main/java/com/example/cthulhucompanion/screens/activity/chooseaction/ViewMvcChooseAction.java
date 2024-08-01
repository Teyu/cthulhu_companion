/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.screens.activity.chooseaction;

import android.view.View;

import com.example.cthulhucompanion.screens.common.mvcviews.observable.ObservableViewMvc;

public interface ViewMvcChooseAction extends ObservableViewMvc<ViewMvcChooseAction.Listener> {

    interface Listener{
        void OnMythosPhaseClicked();
        void onMoveButtonClicked();
        void onAttackButtonClicked();
        void onRestButtonClicked();
        void onTradeButtonClicked();
        void onLastActionButtonClicked();
    }

    void addFloatingActionButton();
    boolean canAddFloatingActionButton();

    void bindAttackPopupToLastActionButton();

    void bindMovePopupToLastActionButton();

    void bindRestPopupToLastActionButton();

    void bindTradePopupToLastActionButton();
}
