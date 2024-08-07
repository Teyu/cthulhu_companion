/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.screens.activity.chooseaction;

import android.content.Context;

import com.example.cthulhucompanion.database.episodes.DataBaseEpisodes;
import com.example.cthulhucompanion.screens.activity.chooseaction.savedstate.SavedState;
import com.example.cthulhucompanion.screens.common.fragmentnavigator.FragmentNavigator;
import com.example.cthulhucompanion.screens.common.popupmanager.PopUpManager;
import com.example.cthulhucompanion.screens.common.screensnavigator.ScreensNavigator;
import com.example.cthulhucompanion.screens.popup.attack.PopUpViewMvcAttack;
import com.example.cthulhucompanion.screens.popup.move.PopUpViewMvcMove;
import com.example.cthulhucompanion.screens.popup.rest.PopUpViewMvcRest;
import com.example.cthulhucompanion.screens.popup.trade.PopUpViewMvcTrade;

import java.io.Serializable;

public class ControllerChooseAction implements ViewMvcChooseAction.Listener {

    private static final int MAX_NUM_LOGGABLE_ACTIONS = 3;
    private SavedState mSavedState;
    private final ScreensNavigator mScreensNavigator;
    private final FragmentNavigator mFragmentNavigator;
    private final PopUpManager mPopUpManager;
    private final PopUpListener mPopUpListener;

    private ViewMvcChooseAction mViewMvcChooseAction;
    private int mNumLoggedActions = 0;

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
        mPopUpManager.anchorPopUpMoveAndNotify(mViewMvcChooseAction.getLastConfirmActionButton(), mPopUpListener);
    }

    @Override
    public void onAttackButtonClicked() {
        mFragmentNavigator.displayFragmentAttack(null);
        mSavedState.setFragmentState(SavedState.FragmentState.ATTACK_SHOWN);
        mPopUpManager.anchorPopUpAttackAndNotify(mViewMvcChooseAction.getLastConfirmActionButton(), mPopUpListener);
    }

    @Override
    public void onRestButtonClicked() {
        mFragmentNavigator.displayFragmentRest(null);
        mSavedState.setFragmentState(SavedState.FragmentState.REST_SHOWN);
        mPopUpManager.anchorPopUpRest(mViewMvcChooseAction.getLastConfirmActionButton(), mPopUpListener);
    }

    @Override
    public void onTradeButtonClicked() {
        mFragmentNavigator.displayFragmentTrade(null);
        mSavedState.setFragmentState(SavedState.FragmentState.TRADE_SHOWN);
        mPopUpManager.anchorPopUpTrade(mViewMvcChooseAction.getLastConfirmActionButton(), mPopUpListener);
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
                mViewMvcChooseAction.addConfirmActionButton();
            case THREE_ACTION_BUTTONS_SHOWN:
                mViewMvcChooseAction.addConfirmActionButton();
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

    public class PopUpListener implements PopUpViewMvcMove.Listener, PopUpViewMvcAttack.Listener, PopUpViewMvcRest.Listener, PopUpViewMvcTrade.Listener {

        @Override
        public void onConfirmButtonClicked() {

            //log action:
            if (mNumLoggedActions < MAX_NUM_LOGGABLE_ACTIONS - 1) {
                mNumLoggedActions++;
            } else {
                mViewMvcChooseAction.disableAllConfirmActionButtons();
            }

            if (mViewMvcChooseAction.canAddActionButton()) {
                mViewMvcChooseAction.addConfirmActionButton();
            }

                switch (mSavedState.getFragmentState()){
                    case MOVE_SHOWN:
                        if (mPopUpManager.isPopUpMoveShowing()) {
                            mPopUpManager.dismissPopUpMove();
                        }

                        mPopUpManager.anchorPopUpMoveAndNotify(mViewMvcChooseAction.getLastConfirmActionButton(), this);
                        break;
                    case REST_SHOWN:
                        if (mPopUpManager.isPopUpRestShowing()) {
                            mPopUpManager.dismissPopUpRest();
                        }

                        mPopUpManager.anchorPopUpRest(mViewMvcChooseAction.getLastConfirmActionButton(), this);
                        break;
                    case TRADE_SHOWN:
                        if (mPopUpManager.isPopUpTradeShowing()) {
                            mPopUpManager.dismissPopUpTrade();
                        }

                        mPopUpManager.anchorPopUpTrade(mViewMvcChooseAction.getLastConfirmActionButton(), this);
                        break;
                    case ATTACK_SHOWN:
                        if (mPopUpManager.isPopUpAttackShowing()){
                            mPopUpManager.dismissPopUpAttack();
                        }
                        mPopUpManager.anchorPopUpAttackAndNotify(mViewMvcChooseAction.getLastConfirmActionButton(), this);
                        break;
                }

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
