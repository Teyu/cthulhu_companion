/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.screens.chooseaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toolbar;

import com.example.cthulhucompanion.R;
import com.example.cthulhucompanion.screens.common.ViewMvcFactory;
import com.example.cthulhucompanion.screens.common.mvcviews.BaseObservableViewMvc;
import com.example.cthulhucompanion.screens.toolbar.allplayerinfo.ViewMvcToolbarAllPlayerInfo;
import com.example.cthulhucompanion.screens.toolbar.main.ViewMvcToolbarMain;

public class ViewMvcChooseActionImpl extends BaseObservableViewMvc<ViewMvcChooseAction.Listener> implements ViewMvcChooseAction {

    private final Toolbar mToolbar;
    private final ViewMvcToolbarAllPlayerInfo mToolbarViewMvc;
    private final Button mButtonContinue;

    public ViewMvcChooseActionImpl(LayoutInflater inflater, ViewGroup parent, ViewMvcFactory viewMvcFactory){
        setRootView(inflater.inflate(R.layout.activity_choose_action, parent, false));

        this.mButtonContinue = findViewById(R.id.fight_finish_round_btn);
        mButtonContinue.setOnClickListener(v -> {
            for (Listener listener : getListeners()){
                listener.OnContinueClicked();
            }
        });

        mToolbar = this.findViewById(R.id.toolbar);
        mToolbarViewMvc = viewMvcFactory.getViewMvcToolbarAllPlayerInfo(mToolbar);
        mToolbar.addView(mToolbarViewMvc.getRootView());
    }
}
