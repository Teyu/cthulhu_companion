package com.example.cthulhucompanion.screens.popup;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;

import com.example.cthulhucompanion.R;
import com.example.cthulhucompanion.screens.popup.common.BaseViewMvc;

public class ViewMvcAddPlayerImpl extends BaseViewMvc {

    @SuppressLint("InflateParams")
    public ViewMvcAddPlayerImpl(LayoutInflater inflater){
        setRootView(inflater.inflate(R.layout.popup_add_player, null, false));
    }
}
