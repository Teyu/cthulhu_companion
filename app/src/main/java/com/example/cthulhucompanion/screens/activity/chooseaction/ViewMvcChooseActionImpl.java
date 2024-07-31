/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.screens.activity.chooseaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.Toolbar;

import com.example.cthulhucompanion.R;
import com.example.cthulhucompanion.screens.common.ViewMvcFactory;
import com.example.cthulhucompanion.screens.common.mvcviews.observable.BaseObservableViewMvc;
import com.example.cthulhucompanion.screens.fragments.move.ViewMvcMove;
import com.example.cthulhucompanion.screens.toolbar.allplayerinfo.ViewMvcToolbarAllPlayerInfo;

public class ViewMvcChooseActionImpl extends BaseObservableViewMvc<ViewMvcChooseAction.Listener> implements ViewMvcChooseAction {

    private final Toolbar mToolbar;
    private final ViewMvcToolbarAllPlayerInfo mToolbarViewMvc;
    private final Button mButtonContinue;
    private final ImageButton mButtonAttack, mButtonMove, mButtonRest, mButtonTrade;

    public ViewMvcChooseActionImpl(LayoutInflater inflater, ViewGroup parent, ViewMvcFactory viewMvcFactory){
        setRootView(inflater.inflate(R.layout.activity_choose_action, parent, false));

        mButtonContinue = this.findViewById(R.id.mythos_phase_btn);
        mButtonContinue.setOnClickListener(v -> {
            for (Listener listener : getListeners()){
                listener.OnContinueClicked();
            }
        });

        mButtonMove = this.findViewById(R.id.move_btn);
        mButtonMove.setOnClickListener(v -> {
            for (Listener listener : getListeners()){
                listener.onMoveButtonClicked();
            }
        });

        mButtonAttack = this.findViewById(R.id.attack_btn);
        mButtonAttack.setOnClickListener(v -> {
            for (Listener listener : getListeners()) {
                listener.onAttackButtonClicked();
            }
        });

        mButtonRest = this.findViewById(R.id.rest_btn);
        mButtonRest.setOnClickListener(v -> {
            for (Listener listener : getListeners()){
                listener.onRestButtonClicked();
            }
        });

        mButtonTrade = this.findViewById(R.id.trade_btn);
        mButtonTrade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (Listener listener : getListeners()){
                    listener.onTradeButtonClicked();
                }
            }
        });

        mToolbar = this.findViewById(R.id.toolbar);
        mToolbarViewMvc = viewMvcFactory.getViewMvcToolbarAllPlayerInfo(mToolbar);
        mToolbar.addView(mToolbarViewMvc.getRootView());
    }
}
