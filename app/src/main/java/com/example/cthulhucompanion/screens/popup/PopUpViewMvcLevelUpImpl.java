package com.example.cthulhucompanion.screens.popup;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;

import com.example.cthulhucompanion.R;
import com.example.cthulhucompanion.screens.common.mvcviews.BaseViewMvc;

public class PopUpViewMvcLevelUpImpl extends BaseViewMvc {

    @SuppressLint("InflateParams")
    public PopUpViewMvcLevelUpImpl(LayoutInflater inflater){
        setRootView(inflater.inflate(R.layout.popup_level_up, null, false));
    }
}
