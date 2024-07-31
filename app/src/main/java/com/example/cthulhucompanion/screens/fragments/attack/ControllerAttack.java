/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.screens.fragments.attack;

import android.content.Context;

public class ControllerAttack implements ViewMvcAttack.Listener{


    private final Context mContext;

    private ViewMvcAttack viewMvcAttack;

    public ControllerAttack(Context context) {
        this.mContext = context;
    }

    void onStart() {
        viewMvcAttack.registerListener(this);
        /*mExample.registerListener(this);*/
    }

    void onStop() {
        viewMvcAttack.unregisterListener(this);
        /*mExample.unregisterListener(this);*/
    }

    void bindView (ViewMvcAttack viewMvcAttack) {
        this.viewMvcAttack = viewMvcAttack;
    }

}
