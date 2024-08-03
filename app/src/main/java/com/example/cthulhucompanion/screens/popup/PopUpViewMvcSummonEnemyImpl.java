package com.example.cthulhucompanion.screens.popup;

import android.view.LayoutInflater;

import com.example.cthulhucompanion.R;
import com.example.cthulhucompanion.screens.common.mvcviews.BaseViewMvc;

public class PopUpViewMvcSummonEnemyImpl extends BaseViewMvc {

    public PopUpViewMvcSummonEnemyImpl(LayoutInflater inflater){
        setRootView(inflater.inflate(R.layout.popup_summon_enemy, null, false));
    }
}
