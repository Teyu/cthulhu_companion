/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.screens.fragments.rest;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.cthulhucompanion.R;
import com.example.cthulhucompanion.screens.common.ViewMvcFactory;
import com.example.cthulhucompanion.screens.common.mvcviews.observable.BaseObservableViewMvc;

public class ViewMvcRestImpl extends BaseObservableViewMvc<ViewMvcRest.Listener> implements ViewMvcRest {


    public ViewMvcRestImpl(LayoutInflater inflater, ViewGroup parent, ViewMvcFactory viewMvcFactory) {
        setRootView(inflater.inflate(R.layout.frame_save_rest, parent, false));
    }
}
