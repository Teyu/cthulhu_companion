/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.screens.activity.chooseaction;

import android.content.Context;

import com.example.cthulhucompanion.screens.common.fragmentnavigator.FragmentNavigator;
import com.example.cthulhucompanion.screens.common.screensnavigator.ScreensNavigator;
import com.example.cthulhucompanion.screens.fragments.move.ControllerMove;

import java.io.Serializable;

public class ControllerChooseAction implements ViewMvcChooseAction.Listener{
    private SavedState mScreenState;
    private final ScreensNavigator mScreensNavigator;
    private final FragmentNavigator mFragmentNavigator;
    private final Context mContext;

    private ViewMvcChooseAction mViewMvcChooseAction;

    public ControllerChooseAction(ScreensNavigator screensNavigator, FragmentNavigator fragmentNavigator, Context context) {
        this.mScreensNavigator = screensNavigator;
        this.mContext = context;
        this.mFragmentNavigator = fragmentNavigator;
        this.mScreenState = new SavedState();
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
    public void OnMythosPhaseClicked() {
        mScreensNavigator.toActivityMythosPhase(null);
    }

    @Override
    public void onMoveButtonClicked() {
        mFragmentNavigator.displayFragmentMove(null);
    }

    @Override
    public void onAttackButtonClicked() {
        mFragmentNavigator.displayFragmentAttack(null);
    }

    @Override
    public void onRestButtonClicked() {
        mFragmentNavigator.displayFragmentRest(null);
    }

    @Override
    public void onTradeButtonClicked() {
        mFragmentNavigator.displayFragmentTrade(null);
    }

    @Override
    public void onLastActionButtonClicked() {
        //TODO: confirm action
        if (mViewMvcChooseAction.canAddFloatingActionButton()) {
            mViewMvcChooseAction.addFloatingActionButton();

            switch(mScreenState.getState()){
                case ONE_ACTION_BUTTON_SHOWN:
                    mScreenState.setState(SavedState.ScreenState.TWO_ACTION_BUTTONS_SHOWN);
                    break;
                case TWO_ACTION_BUTTONS_SHOWN:
                    mScreenState.setState(SavedState.ScreenState.THREE_ACTION_BUTTONS_SHOWN);
                    break;
            }
        }
    }

    public Serializable getScreenState() {
        return mScreenState;
    }

    public void restoreScreenState(Serializable screenState) {
        mScreenState = (SavedState) screenState;
        switch (mScreenState.getState()){
            case ONE_ACTION_BUTTON_SHOWN:
                break;
            case TWO_ACTION_BUTTONS_SHOWN:
                mViewMvcChooseAction.addFloatingActionButton();
            case THREE_ACTION_BUTTONS_SHOWN:
                mViewMvcChooseAction.addFloatingActionButton();
        }
    }
}
