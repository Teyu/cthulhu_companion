package com.example.cthulhucompanion.screens.popup;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;

import com.example.cthulhucompanion.R;
import com.example.cthulhucompanion.screens.common.mvcviews.BaseViewMvc;

public class PopUpViewMvcRestImpl extends BaseViewMvc {

    @SuppressLint("InflateParams")
    public PopUpViewMvcRestImpl(LayoutInflater inflater){
        setRootView(inflater.inflate(R.layout.popup_rest, null, false));
    }
}
