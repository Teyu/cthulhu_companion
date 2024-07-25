package com.example.cthulhucompanion.screens.popup;

import android.view.LayoutInflater;

import com.example.cthulhucompanion.R;
import com.example.cthulhucompanion.screens.common.mvcviews.popup.BasePopUpViewMvc;

public class ViewMvcSettingsImpl extends BasePopUpViewMvc {

    public ViewMvcSettingsImpl(LayoutInflater inflater){
        setRootView(inflater.inflate(R.layout.popup_enemy_info_mutable, null, false));
    }
}
