package com.example.cthulhucompanion.screens.popup;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;

import com.example.cthulhucompanion.R;
import com.example.cthulhucompanion.screens.popup.common.BasePopupViewMvc;

public class ViewMvcAttackImpl extends BasePopupViewMvc {

    @SuppressLint("InflateParams")
    public ViewMvcAttackImpl(LayoutInflater inflater){
        setRootView(inflater.inflate(R.layout.popup_attack, null, false));
    }
}
