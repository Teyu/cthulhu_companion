/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.screens.fragments.rest;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.cthulhucompanion.screens.fragments.common.BaseFragment;

import java.util.Objects;

public class FragmentRest extends BaseFragment {

    private ControllerRest mControllerRest;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewMvcRest viewMvcRest = getCompositionRoot().getViewMvcFactory().getViewMvcRest(null);

        try {
            mControllerRest = getCompositionRoot().getControllerRest();
        } catch (Exception e) {
            Log.i("ERROR", Objects.requireNonNull(e.getMessage()));
        }

        mControllerRest.bindView(viewMvcRest);

        return viewMvcRest.getRootView();
    }

    @Override
    public void onStart() {
        super.onStart();
        mControllerRest.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        mControllerRest.onStop();
    }
}
