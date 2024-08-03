package com.example.cthulhucompanion.screens.popup;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;

import com.example.cthulhucompanion.R;
import com.example.cthulhucompanion.screens.common.mvcviews.BaseViewMvc;

public class PopUpViewMvcEpisodeInfoImpl extends BaseViewMvc {

    @SuppressLint("InflateParams")
    public PopUpViewMvcEpisodeInfoImpl(LayoutInflater inflater){
        setRootView(inflater.inflate(R.layout.popup_episode_info, null, false));
    }
}
