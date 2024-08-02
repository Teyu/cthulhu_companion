package com.example.cthulhucompanion.screens.popup;

import android.view.LayoutInflater;

import com.example.cthulhucompanion.R;
import com.example.cthulhucompanion.screens.popup.common.BasePopupViewMvc;

public class ViewMvcEnemyInfoImpl extends BasePopupViewMvc {

    public ViewMvcEnemyInfoImpl(LayoutInflater inflater){
        setRootView(inflater.inflate(R.layout.popup_enemy_info_immutable, null, false));
    }
}
