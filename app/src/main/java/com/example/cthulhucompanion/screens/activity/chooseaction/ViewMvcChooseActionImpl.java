/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.screens.activity.chooseaction;

import static android.view.View.GONE;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toolbar;

import com.example.cthulhucompanion.R;
import com.example.cthulhucompanion.screens.common.ViewMvcFactory;
import com.example.cthulhucompanion.screens.common.mvcviews.observable.BaseObservableViewMvc;
import com.example.cthulhucompanion.screens.toolbar.allplayerinfo.ViewMvcToolbarAllPlayerInfo;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ViewMvcChooseActionImpl extends BaseObservableViewMvc<ViewMvcChooseAction.Listener> implements ViewMvcChooseAction {

    private final Toolbar mToolbar;
    private final ViewMvcToolbarAllPlayerInfo mToolbarViewMvc;
    private final Button mButtonContinue;
    private final FloatingActionButton mButtonConfirmAction1, mButtonConfirmAction2, mButtonConfirmAction3, mButtonConfirmActionExtra;
    private final ImageButton mButtonAttack, mButtonMove, mButtonRest, mButtonTrade;

    public ViewMvcChooseActionImpl(LayoutInflater inflater, ViewGroup parent, ViewMvcFactory viewMvcFactory){
        setRootView(inflater.inflate(R.layout.activity_choose_action, parent, false));

        mButtonContinue = this.findViewById(R.id.mythos_phase_btn);
        mButtonContinue.setOnClickListener(v -> {
            for (Listener listener : getListeners()){
                listener.OnMythosPhaseClicked();
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
        mButtonTrade.setOnClickListener(v -> {
            for (Listener listener : getListeners()){
                listener.onTradeButtonClicked();
            }
        });

        mToolbar = this.findViewById(R.id.toolbar);
        mToolbarViewMvc = viewMvcFactory.getViewMvcToolbarAllPlayerInfo(mToolbar);
        mToolbar.addView(mToolbarViewMvc.getRootView());

        mButtonConfirmAction1 = this.findViewById(R.id.confirm_action1_button);
        mButtonConfirmAction1.setVisibility(View.VISIBLE);
        mButtonConfirmAction1.setOnClickListener(v -> {
            for (Listener listener : getListeners()){
                listener.onLastActionButtonClicked();
            }
        });

        mButtonConfirmAction2 = this.findViewById(R.id.confirm_action2_button);
        mButtonConfirmAction2.setVisibility(GONE);

        mButtonConfirmAction3 = this.findViewById(R.id.confirm_action3_button);
        mButtonConfirmAction3.setVisibility(GONE);

        mButtonConfirmActionExtra = this.findViewById(R.id.confirm_extra_action_button);
        mButtonConfirmActionExtra.setVisibility(GONE);
    }

    @Override
    public void addFloatingActionButton() {
        //check whether a further floating action button can be added
        if (canAddFloatingActionButton()){
            if (mButtonConfirmAction2.getVisibility() == GONE) {
                mButtonConfirmAction2.setVisibility(View.VISIBLE);
                mButtonConfirmAction2.setOnClickListener(v -> {
                    for (Listener listener : getListeners()){
                        listener.onLastActionButtonClicked();
                    }
                });
            } else if (mButtonConfirmAction3.getVisibility() == GONE){
                mButtonConfirmAction3.setVisibility(View.VISIBLE);
                mButtonConfirmAction3.setOnClickListener(v -> {
                    for (Listener listener : getListeners()){
                        listener.onLastActionButtonClicked();
                    }
                });
            }
        }
    }

    @Override
    public boolean canAddFloatingActionButton() {
        return mButtonConfirmAction3.getVisibility() == GONE;
    }
}
