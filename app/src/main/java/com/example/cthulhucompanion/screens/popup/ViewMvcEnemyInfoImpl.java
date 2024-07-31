package com.example.cthulhucompanion.screens.popup;

import android.view.LayoutInflater;

import com.example.cthulhucompanion.R;
import com.example.cthulhucompanion.screens.popup.common.BaseViewMvc;

public class ViewMvcEnemyInfoImpl extends BaseViewMvc {

    public ViewMvcEnemyInfoImpl(LayoutInflater inflater){
        setRootView(inflater.inflate(R.layout.popup_enemy_info_immutable, null, false));
    }
}
