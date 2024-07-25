/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.screens.chooseaction;

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

public class ViewMvcChooseActionImpl extends BaseObservableViewMvc<ViewMvcChooseAction.Listener> implements ViewMvcChooseAction {

    private final Toolbar mToolbar;
    private final ViewMvcToolbarAllPlayerInfo mToolbarViewMvc;
    private final Button mButtonContinue;

    private final PopUpViewMvc mPlayerInfoViewMvc;
    private final ImageButton mButtonPlayerInfo;

    private final ImageButton mAttackButton, mRestButton, mTradeButton, mMoveButton;
    private final PopUpViewMvc mAttackViewMvc, mRestViewMvc, mTradeViewMvc, mMoveViewMvc;

    public ViewMvcChooseActionImpl(LayoutInflater inflater, ViewGroup parent, ViewMvcFactory viewMvcFactory){
        setRootView(inflater.inflate(R.layout.activity_choose_action, parent, false));

        mButtonContinue = this.findViewById(R.id.fight_finish_round_btn);
        mButtonContinue.setOnClickListener(v -> {
            for (Listener listener : getListeners()){
                listener.OnContinueClicked();
            }
        });

        mToolbar = this.findViewById(R.id.toolbar);
        mToolbarViewMvc = viewMvcFactory.getViewMvcToolbarAllPlayerInfo(mToolbar);
        mToolbar.addView(mToolbarViewMvc.getRootView());

        mButtonPlayerInfo = this.findViewById(R.id.avatar_btn);
        mPlayerInfoViewMvc = viewMvcFactory.getViewMvcPlayerInfo();
        mPlayerInfoViewMvc.bindAnchorView(mButtonPlayerInfo);

        mAttackButton = this.findViewById(R.id.attack_btn);
        mRestButton = this.findViewById(R.id.rest_btn);
        mTradeButton = this.findViewById(R.id.trade_btn);
        mMoveButton = this.findViewById(R.id.move_btn);

        mAttackViewMvc = viewMvcFactory.getViewMvcAttack();
        mRestViewMvc = viewMvcFactory.getViewMvcRest();
        mTradeViewMvc = viewMvcFactory.getViewMvcTrade();
        mMoveViewMvc = viewMvcFactory.getViewMvcMove();

        mAttackViewMvc.bindAnchorView(mAttackButton);
        mRestViewMvc.bindAnchorView(mRestButton);
        mTradeViewMvc.bindAnchorView(mTradeButton);
        mMoveViewMvc.bindAnchorView(mMoveButton);
    }
}
