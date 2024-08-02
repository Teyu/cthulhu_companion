/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.screens.activity.chooseaction;

import android.content.Context;

import com.example.cthulhucompanion.screens.common.fragmentnavigator.FragmentNavigator;
import com.example.cthulhucompanion.screens.common.screensnavigator.ScreensNavigator;
import com.example.cthulhucompanion.screens.popup.move.ViewMvcPopupMove;

import java.io.Serializable;

public class ControllerChooseAction implements ViewMvcChooseAction.Listener {
    private SavedState mSavedState;
    private final ScreensNavigator mScreensNavigator;
    private final FragmentNavigator mFragmentNavigator;

    private ViewMvcChooseAction mViewMvcChooseAction;

    public ControllerChooseAction(ScreensNavigator screensNavigator,
                                  FragmentNavigator fragmentNavigator,
                                  Context context) {
        this.mScreensNavigator = screensNavigator;
        this.mFragmentNavigator = fragmentNavigator;
        this.mSavedState = new SavedState();
    }

    void onStart() {
        mViewMvcChooseAction.registerListener(this);
    }

    void onStop() {
        mViewMvcChooseAction.unregisterListener(this);
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
        mSavedState.setFragmentState(SavedState.FragmentState.MOVE_SHOWN);
        mViewMvcChooseAction.bindMovePopupToLastActionButton();
    }

    @Override
    public void onAttackButtonClicked() {
        mFragmentNavigator.displayFragmentAttack(null);
        mSavedState.setFragmentState(SavedState.FragmentState.ATTACK_SHOWN);
        mViewMvcChooseAction.bindAttackPopupToLastActionButton();
    }

    @Override
    public void onRestButtonClicked() {
        mFragmentNavigator.displayFragmentRest(null);
        mSavedState.setFragmentState(SavedState.FragmentState.REST_SHOWN);
        mViewMvcChooseAction.bindRestPopupToLastActionButton();
    }

    @Override
    public void onTradeButtonClicked() {
        mFragmentNavigator.displayFragmentTrade(null);
        mSavedState.setFragmentState(SavedState.FragmentState.TRADE_SHOWN);
        mViewMvcChooseAction.bindTradePopupToLastActionButton();
    }

    @Override
    public void onLastActionButtonClicked() {
        if (mViewMvcChooseAction.canAddFloatingActionButton()) {
            mViewMvcChooseAction.addFloatingActionButton();

            switch(mSavedState.getScreenState()){
                case ONE_ACTION_BUTTON_SHOWN:
                    mSavedState.setScreenState(SavedState.ScreenState.TWO_ACTION_BUTTONS_SHOWN);
                    break;
                case TWO_ACTION_BUTTONS_SHOWN:
                    mSavedState.setScreenState(SavedState.ScreenState.THREE_ACTION_BUTTONS_SHOWN);
                    break;
            }
        }
    }

    public Serializable getSavedState() {
        return mSavedState;
    }

    public void restoreSavedState(Serializable screenState) {
        mSavedState = (SavedState) screenState;
        switch (mSavedState.getScreenState()){
            case ONE_ACTION_BUTTON_SHOWN:
                break;
            case TWO_ACTION_BUTTONS_SHOWN:
                mViewMvcChooseAction.addFloatingActionButton();
            case THREE_ACTION_BUTTONS_SHOWN:
                mViewMvcChooseAction.addFloatingActionButton();
        }

        switch (mSavedState.getFragmentState()){
            case ATTACK_SHOWN:
                mFragmentNavigator.displayFragmentAttack(null);
                break;
            case TRADE_SHOWN:
                mFragmentNavigator.displayFragmentTrade(null);
                break;
            case REST_SHOWN:
                mFragmentNavigator.displayFragmentRest(null);
                break;
            case MOVE_SHOWN:
                mFragmentNavigator.displayFragmentMove(null);
                break;
        }
    }

    public void onPopupConfirmButtonClicked() {

        //log action:
        switch (mSavedState.getScreenState()){
            case ONE_ACTION_BUTTON_SHOWN:
                mViewMvcChooseAction.addFloatingActionButton();
                mSavedState.setScreenState(SavedState.ScreenState.TWO_ACTION_BUTTONS_SHOWN);
                break;
            case TWO_ACTION_BUTTONS_SHOWN:
                mViewMvcChooseAction.addFloatingActionButton();
                mSavedState.setScreenState(SavedState.ScreenState.THREE_ACTION_BUTTONS_SHOWN);
                break;
            case THREE_ACTION_BUTTONS_SHOWN:
                mScreensNavigator.toActivityMythosPhase(null);
                break;
        }
    }
}
