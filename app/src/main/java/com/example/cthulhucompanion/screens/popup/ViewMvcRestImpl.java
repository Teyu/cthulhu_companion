package com.example.cthulhucompanion.screens.popup;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;

import com.example.cthulhucompanion.R;
import com.example.cthulhucompanion.screens.popup.common.BaseViewMvc;

public class ViewMvcRestImpl extends BaseViewMvc {

    @SuppressLint("InflateParams")
    public ViewMvcRestImpl(LayoutInflater inflater){
        setRootView(inflater.inflate(R.layout.popup_rest, null, false));
    }
}
