package com.example.cthulhucompanion.screens.popup;

import android.view.LayoutInflater;

import com.example.cthulhucompanion.R;
import com.example.cthulhucompanion.screens.popup.common.BaseViewMvc;

public class ViewMvcSettingsImpl extends BaseViewMvc {

    public ViewMvcSettingsImpl(LayoutInflater inflater){
        setRootView(inflater.inflate(R.layout.popup_enemy_info_mutable, null, false));
    }
}
