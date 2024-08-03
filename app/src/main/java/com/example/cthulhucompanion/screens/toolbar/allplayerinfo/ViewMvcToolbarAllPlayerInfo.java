/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.screens.toolbar.allplayerinfo;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.cthulhucompanion.R;
import com.example.cthulhucompanion.screens.common.ViewMvcFactory;
import com.example.cthulhucompanion.screens.common.mvcviews.BaseViewMvc;
import com.example.cthulhucompanion.screens.common.mvcviews.ViewMvc;

public class ViewMvcToolbarAllPlayerInfo extends BaseViewMvc {

    private final ImageButton mPlayerInfoButton1, mPlayerInfoButton2, mPlayerInfoButton3, mPlayerInfoButton4;
    private final ViewMvc mPlayerInfoViewMvc;

    public ViewMvcToolbarAllPlayerInfo(LayoutInflater inflater, ViewGroup parent, ViewMvcFactory viewMvcFactory){
        setRootView(inflater.inflate(R.layout.toolbar_all_players_info, parent, false));

        mPlayerInfoButton1 = this.findViewById(R.id.player1_btn);
        mPlayerInfoViewMvc = viewMvcFactory.getViewMvcPlayerInfo();

        mPlayerInfoButton2 = this.findViewById(R.id.player2_btn);

        mPlayerInfoButton3 = this.findViewById(R.id.player3_btn);

        mPlayerInfoButton4 = this.findViewById(R.id.player4_btn);
    }
}
