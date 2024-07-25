/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.screens.fight;

import android.os.Bundle;
import android.util.Log;

import com.example.cthulhucompanion.R;
import com.example.cthulhucompanion.screens.common.BaseActivity;

import java.util.Objects;

public class ActivityFight extends BaseActivity {

    private ControllerFight mControllerFight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fight);

        ViewMvcFight viewMvcFight = getCompositionRoot().getViewMvcFactory().getViewMvcFight(null);

        try {
            mControllerFight = getCompositionRoot().getControllerFight(
                    getCompositionRoot().getScreensNavigator());
        } catch (Exception e) {
            Log.i("ERROR", Objects.requireNonNull(e.getMessage()));
        }

        mControllerFight.bindView(viewMvcFight);
        setContentView(viewMvcFight.getRootView());
    }

    @Override
    protected void onStart() {
        super.onStart();
        mControllerFight.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mControllerFight.onStop();
    }
}