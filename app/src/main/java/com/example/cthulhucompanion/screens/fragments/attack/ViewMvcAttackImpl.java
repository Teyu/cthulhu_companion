/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.screens.fragments.attack;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.cthulhucompanion.R;
import com.example.cthulhucompanion.screens.common.ViewMvcFactory;
import com.example.cthulhucompanion.screens.common.mvcviews.observable.BaseObservableViewMvc;

public class ViewMvcAttackImpl extends BaseObservableViewMvc<ViewMvcAttack.Listener> implements ViewMvcAttack {


    public ViewMvcAttackImpl(LayoutInflater inflater, ViewGroup parent, ViewMvcFactory viewMvcFactory) {
        setRootView(inflater.inflate(R.layout.frame_attack, parent, false));
    }
}
