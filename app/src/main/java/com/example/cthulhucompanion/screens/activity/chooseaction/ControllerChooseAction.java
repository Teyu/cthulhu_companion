/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.screens.activity.chooseaction;

import android.content.Context;

import com.example.cthulhucompanion.screens.common.fragmentnavigator.FragmentNavigator;
import com.example.cthulhucompanion.screens.common.popupnavigator.PopUpNavigator;
import com.example.cthulhucompanion.screens.common.screensnavigator.ScreensNavigator;
import com.example.cthulhucompanion.screens.popup.move.PopUpViewMvcMove;

import java.io.Serializable;

public class ControllerChooseAction implements ViewMvcChooseAction.Listener, PopUpViewMvcMove.Listener {
    private SavedState mSavedState;
    private final ScreensNavigator mScreensNavigator;
    private final FragmentNavigator mFragmentNavigator;
    private final PopUpNavigator mPopUpNavigator;

    private ViewMvcChooseAction mViewMvcChooseAction;

    public ControllerChooseAction(ScreensNavigator screensNavigator,
                                  FragmentNavigator fragmentNavigator,
                                  PopUpNavigator popUpNavigator,
                                  Context context) {
        this.mScreensNavigator = screensNavigator;
        this.mFragmentNavigator = fragmentNavigator;
        this.mPopUpNavigator = popUpNavigator;
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
        mPopUpNavigator.anchorPopUpMove(mViewMvcChooseAction.getLogActionView(), this);
    }

    @Override
    public void onAttackButtonClicked() {
        mFragmentNavigator.displayFragmentAttack(null);
        mSavedState.setFragmentState(SavedState.FragmentState.ATTACK_SHOWN);
        mPopUpNavigator.anchorPopUpAttack(mViewMvcChooseAction.getLogActionView());
    }

    @Override
    public void onRestButtonClicked() {
        mFragmentNavigator.displayFragmentRest(null);
        mSavedState.setFragmentState(SavedState.FragmentState.REST_SHOWN);
        mPopUpNavigator.anchorPopUpRest(mViewMvcChooseAction.getLogActionView());
    }

    @Override
    public void onTradeButtonClicked() {
        mFragmentNavigator.displayFragmentTrade(null);
        mSavedState.setFragmentState(SavedState.FragmentState.TRADE_SHOWN);
        mPopUpNavigator.anchorPopUpTrade(mViewMvcChooseAction.getLogActionView());
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

    //TODO: nested controller??
    @Override
    public void onConfirmButtonClicked() {
        //log action:

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
        /*switch (mSavedState.getScreenState()){
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
        }*/
    }
}
