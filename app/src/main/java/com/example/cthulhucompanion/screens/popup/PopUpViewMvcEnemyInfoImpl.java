package com.example.cthulhucompanion.screens.popup;

import android.view.LayoutInflater;

import com.example.cthulhucompanion.R;
import com.example.cthulhucompanion.screens.common.mvcviews.BaseViewMvc;

public class PopUpViewMvcEnemyInfoImpl extends BaseViewMvc {

    public PopUpViewMvcEnemyInfoImpl(LayoutInflater inflater){
        setRootView(inflater.inflate(R.layout.popup_enemy_info_immutable, null, false));
    }
}
