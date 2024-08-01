/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.screens.activity.chooseaction;

import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;

import com.example.cthulhucompanion.R;
import com.example.cthulhucompanion.screens.common.BaseActivity;
import com.example.cthulhucompanion.screens.common.fragmentnavigator.FragmentFrameWrapper;

import java.util.Objects;


public class ActivityChooseAction extends BaseActivity implements FragmentFrameWrapper {

    private static final String ARG_SCREEN_STATE = "screen_state";

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

        if(savedInstanceState != null){
            mControllerChooseAction.restoreScreenState(savedInstanceState.getSerializable(ARG_SCREEN_STATE));
        }
    }

    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(ARG_SCREEN_STATE,mControllerChooseAction.getScreenState());
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
        return mViewMvcChooseAction.getRootView().findViewById(R.id.include);
    }
}