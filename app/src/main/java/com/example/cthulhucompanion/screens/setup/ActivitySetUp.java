/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.screens.setup;

import android.os.Bundle;
import android.util.Log;

import com.example.cthulhucompanion.R;
import com.example.cthulhucompanion.screens.common.BaseActivity;

import java.util.Objects;

public class ActivitySetUp extends BaseActivity {

    private ControllerSetUp mControllerSetUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_up);

        ViewMvcSetUp viewMvcSetUp = getCompositionRoot().getViewMvcFactory().getViewMvcSetUp(null);

        try {
            mControllerSetUp = getCompositionRoot().getControllerSetUp(
                    getCompositionRoot().getScreensNavigator());
        } catch (Exception e) {
            Log.i("ERROR", Objects.requireNonNull(e.getMessage()));
        }

        mControllerSetUp.bindView(viewMvcSetUp);
        setContentView(viewMvcSetUp.getRootView());
    }

    @Override
    protected void onStart() {
        super.onStart();
        mControllerSetUp.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mControllerSetUp.onStop();
    }
}