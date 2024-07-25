/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.screens.endofround;

import android.os.Bundle;
import android.util.Log;

import com.example.cthulhucompanion.R;
import com.example.cthulhucompanion.screens.common.BaseActivity;

import java.util.Objects;

public class ActivityEndOfRound extends BaseActivity {

    private ControllerEndOfRound mControllerEndOfRound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_of_round);

        ViewMvcEndOfRound viewMvcEndOfRound = getCompositionRoot().getViewMvcFactory().getViewMvcEndOfRound(null);

        try {
            mControllerEndOfRound = getCompositionRoot().getControllerEndOfRound(
                    getCompositionRoot().getScreensNavigator());
        } catch (Exception e) {
            Log.i("ERROR", Objects.requireNonNull(e.getMessage()));
        }

        mControllerEndOfRound.bindView(viewMvcEndOfRound);
        setContentView(viewMvcEndOfRound.getRootView());
    }

    @Override
    protected void onStart() {
        super.onStart();
        mControllerEndOfRound.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mControllerEndOfRound.onStop();
    }
}