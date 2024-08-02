package com.example.cthulhucompanion.screens.popup;

import android.view.LayoutInflater;

import com.example.cthulhucompanion.R;
import com.example.cthulhucompanion.screens.popup.common.BasePopupViewMvc;

public class ViewMvcSummonEnemyImpl extends BasePopupViewMvc {

    public ViewMvcSummonEnemyImpl(LayoutInflater inflater){
        setRootView(inflater.inflate(R.layout.popup_summon_enemy, null, false));
    }
}
