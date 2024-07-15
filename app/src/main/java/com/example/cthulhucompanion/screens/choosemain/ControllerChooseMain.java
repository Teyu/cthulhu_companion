/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.screens.choosemain;

import android.content.Context;

import com.example.cthulhucompanion.screens.common.screensnavigator.ScreensNavigator;

public class ControllerChooseMain implements ViewMvcMain.Listener{

    private final ScreensNavigator mScreensNavigator;
    private final Context mContext;

    private ViewMvcMain mViewMvcWelcome;

    public ControllerChooseMain(ScreensNavigator screensNavigator, Context context) {
        this.mScreensNavigator = screensNavigator;
        this.mContext = context;
    }

    void onStart() {
        /*mViewMvcWelcome.registerListener(this);
        mExample.registerListener(this);*/
    }

    void onStop() {
        /*mViewMvcWelcome.unregisterListener(this);
        mExample.unregisterListener(this);*/
    }

    void bindView (ViewMvcMain viewMvcWelcome) {
        mViewMvcWelcome = viewMvcWelcome;
    }
}
