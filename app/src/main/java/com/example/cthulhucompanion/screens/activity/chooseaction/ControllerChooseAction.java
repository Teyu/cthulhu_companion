/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.screens.activity.chooseaction;

import android.content.Context;

import com.example.cthulhucompanion.screens.common.screensnavigator.ScreensNavigator;

public class ControllerChooseAction implements ViewMvcChooseAction.Listener{

    private final ScreensNavigator mScreensNavigator;
    private final Context mContext;

    private ViewMvcChooseAction mViewMvcChooseAction;

    public ControllerChooseAction(ScreensNavigator screensNavigator, Context context) {
        this.mScreensNavigator = screensNavigator;
        this.mContext = context;
    }

    void onStart() {
        mViewMvcChooseAction.registerListener(this);
        /*mExample.registerListener(this);*/
    }

    void onStop() {
        mViewMvcChooseAction.unregisterListener(this);
        /*mExample.unregisterListener(this);*/
    }

    void bindView (ViewMvcChooseAction viewMvcChooseAction) {
        mViewMvcChooseAction = viewMvcChooseAction;
    }

    @Override
    public void OnContinueClicked() {
        mScreensNavigator.toActivityMythosPhase(null);
    }
}
