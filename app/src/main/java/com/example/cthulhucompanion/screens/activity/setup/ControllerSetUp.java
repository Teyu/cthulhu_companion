/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.screens.activity.setup;

import android.content.Context;
import android.view.View;

import com.example.cthulhucompanion.screens.common.popupmanager.PopUpManager;
import com.example.cthulhucompanion.screens.common.screensnavigator.ScreensNavigator;

import java.util.List;

public class ControllerSetUp implements ViewMvcSetUp.Listener{

    private final ScreensNavigator mScreensNavigator;

    private ViewMvcSetUp mViewMvcSetUp;

    public ControllerSetUp(ScreensNavigator screensNavigator) {
        this.mScreensNavigator = screensNavigator;
    }

    void onStart() {
        mViewMvcSetUp.registerListener(this);
    }

    void onStop() {
        mViewMvcSetUp.unregisterListener(this);
    }

    void bindView (ViewMvcSetUp viewMvcSetUp) {
        mViewMvcSetUp = viewMvcSetUp;

        mViewMvcSetUp.bindAddPlayerPopUpsToPlayerColorButtons();
    }

    @Override
    public void OnFinishSetUp() {
        mScreensNavigator.toActivityChooseAction(null);
    }

    @Override
    public void onPlayerColorButtonClicked(int position) {
    }

    @Override
    public void onCharacterAvatarClicked() {
        mViewMvcSetUp.dismissAddPlayerPopUp();
    }
}
