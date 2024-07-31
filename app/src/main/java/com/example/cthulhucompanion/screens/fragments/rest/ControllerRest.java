/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.screens.fragments.rest;

import android.content.Context;

public class ControllerRest implements ViewMvcRest.Listener{


    private final Context mContext;

    private ViewMvcRest mViewRest;

    public ControllerRest(Context context) {
        this.mContext = context;
    }

    void onStart() {
        mViewRest.registerListener(this);
        /*mExample.registerListener(this);*/
    }

    void onStop() {
        mViewRest.unregisterListener(this);
        /*mExample.unregisterListener(this);*/
    }

    void bindView (ViewMvcRest viewMvcRest) {
        mViewRest = viewMvcRest;
    }

}
