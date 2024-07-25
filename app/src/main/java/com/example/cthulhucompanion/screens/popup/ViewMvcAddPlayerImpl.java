package com.example.cthulhucompanion.screens.popup;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;

import com.example.cthulhucompanion.R;
import com.example.cthulhucompanion.screens.common.mvcviews.popup.BasePopUpViewMvc;

public class ViewMvcAddPlayerImpl extends BasePopUpViewMvc {

    @SuppressLint("InflateParams")
    public ViewMvcAddPlayerImpl(LayoutInflater inflater){
        setRootView(inflater.inflate(R.layout.popup_add_player, null, false));
    }
}
