/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.screens.common;

import android.view.*;

import androidx.annotation.Nullable;

import com.example.cthulhucompanion.screens.common.mvcviews.ViewMvc;
import com.example.cthulhucompanion.screens.fragments.attack.ViewMvcAttack;
import com.example.cthulhucompanion.screens.fragments.attack.ViewMvcAttackImpl;
import com.example.cthulhucompanion.screens.fragments.move.ViewMvcMove;
import com.example.cthulhucompanion.screens.activity.chooseaction.ViewMvcChooseAction;
import com.example.cthulhucompanion.screens.activity.chooseaction.ViewMvcChooseActionImpl;
import com.example.cthulhucompanion.screens.fragments.rest.ViewMvcRest;
import com.example.cthulhucompanion.screens.fragments.rest.ViewMvcRestImpl;
import com.example.cthulhucompanion.screens.fragments.trade.ViewMvcTrade;
import com.example.cthulhucompanion.screens.fragments.trade.ViewMvcTradeImpl;
import com.example.cthulhucompanion.screens.activity.endofround.ViewMvcEndOfRound;
import com.example.cthulhucompanion.screens.activity.endofround.ViewMvcEndOfRoundImpl;
import com.example.cthulhucompanion.screens.activity.fight.ViewMvcFight;
import com.example.cthulhucompanion.screens.activity.fight.ViewMvcFightImpl;
import com.example.cthulhucompanion.screens.activity.investigate.ViewMvcInvestigate;
import com.example.cthulhucompanion.screens.activity.investigate.ViewMvcInvestigateImpl;
import com.example.cthulhucompanion.screens.activity.mythosphase.ViewMvcMythosPhase;
import com.example.cthulhucompanion.screens.activity.mythosphase.ViewMvcMythosPhaseImpl;
import com.example.cthulhucompanion.screens.popup.attack.PopUpViewMvcAttack;
import com.example.cthulhucompanion.screens.popup.attack.PopUpViewMvcAttackImpl;
import com.example.cthulhucompanion.screens.popup.move.PopUpViewMvcMove;
import com.example.cthulhucompanion.screens.popup.move.PopUpViewMvcMoveImpl;
import com.example.cthulhucompanion.screens.popup.PopUpViewMvcPlayerInfoImpl;
import com.example.cthulhucompanion.screens.popup.rest.PopUpViewMvcRest;
import com.example.cthulhucompanion.screens.popup.rest.PopUpViewMvcRestImpl;
import com.example.cthulhucompanion.screens.activity.setup.ViewMvcSetUpImpl;
import com.example.cthulhucompanion.screens.popup.trade.PopUpViewMvcTrade;
import com.example.cthulhucompanion.screens.popup.trade.PopUpViewMvcTradeImpl;
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

    public PopUpViewMvcAttack getViewMvcPopupAttack(){
        return new PopUpViewMvcAttackImpl(mLayoutInflater);
    }

    public PopUpViewMvcMove getViewMvcPopupMove(){
        return new PopUpViewMvcMoveImpl(mLayoutInflater);
    }

    public PopUpViewMvcRest getViewMvcPopupRest(){
        return new PopUpViewMvcRestImpl(mLayoutInflater);
    }

    public PopUpViewMvcTrade getViewMvcPopupTrade(){
        return new PopUpViewMvcTradeImpl(mLayoutInflater);
    }

    public ViewMvc getViewMvcPlayerInfo() {
        return new PopUpViewMvcPlayerInfoImpl(mLayoutInflater, this);
    }

    public ViewMvcAttack getViewMvcAttack(ViewGroup parent) {
        return new ViewMvcAttackImpl(mLayoutInflater, parent, this);
    }

    public ViewMvcMove getViewMvcMove(ViewGroup parent) {
        return new com.example.cthulhucompanion.screens.fragments.move.ViewMvcMoveImpl(mLayoutInflater, parent, this);
    }

    public ViewMvcRest getViewMvcRest(ViewGroup parent) {
        return new ViewMvcRestImpl(mLayoutInflater, parent, this);
    }

    public ViewMvcTrade getViewMvcTrade(ViewGroup parent) {
        return new ViewMvcTradeImpl(mLayoutInflater, parent, this);
    }
}
