/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.screens.fight;

import android.content.Context;

import com.example.cthulhucompanion.screens.common.screensnavigator.ScreensNavigator;

public class ControllerFight implements ViewMvcFight.Listener{

    private final ScreensNavigator mScreensNavigator;
    private final Context mContext;

    private ViewMvcFight mViewMvcFight;

    public ControllerFight(ScreensNavigator screensNavigator, Context context) {
        this.mScreensNavigator = screensNavigator;
        this.mContext = context;
    }

    void onStart() {
        mViewMvcFight.registerListener(this);
        /*mExample.registerListener(this);*/
    }

    void onStop() {
        mViewMvcFight.unregisterListener(this);
        /*mExample.unregisterListener(this);*/
    }

    void bindView (ViewMvcFight viewMvcFight) {
        mViewMvcFight = viewMvcFight;
    }

    @Override
    public void OnContinueClicked() {
        mScreensNavigator.toActivityEndOfRound(null);
    }
}
