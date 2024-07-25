/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.screens.mythosphase;

import android.content.Context;

import com.example.cthulhucompanion.screens.common.screensnavigator.ScreensNavigator;

public class ControllerMythosPhase implements ViewMvcMythosPhase.Listener{

    private final ScreensNavigator mScreensNavigator;
    private final Context mContext;

    private ViewMvcMythosPhase mViewMvcMythosPhase;

    public ControllerMythosPhase(ScreensNavigator screensNavigator, Context context) {
        this.mScreensNavigator = screensNavigator;
        this.mContext = context;
    }

    void onStart() {
        mViewMvcMythosPhase.registerListener(this);
        /*mExample.registerListener(this);*/
    }

    void onStop() {
        mViewMvcMythosPhase.unregisterListener(this);
        /*mExample.unregisterListener(this);*/
    }

    void bindView (ViewMvcMythosPhase viewMvcMythosPhase) {
        mViewMvcMythosPhase = viewMvcMythosPhase;
    }

    @Override
    public void OnFightClicked() {
        mScreensNavigator.toActivityFight(null);
    }

    @Override
    public void OnInvestigateClicked() {
        mScreensNavigator.toActivityInvestigate(null);
    }
}
