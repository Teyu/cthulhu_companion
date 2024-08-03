/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.screens.activity.chooseaction;

import android.content.Context;

import com.example.cthulhucompanion.screens.common.fragmentnavigator.FragmentNavigator;
import com.example.cthulhucompanion.screens.common.popupmanager.PopUpManager;
import com.example.cthulhucompanion.screens.common.screensnavigator.ScreensNavigator;
import com.example.cthulhucompanion.screens.popup.move.PopUpViewMvcMove;

import java.io.Serializable;

public class ControllerChooseAction implements ViewMvcChooseAction.Listener {
    private SavedState mSavedState;
    private final ScreensNavigator mScreensNavigator;
    private final FragmentNavigator mFragmentNavigator;
    private final PopUpManager mPopUpManager;
    private final PopUpListener mPopUpListener;

    private ViewMvcChooseAction mViewMvcChooseAction;

    public ControllerChooseAction(ScreensNavigator screensNavigator,
                                  FragmentNavigator fragmentNavigator,
                                  PopUpManager popUpManager,
                                  Context context) {
        this.mScreensNavigator = screensNavigator;
        this.mFragmentNavigator = fragmentNavigator;
        this.mPopUpManager = popUpManager;
        this.mPopUpListener = new PopUpListener();
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
        mPopUpManager.anchorPopUpMoveAndNotify(mViewMvcChooseAction.getLastActionButton(), mPopUpListener);
    }

    @Override
    public void onAttackButtonClicked() {
        mFragmentNavigator.displayFragmentAttack(null);
        mSavedState.setFragmentState(SavedState.FragmentState.ATTACK_SHOWN);
        mPopUpManager.anchorPopUpAttack(mViewMvcChooseAction.getLastActionButton());
    }

    @Override
    public void onRestButtonClicked() {
        mFragmentNavigator.displayFragmentRest(null);
        mSavedState.setFragmentState(SavedState.FragmentState.REST_SHOWN);
        mPopUpManager.anchorPopUpRest(mViewMvcChooseAction.getLastActionButton());
    }

    @Override
    public void onTradeButtonClicked() {
        mFragmentNavigator.displayFragmentTrade(null);
        mSavedState.setFragmentState(SavedState.FragmentState.TRADE_SHOWN);
        mPopUpManager.anchorPopUpTrade(mViewMvcChooseAction.getLastActionButton());
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
                mViewMvcChooseAction.addActionButton();
            case THREE_ACTION_BUTTONS_SHOWN:
                mViewMvcChooseAction.addActionButton();
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

    public class PopUpListener implements PopUpViewMvcMove.Listener{

        @Override
        public void onConfirmButtonClicked() {

            //log action:

            if (mViewMvcChooseAction.canAddActionButton()) {
                mViewMvcChooseAction.addActionButton();
                mPopUpManager.dismissPopUpMove();
                mPopUpManager.anchorPopUpMoveAndNotify(mViewMvcChooseAction.getLastActionButton(), this);

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
    }
}
