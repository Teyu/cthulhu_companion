/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.screens.setup;

import android.view.*;
import android.widget.Button;
import android.widget.Toolbar;

import com.example.cthulhucompanion.R;
import com.example.cthulhucompanion.screens.common.ViewMvcFactory;
import com.example.cthulhucompanion.screens.common.mvcviews.BaseObservableViewMvc;
import com.example.cthulhucompanion.screens.toolbar.main.ViewMvcToolbarMain;

public class ViewMvcSetUpImpl extends BaseObservableViewMvc<ViewMvcSetUp.Listener> implements ViewMvcSetUp {

    private final Toolbar mToolbar;
    private final ViewMvcToolbarMain mToolbarViewMvc;
    private final Button mButtonContinue;

    public ViewMvcSetUpImpl(LayoutInflater inflater, ViewGroup parent, ViewMvcFactory viewMvcFactory){
        setRootView(inflater.inflate(R.layout.activity_set_up, parent, false));

        this.mButtonContinue = findViewById(R.id.continue_btn);
        mButtonContinue.setOnClickListener(v -> {
            for (Listener listener : getListeners()){
                listener.OnFinishSetUp();
            }
        });

        mToolbar = this.findViewById(R.id.toolbar);
        mToolbarViewMvc = viewMvcFactory.getViewMvcToolbarMain(mToolbar);
        mToolbar.addView(mToolbarViewMvc.getRootView());
    }
}
