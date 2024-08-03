package com.example.cthulhucompanion.screens.popup;

import android.view.LayoutInflater;

import com.example.cthulhucompanion.R;
import com.example.cthulhucompanion.screens.common.mvcviews.BaseViewMvc;

public class PopUpViewMvcSettingsImpl extends BaseViewMvc {

    public PopUpViewMvcSettingsImpl(LayoutInflater inflater){
        setRootView(inflater.inflate(R.layout.popup_enemy_info_mutable, null, false));
    }
}
