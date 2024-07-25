package com.example.cthulhucompanion.screens.popup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import com.example.cthulhucompanion.R;
import com.example.cthulhucompanion.screens.common.mvcviews.BaseViewMvc;
import com.example.cthulhucompanion.screens.common.mvcviews.popup.BasePopUpViewMvc;

public class ViewMvcSummonEnemyImpl extends BasePopUpViewMvc {

    public ViewMvcSummonEnemyImpl(LayoutInflater inflater){
        setRootView(inflater.inflate(R.layout.popup_summon_enemy, null, false));
    }
}
