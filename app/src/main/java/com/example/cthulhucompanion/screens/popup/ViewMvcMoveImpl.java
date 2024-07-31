package com.example.cthulhucompanion.screens.popup;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;

import com.example.cthulhucompanion.R;
import com.example.cthulhucompanion.screens.popup.common.BaseViewMvc;

public class ViewMvcMoveImpl extends BaseViewMvc {

    @SuppressLint("InflateParams")
    public ViewMvcMoveImpl(LayoutInflater inflater){
        setRootView(inflater.inflate(R.layout.popup_move, null, false));
    }
}
