/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.screens.activity.chooseaction;

import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;

import com.example.cthulhucompanion.R;
import com.example.cthulhucompanion.screens.common.BaseActivity;
import com.example.cthulhucompanion.screens.common.fragmentnavigator.FragmentFrameWrapper;

import java.util.Objects;


public class ActivityChooseAction extends BaseActivity implements FragmentFrameWrapper {

    private ControllerChooseAction mControllerChooseAction;
    private ViewMvcChooseAction mViewMvcChooseAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_action);

        mViewMvcChooseAction = getCompositionRoot().getViewMvcFactory().getViewMvcChooseAction(null);

        try {
            mControllerChooseAction = getCompositionRoot().getControllerChooseAction(
                    getCompositionRoot().getScreensNavigator(),
                    getCompositionRoot().getFragmentNavigator());
        } catch (Exception e) {
            Log.i("ERROR", Objects.requireNonNull(e.getMessage()));
        }

        mControllerChooseAction.bindView(mViewMvcChooseAction);
        setContentView(mViewMvcChooseAction.getRootView());
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

    @Override
    public FrameLayout getFragmentFrame() {
        return (FrameLayout) mViewMvcChooseAction.getRootView().findViewById(R.id.include);
    }
}