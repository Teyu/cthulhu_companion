/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.screens.activity.endofround;

import android.content.Context;

import com.example.cthulhucompanion.screens.common.screensnavigator.ScreensNavigator;

public class ControllerEndOfRound implements ViewMvcEndOfRound.Listener{

    private final ScreensNavigator mScreensNavigator;
    private final Context mContext;

    private ViewMvcEndOfRound mViewMvcEndOfRound;

    public ControllerEndOfRound(ScreensNavigator screensNavigator, Context context) {
        this.mScreensNavigator = screensNavigator;
        this.mContext = context;
    }

    void onStart() {
        mViewMvcEndOfRound.registerListener(this);
        /*mExample.registerListener(this);*/
    }

    void onStop() {
        mViewMvcEndOfRound.unregisterListener(this);
        /*mExample.unregisterListener(this);*/
    }

    void bindView (ViewMvcEndOfRound viewMvcEndOfRound) {
        mViewMvcEndOfRound = viewMvcEndOfRound;
    }

    @Override
    public void OnNextPlayerClicked() {
        mScreensNavigator.toActivityChooseAction(null);
    }
}
