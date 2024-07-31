/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.screens.fragments.trade;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.cthulhucompanion.screens.fragments.common.BaseFragment;

import java.util.Objects;

public class FragmentTrade extends BaseFragment {

    private ControllerTrade mControllerTrade;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewMvcTrade viewMvcTrade = getCompositionRoot().getViewMvcFactory().getViewMvcTrade(null);

        try {
            mControllerTrade = getCompositionRoot().getControllerTrade();
        } catch (Exception e) {
            Log.i("ERROR", Objects.requireNonNull(e.getMessage()));
        }

        mControllerTrade.bindView(viewMvcTrade);

        return viewMvcTrade.getRootView();
    }

    @Override
    public void onStart() {
        super.onStart();
        mControllerTrade.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        mControllerTrade.onStop();
    }
}
