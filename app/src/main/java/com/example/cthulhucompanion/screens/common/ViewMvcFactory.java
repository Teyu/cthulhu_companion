/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.screens.common;

import android.view.*;

import androidx.annotation.Nullable;

import com.example.cthulhucompanion.screens.chooseaction.ViewMvcChooseAction;
import com.example.cthulhucompanion.screens.chooseaction.ViewMvcChooseActionImpl;
import com.example.cthulhucompanion.screens.endofround.ViewMvcEndOfRound;
import com.example.cthulhucompanion.screens.endofround.ViewMvcEndOfRoundImpl;
import com.example.cthulhucompanion.screens.fight.ViewMvcFight;
import com.example.cthulhucompanion.screens.fight.ViewMvcFightImpl;
import com.example.cthulhucompanion.screens.investigate.ViewMvcInvestigate;
import com.example.cthulhucompanion.screens.investigate.ViewMvcInvestigateImpl;
import com.example.cthulhucompanion.screens.mythosphase.ViewMvcMythosPhase;
import com.example.cthulhucompanion.screens.mythosphase.ViewMvcMythosPhaseImpl;
import com.example.cthulhucompanion.screens.setup.ViewMvcSetUpImpl;

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
}
