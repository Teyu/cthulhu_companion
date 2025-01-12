/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.common.dependencyinjection;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import com.example.cthulhucompanion.database.characters.DataBaseCharacters;
import com.example.cthulhucompanion.database.episodes.DataBaseEpisodes;
import com.example.cthulhucompanion.database.greatoldone.DataBaseGreatOldOnes;
import com.example.cthulhucompanion.screens.common.fragmentnavigator.FragmentFrameWrapper;
import com.example.cthulhucompanion.screens.common.fragmentnavigator.FragmentNavigator;
import com.example.cthulhucompanion.screens.common.popupmanager.PopUpManager;
import com.example.cthulhucompanion.screens.fragments.attack.ControllerAttack;
import com.example.cthulhucompanion.screens.fragments.move.ControllerMove;
import com.example.cthulhucompanion.screens.activity.chooseaction.ControllerChooseAction;
import com.example.cthulhucompanion.screens.activity.endofround.ControllerEndOfRound;
import com.example.cthulhucompanion.screens.activity.fight.ControllerFight;
import com.example.cthulhucompanion.screens.activity.investigate.ControllerInvestigate;
import com.example.cthulhucompanion.screens.activity.mythosphase.ControllerMythosPhase;
import com.example.cthulhucompanion.screens.activity.setup.ControllerSetUp;
import com.example.cthulhucompanion.screens.common.ViewMvcFactory;
import com.example.cthulhucompanion.screens.common.screensnavigator.ScreensNavigator;
import com.example.cthulhucompanion.screens.fragments.rest.ControllerRest;
import com.example.cthulhucompanion.screens.fragments.trade.ControllerTrade;

public class ControllerCompositionRoot {

    private final CompositionRoot mCompositionRoot;
    private final FragmentActivity mActivity;

    public ControllerCompositionRoot(CompositionRoot mCompositionRoot, FragmentActivity mActivity) {
        this.mCompositionRoot = mCompositionRoot;
        this.mActivity = mActivity;
    }

    /** ------------------------------------- common ------------------------------------- **/

    private LayoutInflater getLayoutInflater() {
        return LayoutInflater.from(getActivity());
    }

    private Context getContext() {
        return getActivity();
    }

    private FragmentActivity getActivity() {
        return mActivity;
    }

    private FragmentManager getFragmentManager() {
        return getActivity().getSupportFragmentManager();
    }

    public ViewMvcFactory getViewMvcFactory() {
        return new ViewMvcFactory(getLayoutInflater());
    }

    public ScreensNavigator getScreensNavigator() {
        return new ScreensNavigator(getContext());
    }

    public FragmentNavigator getFragmentNavigator() {
        return new FragmentNavigator(getFragmentManager(), (FragmentFrameWrapper) getActivity());
    }

    public PopUpManager getPopUpManager() {
        return new PopUpManager(getViewMvcFactory());
    }

    public SQLiteDatabase accessReadableDataBase(){
        return mCompositionRoot.accessReadableDataBase(getContext().getApplicationContext());
    }

    /** ------------------------------------- controllers ------------------------------------- **/

    public ControllerSetUp getControllerSetUp(ScreensNavigator screensNavigator,
                                              SQLiteDatabase readableDataBase){
        return new ControllerSetUp(screensNavigator,
                readableDataBase,
                new DataBaseGreatOldOnes(),
                new DataBaseEpisodes(),
                new DataBaseCharacters(),
                getContext());
    }

    public ControllerChooseAction getControllerChooseAction(ScreensNavigator screensNavigator,
                                                            FragmentNavigator fragmentNavigator,
                                                            PopUpManager popUpManager) {
        return new ControllerChooseAction(screensNavigator, fragmentNavigator, popUpManager, getContext());
    }

    public ControllerEndOfRound getControllerEndOfRound(ScreensNavigator screensNavigator) {
        return new ControllerEndOfRound(screensNavigator, getContext());
    }

    public ControllerFight getControllerFight(ScreensNavigator screensNavigator) {
        return new ControllerFight(screensNavigator, getContext());
    }

    public ControllerInvestigate getControllerInvestigate(ScreensNavigator screensNavigator) {
        return new ControllerInvestigate(screensNavigator, getContext());
    }

    public ControllerMythosPhase getControllerMythosPhase(ScreensNavigator screensNavigator) {
        return new ControllerMythosPhase(screensNavigator, getContext());
    }

    public ControllerMove getControllerMove() {
        return new ControllerMove(getContext());
    }

    public ControllerAttack getControllerAttack() {
        return new ControllerAttack(getContext());
    }

    public ControllerRest getControllerRest() {
        return new ControllerRest(getContext());
    }

    public ControllerTrade getControllerTrade() {
        return new ControllerTrade(getContext());
    }

    /* ------------------------------------- use cases ------------------------------------- **/

    /*public GlobalExample getGlobalExample() {
        return mCompositionRoot.getGlobalExample();
    }*/
}
