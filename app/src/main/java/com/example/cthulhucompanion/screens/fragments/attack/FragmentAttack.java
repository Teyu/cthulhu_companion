/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.screens.fragments.attack;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.cthulhucompanion.screens.fragments.common.BaseFragment;

import java.util.Objects;

public class FragmentAttack extends BaseFragment {

    private ControllerAttack mControllerAttack;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewMvcAttack viewMvcAttack = getCompositionRoot().getViewMvcFactory().getViewMvcAttack(null);

        try {
            mControllerAttack = getCompositionRoot().getControllerAttack();
        } catch (Exception e) {
            Log.i("ERROR", Objects.requireNonNull(e.getMessage()));
        }

        mControllerAttack.bindView(viewMvcAttack);

        return viewMvcAttack.getRootView();
    }

    @Override
    public void onStart() {
        super.onStart();
        mControllerAttack.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        mControllerAttack.onStop();
    }
}
