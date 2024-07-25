/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.screens.toolbar.allplayerinfo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.cthulhucompanion.R;
import com.example.cthulhucompanion.screens.chooseaction.ViewMvcChooseAction;
import com.example.cthulhucompanion.screens.common.ViewMvcFactory;
import com.example.cthulhucompanion.screens.common.mvcviews.BaseObservableViewMvc;

public class ViewMvcToolbarAllPlayerInfo extends BaseObservableViewMvc<ViewMvcChooseAction.Listener> implements ViewMvcChooseAction {

    public ViewMvcToolbarAllPlayerInfo(LayoutInflater inflater, ViewGroup parent, ViewMvcFactory viewMvcFactory){
        setRootView(inflater.inflate(R.layout.toolbar_all_players_info, parent, false));
    }
}
