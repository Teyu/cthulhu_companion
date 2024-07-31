/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.screens.fragments.trade;

import android.content.Context;

public class ControllerTrade implements ViewMvcTrade.Listener{


    private final Context mContext;

    private ViewMvcTrade mViewTrade;

    public ControllerTrade(Context context) {
        this.mContext = context;
    }

    void onStart() {
        mViewTrade.registerListener(this);
        /*mExample.registerListener(this);*/
    }

    void onStop() {
        mViewTrade.unregisterListener(this);
        /*mExample.unregisterListener(this);*/
    }

    void bindView (ViewMvcTrade viewMvcTrade) {
        mViewTrade = viewMvcTrade;
    }

}
