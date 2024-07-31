/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.screens.activity.fight;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toolbar;

import com.example.cthulhucompanion.R;
import com.example.cthulhucompanion.screens.common.ViewMvcFactory;
import com.example.cthulhucompanion.screens.common.mvcviews.observable.BaseObservableViewMvc;
import com.example.cthulhucompanion.screens.toolbar.allplayerinfo.ViewMvcToolbarAllPlayerInfo;

public class ViewMvcFightImpl extends BaseObservableViewMvc<ViewMvcFight.Listener> implements ViewMvcFight {

    private final Toolbar mToolbar;
    private final ViewMvcToolbarAllPlayerInfo mToolbarViewMvc;
    private final Button mButtonContinue;
    public ViewMvcFightImpl(LayoutInflater inflater, ViewGroup parent, ViewMvcFactory viewMvcFactory){
        setRootView(inflater.inflate(R.layout.activity_fight, parent, false));

        this.mButtonContinue = findViewById(R.id.fight_finish_round_btn);
        mButtonContinue.setOnClickListener(v -> {
            for (Listener listener : getListeners()) {
                listener.OnContinueClicked();
            }
        });

        mToolbar = this.findViewById(R.id.toolbar);
        mToolbarViewMvc = viewMvcFactory.getViewMvcToolbarAllPlayerInfo(mToolbar);
        mToolbar.addView(mToolbarViewMvc.getRootView());
    }
}
