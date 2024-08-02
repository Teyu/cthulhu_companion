package com.example.cthulhucompanion.screens.popup;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;

import com.example.cthulhucompanion.R;
import com.example.cthulhucompanion.screens.popup.common.BasePopupViewMvc;

public class ViewMvcAddPlayerImpl extends BasePopupViewMvc {

    @SuppressLint("InflateParams")
    public ViewMvcAddPlayerImpl(LayoutInflater inflater){
        setRootView(inflater.inflate(R.layout.popup_add_player, null, false));
    }
}
