/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.screens.Main;

import android.os.Bundle;
import android.util.Log;

import com.example.cthulhucompanion.R;
import com.example.cthulhucompanion.screens.common.BaseActivity;

import java.util.Objects;

public class ActivityMain extends BaseActivity {

    private ControllerMain mControllerWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewMvcMain viewMvcMain = getCompositionRoot().getViewMvcFactory().getViewMvcMain(null);

        try {
            mControllerWelcome = getCompositionRoot().getControllerMain(
                    getCompositionRoot().getScreensNavigator());
        } catch (Exception e) {
            Log.i("ERROR", Objects.requireNonNull(e.getMessage()));
        }

        mControllerWelcome.bindView(viewMvcMain);
        setContentView(viewMvcMain.getRootView());
    }

    @Override
    protected void onStart() {
        super.onStart();
        mControllerWelcome.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mControllerWelcome.onStop();
    }
}