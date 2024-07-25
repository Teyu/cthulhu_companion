/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.screens.setup;

import android.content.Context;

import com.example.cthulhucompanion.screens.common.screensnavigator.ScreensNavigator;

public class ControllerSetUp implements ViewMvcSetUp.Listener{

    private final ScreensNavigator mScreensNavigator;
    private final Context mContext;

    private ViewMvcSetUp mViewMvcSetUp;

    public ControllerSetUp(ScreensNavigator screensNavigator, Context context) {
        this.mScreensNavigator = screensNavigator;
        this.mContext = context;
    }

    void onStart() {
        mViewMvcSetUp.registerListener(this);
        //mExample.registerListener(this);
    }

    void onStop() {
        mViewMvcSetUp.unregisterListener(this);
        //mExample.unregisterListener(this);
    }

    void bindView (ViewMvcSetUp viewMvcSetUp) {
        mViewMvcSetUp = viewMvcSetUp;
    }

    @Override
    public void OnFinishSetUp() {
        mScreensNavigator.toActivityChooseAction(null);
    }
}
