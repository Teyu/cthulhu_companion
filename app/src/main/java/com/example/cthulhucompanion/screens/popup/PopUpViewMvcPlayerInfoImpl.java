package com.example.cthulhucompanion.screens.popup;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;

import com.example.cthulhucompanion.R;
import com.example.cthulhucompanion.screens.common.ViewMvcFactory;
import com.example.cthulhucompanion.screens.common.mvcviews.BaseViewMvc;

public class PopUpViewMvcPlayerInfoImpl extends BaseViewMvc {

    @SuppressLint("InflateParams")
    public PopUpViewMvcPlayerInfoImpl(LayoutInflater inflater, ViewMvcFactory viewMvcFactory){
        setRootView(inflater.inflate(R.layout.popup_player_info_mutable, null, false));
    }
}
