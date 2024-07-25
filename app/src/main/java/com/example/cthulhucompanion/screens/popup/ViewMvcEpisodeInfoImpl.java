package com.example.cthulhucompanion.screens.popup;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;

import com.example.cthulhucompanion.R;
import com.example.cthulhucompanion.screens.common.mvcviews.popup.BasePopUpViewMvc;

public class ViewMvcEpisodeInfoImpl extends BasePopUpViewMvc {

    @SuppressLint("InflateParams")
    public ViewMvcEpisodeInfoImpl(LayoutInflater inflater){
        setRootView(inflater.inflate(R.layout.popup_episode_info, null, false));
    }
}
