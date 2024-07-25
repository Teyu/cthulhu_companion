/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.screens.mythosphase;

import android.os.Bundle;
import android.util.Log;

import com.example.cthulhucompanion.R;
import com.example.cthulhucompanion.screens.common.BaseActivity;

import java.util.Objects;

public class ActivityMythosPhase extends BaseActivity {

    private ControllerMythosPhase mControllerMythosPhase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mythos_phase);

        ViewMvcMythosPhase viewMvcMythosPhase = getCompositionRoot().getViewMvcFactory().getViewMythosPhase(null);

        try {
            mControllerMythosPhase = getCompositionRoot().getControllerMythosPhase(
                    getCompositionRoot().getScreensNavigator());
        } catch (Exception e) {
            Log.i("ERROR", Objects.requireNonNull(e.getMessage()));
        }

        mControllerMythosPhase.bindView(viewMvcMythosPhase);
        setContentView(viewMvcMythosPhase.getRootView());
    }

    @Override
    protected void onStart() {
        super.onStart();
        mControllerMythosPhase.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mControllerMythosPhase.onStop();
    }
}