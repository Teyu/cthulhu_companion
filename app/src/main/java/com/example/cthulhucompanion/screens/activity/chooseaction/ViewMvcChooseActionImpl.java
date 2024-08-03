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

import java.util.ArrayList;

public class ViewMvcChooseActionImpl extends BaseObservableViewMvc<ViewMvcChooseAction.Listener> implements ViewMvcChooseAction {

    private final Toolbar mToolbar;
    private final ViewMvcToolbarAllPlayerInfo mToolbarViewMvc;
    private final Button mButtonContinue;
    private final ArrayList<FloatingActionButton> mButtonsConfirmAction = new ArrayList<>();
    private FloatingActionButton mButtonConfirmLastAction;
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

        FloatingActionButton buttonConfirmAction1 = this.findViewById(R.id.confirm_action1_button);
        buttonConfirmAction1.setVisibility(View.VISIBLE);
        mButtonConfirmLastAction = buttonConfirmAction1;
        FloatingActionButton buttonConfirmAction2 = this.findViewById(R.id.confirm_action2_button);
        buttonConfirmAction2.setVisibility(GONE);
        FloatingActionButton buttonConfirmAction3 = this.findViewById(R.id.confirm_action3_button);
        buttonConfirmAction3.setVisibility(GONE);

        mButtonsConfirmAction.add(buttonConfirmAction1);
        mButtonsConfirmAction.add(buttonConfirmAction2);
        mButtonsConfirmAction.add(buttonConfirmAction3);
    }

    @Override
    public void addActionButton() {
        if (canAddActionButton()){
            for (FloatingActionButton confirmActionButton : mButtonsConfirmAction){
                confirmActionButton.setOnClickListener(null);
            }

            for (int i = 1; i < mButtonsConfirmAction.size(); i++){
                if (mButtonsConfirmAction.get(i).getVisibility() == GONE) {
                    mButtonsConfirmAction.get(i).setVisibility(View.VISIBLE);
                    mButtonConfirmLastAction = mButtonsConfirmAction.get(i);
                    break;
                }
            }
        }
    }

    @Override
    public boolean canAddActionButton() {
        int indexOfLast = mButtonsConfirmAction.size()-1;
        return mButtonsConfirmAction.get(indexOfLast).getVisibility() == GONE;
    }

    @Override
    public View getLastActionButton() {
        return mButtonConfirmLastAction;
    }
}
