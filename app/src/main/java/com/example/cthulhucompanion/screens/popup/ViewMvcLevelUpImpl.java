package com.example.cthulhucompanion.screens.popup;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;

import com.example.cthulhucompanion.R;
import com.example.cthulhucompanion.screens.popup.common.BaseViewMvc;

public class ViewMvcLevelUpImpl extends BaseViewMvc {

    @SuppressLint("InflateParams")
    public ViewMvcLevelUpImpl(LayoutInflater inflater){
        setRootView(inflater.inflate(R.layout.popup_level_up, null, false));
    }
}
