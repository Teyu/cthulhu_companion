/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.screens.toolbar.allplayerinfo;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.cthulhucompanion.R;
import com.example.cthulhucompanion.screens.chooseaction.ViewMvcChooseAction;
import com.example.cthulhucompanion.screens.common.ViewMvcFactory;
import com.example.cthulhucompanion.screens.common.mvcviews.observable.BaseObservableViewMvc;
import com.example.cthulhucompanion.screens.common.mvcviews.popup.PopUpViewMvc;

public class ViewMvcToolbarAllPlayerInfo extends BaseObservableViewMvc<ViewMvcChooseAction.Listener> implements ViewMvcChooseAction {

    private final ImageButton mPlayerInfoButton1, mPlayerInfoButton2, mPlayerInfoButton3, mPlayerInfoButton4;
    private final PopUpViewMvc mPlayerInfoViewMvc;

    public ViewMvcToolbarAllPlayerInfo(LayoutInflater inflater, ViewGroup parent, ViewMvcFactory viewMvcFactory){
        setRootView(inflater.inflate(R.layout.toolbar_all_players_info, parent, false));

        mPlayerInfoButton1 = this.findViewById(R.id.player1_btn);
        mPlayerInfoViewMvc = viewMvcFactory.getViewMvcPlayerInfo();
        mPlayerInfoViewMvc.bindAnchorView(mPlayerInfoButton1);

        mPlayerInfoButton2 = this.findViewById(R.id.player2_btn);
        mPlayerInfoViewMvc.bindAnchorView(mPlayerInfoButton2);

        mPlayerInfoButton3 = this.findViewById(R.id.player3_btn);
        mPlayerInfoViewMvc.bindAnchorView(mPlayerInfoButton3);

        mPlayerInfoButton4 = this.findViewById(R.id.player4_btn);
        mPlayerInfoViewMvc.bindAnchorView(mPlayerInfoButton4);
    }
}
