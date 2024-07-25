/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.screens.common;

import android.view.*;

import androidx.annotation.Nullable;

import com.example.cthulhucompanion.screens.chooseaction.ViewMvcChooseAction;
import com.example.cthulhucompanion.screens.chooseaction.ViewMvcChooseActionImpl;
import com.example.cthulhucompanion.screens.common.mvcviews.popup.PopUpViewMvc;
import com.example.cthulhucompanion.screens.endofround.ViewMvcEndOfRound;
import com.example.cthulhucompanion.screens.endofround.ViewMvcEndOfRoundImpl;
import com.example.cthulhucompanion.screens.fight.ViewMvcFight;
import com.example.cthulhucompanion.screens.fight.ViewMvcFightImpl;
import com.example.cthulhucompanion.screens.investigate.ViewMvcInvestigate;
import com.example.cthulhucompanion.screens.investigate.ViewMvcInvestigateImpl;
import com.example.cthulhucompanion.screens.mythosphase.ViewMvcMythosPhase;
import com.example.cthulhucompanion.screens.mythosphase.ViewMvcMythosPhaseImpl;
import com.example.cthulhucompanion.screens.popup.ViewMvcAddPlayerImpl;
import com.example.cthulhucompanion.screens.popup.ViewMvcAttackImpl;
import com.example.cthulhucompanion.screens.popup.ViewMvcCardsImpl;
import com.example.cthulhucompanion.screens.popup.ViewMvcMoveImpl;
import com.example.cthulhucompanion.screens.popup.ViewMvcPlayerInfoImpl;
import com.example.cthulhucompanion.screens.popup.ViewMvcRestImpl;
import com.example.cthulhucompanion.screens.popup.ViewMvcSummonEnemyImpl;
import com.example.cthulhucompanion.screens.popup.ViewMvcTradeImpl;
import com.example.cthulhucompanion.screens.setup.ViewMvcSetUpImpl;
import com.example.cthulhucompanion.screens.toolbar.allplayerinfo.ViewMvcToolbarAllPlayerInfo;
import com.example.cthulhucompanion.screens.toolbar.main.ViewMvcToolbarMain;

public class ViewMvcFactory {

    private final LayoutInflater mLayoutInflater;

    public ViewMvcFactory(LayoutInflater mLayoutInflater) {
        this.mLayoutInflater = mLayoutInflater;
    }

    public ViewMvcSetUpImpl getViewMvcSetUp(@Nullable ViewGroup parent) {
        return new ViewMvcSetUpImpl(mLayoutInflater, parent, this);
    }

    public ViewMvcChooseAction getViewMvcChooseAction(@Nullable ViewGroup parent) {
        return new ViewMvcChooseActionImpl(mLayoutInflater, parent, this);
    }

    public ViewMvcEndOfRound getViewMvcEndOfRound(@Nullable ViewGroup parent) {
        return new ViewMvcEndOfRoundImpl(mLayoutInflater, parent, this);
    }

    public ViewMvcFight getViewMvcFight(@Nullable ViewGroup parent) {
        return new ViewMvcFightImpl(mLayoutInflater, parent, this);
    }

    public ViewMvcInvestigate getViewMvcInvestigate(@Nullable ViewGroup parent) {
        return new ViewMvcInvestigateImpl(mLayoutInflater, parent, this);
    }

    public ViewMvcMythosPhase getViewMythosPhase(@Nullable ViewGroup parent) {
        return new ViewMvcMythosPhaseImpl(mLayoutInflater, parent, this);
    }

    public ViewMvcToolbarMain getViewMvcToolbarMain(ViewGroup parent) {
        return new ViewMvcToolbarMain(mLayoutInflater, parent, this);
    }

    public ViewMvcToolbarAllPlayerInfo getViewMvcToolbarAllPlayerInfo(ViewGroup parent) {
        return new ViewMvcToolbarAllPlayerInfo(mLayoutInflater, parent, this);
    }

    public PopUpViewMvc getViewMvcAddPlayer() {
        return new ViewMvcAddPlayerImpl(mLayoutInflater);
    }

    public PopUpViewMvc getViewMvcPlayerInfo() {
        return new ViewMvcPlayerInfoImpl(mLayoutInflater, this);
    }

    public PopUpViewMvc getViewMvcCards() {
        return new ViewMvcCardsImpl(mLayoutInflater);
    }

    public PopUpViewMvc getViewMvcAttack() {
        return new ViewMvcAttackImpl(mLayoutInflater);
    }

    public PopUpViewMvc getViewMvcRest() {
        return new ViewMvcRestImpl(mLayoutInflater);
    }

    public PopUpViewMvc getViewMvcTrade() {
        return new ViewMvcTradeImpl(mLayoutInflater);
    }

    public PopUpViewMvc getViewMvcMove() {
        return new ViewMvcMoveImpl(mLayoutInflater);
    }

    public PopUpViewMvc getViewMvcSummonEnemy() {
        return new ViewMvcSummonEnemyImpl(mLayoutInflater);
    }
}
