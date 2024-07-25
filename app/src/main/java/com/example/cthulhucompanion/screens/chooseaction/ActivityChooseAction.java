/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.screens.chooseaction;

import android.os.Bundle;
import android.util.Log;

import com.example.cthulhucompanion.R;
import com.example.cthulhucompanion.screens.common.BaseActivity;

import java.util.Objects;

public class ActivityChooseAction extends BaseActivity {

    private ControllerChooseAction mControllerChooseAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_action);

        ViewMvcChooseAction viewMvcChooseAction = getCompositionRoot().getViewMvcFactory().getViewMvcChooseAction(null);

        try {
            mControllerChooseAction = getCompositionRoot().getControllerChooseAction(
                    getCompositionRoot().getScreensNavigator());
        } catch (Exception e) {
            Log.i("ERROR", Objects.requireNonNull(e.getMessage()));
        }

        mControllerChooseAction.bindView(viewMvcChooseAction);
        setContentView(viewMvcChooseAction.getRootView());
    }

    @Override
    protected void onStart() {
        super.onStart();
        mControllerChooseAction.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mControllerChooseAction.onStop();
    }
}