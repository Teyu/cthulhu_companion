/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.screens.investigate;

import android.content.Context;

import com.example.cthulhucompanion.screens.common.screensnavigator.ScreensNavigator;

public class ControllerInvestigate implements ViewMvcInvestigate.Listener{

    private final ScreensNavigator mScreensNavigator;
    private final Context mContext;

    private ViewMvcInvestigate mViewMvcInvestigate;

    public ControllerInvestigate(ScreensNavigator screensNavigator, Context context) {
        this.mScreensNavigator = screensNavigator;
        this.mContext = context;
    }

    void onStart() {
        mViewMvcInvestigate.registerListener(this);
        /*mExample.registerListener(this);*/
    }

    void onStop() {
        mViewMvcInvestigate.unregisterListener(this);
        /*mExample.unregisterListener(this);*/
    }

    void bindView (ViewMvcInvestigate viewMvcInvestigate) {
        mViewMvcInvestigate = viewMvcInvestigate;
    }

    @Override
    public void OnContinueClicked() {
        mScreensNavigator.toActivityEndOfRound(null);
    }
}
