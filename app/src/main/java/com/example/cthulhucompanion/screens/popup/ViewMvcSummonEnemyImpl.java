package com.example.cthulhucompanion.screens.popup;

import android.view.LayoutInflater;

import com.example.cthulhucompanion.R;
import com.example.cthulhucompanion.screens.popup.common.BaseViewMvc;

public class ViewMvcSummonEnemyImpl extends BaseViewMvc {

    public ViewMvcSummonEnemyImpl(LayoutInflater inflater){
        setRootView(inflater.inflate(R.layout.popup_summon_enemy, null, false));
    }
}
