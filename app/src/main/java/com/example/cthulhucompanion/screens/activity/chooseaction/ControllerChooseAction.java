/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.screens.activity.chooseaction;

import android.content.Context;

import com.example.cthulhucompanion.screens.common.fragmentnavigator.FragmentNavigator;
import com.example.cthulhucompanion.screens.common.screensnavigator.ScreensNavigator;
import com.example.cthulhucompanion.screens.fragments.move.ControllerMove;
import com.example.cthulhucompanion.screens.fragments.move.ViewMvcMove;

public class ControllerChooseAction implements ViewMvcChooseAction.Listener{

    private final ScreensNavigator mScreensNavigator;
    private final FragmentNavigator mFragmentNavigator;
    private final Context mContext;

    private ViewMvcChooseAction mViewMvcChooseAction;
    private ControllerMove mControllerMove;

    public ControllerChooseAction(ScreensNavigator screensNavigator, FragmentNavigator fragmentNavigator, Context context) {
        this.mScreensNavigator = screensNavigator;
        this.mContext = context;
        this.mFragmentNavigator = fragmentNavigator;
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

    @Override
    public void onMoveButtonClicked() {
        mFragmentNavigator.displayFragmentMove(null);
    }
}
