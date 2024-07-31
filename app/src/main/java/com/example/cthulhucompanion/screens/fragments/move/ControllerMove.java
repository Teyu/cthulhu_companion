/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.screens.fragments.move;

import android.content.Context;

public class ControllerMove implements ViewMvcMove.Listener{


    private final Context mContext;

    private ViewMvcMove mViewMove;

    public ControllerMove(Context context) {
        this.mContext = context;
    }

    void onStart() {
        mViewMove.registerListener(this);
        /*mExample.registerListener(this);*/
    }

    void onStop() {
        mViewMove.unregisterListener(this);
        /*mExample.unregisterListener(this);*/
    }

    void bindView (ViewMvcMove viewMvcMove) {
        mViewMove = viewMvcMove;
    }

}
