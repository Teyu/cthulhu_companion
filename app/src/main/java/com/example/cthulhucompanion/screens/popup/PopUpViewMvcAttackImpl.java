package com.example.cthulhucompanion.screens.popup;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;

import com.example.cthulhucompanion.R;
import com.example.cthulhucompanion.screens.common.mvcviews.BaseViewMvc;

public class PopUpViewMvcAttackImpl extends BaseViewMvc {

    @SuppressLint("InflateParams")
    public PopUpViewMvcAttackImpl(LayoutInflater inflater){
        setRootView(inflater.inflate(R.layout.popup_attack, null, false));
    }
}
