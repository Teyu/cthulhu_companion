/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.screens.mythosphase;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toolbar;

import com.example.cthulhucompanion.R;
import com.example.cthulhucompanion.screens.common.ViewMvcFactory;
import com.example.cthulhucompanion.screens.common.mvcviews.observable.BaseObservableViewMvc;
import com.example.cthulhucompanion.screens.common.mvcviews.popup.PopUpViewMvc;
import com.example.cthulhucompanion.screens.toolbar.allplayerinfo.ViewMvcToolbarAllPlayerInfo;

public class ViewMvcMythosPhaseImpl extends BaseObservableViewMvc<ViewMvcMythosPhase.Listener> implements ViewMvcMythosPhase {

    private final Toolbar mToolbar;
    private final ViewMvcToolbarAllPlayerInfo mToolbarViewMvc;
    private final Button mButtonFight;
    private final Button mButtonInvestigate;
    private final ImageButton mButtonSummonEnemy;
    private final PopUpViewMvc mViewMvcSummonEnemy;

    public ViewMvcMythosPhaseImpl(LayoutInflater inflater, ViewGroup parent, ViewMvcFactory viewMvcFactory){
        setRootView(inflater.inflate(R.layout.activity_mythos_phase, parent, false));

        mButtonFight = this.findViewById(R.id.fight_btn);
        mButtonFight.setOnClickListener(v -> {
            for (Listener listener : getListeners()){
                listener.OnFightClicked();
            }
        });

        mButtonInvestigate = this.findViewById(R.id.next_player_btn);
        mButtonInvestigate.setOnClickListener(v -> {
            for (Listener listener : getListeners()){
                listener.OnInvestigateClicked();
            }
        });

        mToolbar = this.findViewById(R.id.toolbar);
        mToolbarViewMvc = viewMvcFactory.getViewMvcToolbarAllPlayerInfo(mToolbar);
        mToolbar.addView(mToolbarViewMvc.getRootView());

        mButtonSummonEnemy = this.findViewById(R.id.summon_enemy_btn);
        mViewMvcSummonEnemy = viewMvcFactory.getViewMvcSummonEnemy();
        mViewMvcSummonEnemy.bindAnchorView(mButtonSummonEnemy);
    }
}
