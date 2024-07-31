/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.screens.activity.investigate;

import android.os.Bundle;
import android.util.Log;

import com.example.cthulhucompanion.R;
import com.example.cthulhucompanion.screens.common.BaseActivity;

import java.util.Objects;

public class ActivityInvestigate extends BaseActivity {

    private ControllerInvestigate mControllerInvestigate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_investigate);

        ViewMvcInvestigate viewMvcInvestigate = getCompositionRoot().getViewMvcFactory().getViewMvcInvestigate(null);

        try {
            mControllerInvestigate = getCompositionRoot().getControllerInvestigate(
                    getCompositionRoot().getScreensNavigator());
        } catch (Exception e) {
            Log.i("ERROR", Objects.requireNonNull(e.getMessage()));
        }

        mControllerInvestigate.bindView(viewMvcInvestigate);
        setContentView(viewMvcInvestigate.getRootView());
    }

    @Override
    protected void onStart() {
        super.onStart();
        mControllerInvestigate.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mControllerInvestigate.onStop();
    }
}