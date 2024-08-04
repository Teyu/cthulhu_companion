/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.screens.activity.setup;

import android.content.Context;
import android.view.View;

import com.example.cthulhucompanion.screens.common.popupmanager.PopUpManager;
import com.example.cthulhucompanion.screens.common.screensnavigator.ScreensNavigator;
import com.example.cthulhucompanion.screens.popup.addplayer.PopUpViewMvcAddPlayer;

import java.util.List;

public class ControllerSetUp implements ViewMvcSetUp.Listener{

    private final ScreensNavigator mScreensNavigator;
    private final PopUpManager mPopUpManager;
    private final Context mContext;

    private ViewMvcSetUp mViewMvcSetUp;
    private PopUpListener mPopUpListener;

    public ControllerSetUp(ScreensNavigator screensNavigator,
                           PopUpManager popUpManager,
                           Context context) {
        this.mScreensNavigator = screensNavigator;
        this.mPopUpManager = popUpManager;
        this.mContext = context;
        this.mPopUpListener = new PopUpListener();
    }

    void onStart() {
        mViewMvcSetUp.registerListener(this);
    }

    void onStop() {
        mViewMvcSetUp.unregisterListener(this);
    }

    void bindView (ViewMvcSetUp viewMvcSetUp) {
        mViewMvcSetUp = viewMvcSetUp;
    }

    @Override
    public void OnFinishSetUp() {
        mScreensNavigator.toActivityChooseAction(null);
    }

    @Override
    public void onPlayerColorButtonClicked(int position) {

        List<View> anchorButtons = mViewMvcSetUp.getAllPlayerChooseColorButtons();
        for (View anchorButton : anchorButtons){
            mPopUpManager.anchorPopUpAddPlayer(anchorButton, mPopUpListener);
        }
    }

    public static class PopUpListener implements PopUpViewMvcAddPlayer.Listener {

        @Override
        public void onConfirmButtonClicked() {
            //TODO
        }
    }
}
