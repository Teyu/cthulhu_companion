/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.screens.toolbar.main;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.cthulhucompanion.R;
import com.example.cthulhucompanion.screens.chooseaction.ViewMvcChooseAction;
import com.example.cthulhucompanion.screens.common.ViewMvcFactory;
import com.example.cthulhucompanion.screens.common.mvcviews.BaseObservableViewMvc;

public class ViewMvcToolbarMain extends BaseObservableViewMvc<ViewMvcChooseAction.Listener> implements ViewMvcChooseAction {

    public ViewMvcToolbarMain(LayoutInflater inflater, ViewGroup parent, ViewMvcFactory viewMvcFactory){
        setRootView(inflater.inflate(R.layout.toolbar_main, parent, false));

        //TODO: do something
    }
}
