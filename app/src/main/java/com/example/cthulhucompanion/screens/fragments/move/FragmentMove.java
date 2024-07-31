/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.screens.fragments.move;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.cthulhucompanion.screens.fragments.common.BaseFragment;

import java.util.Objects;

public class FragmentMove extends BaseFragment {

    private ControllerMove mControllerMove;

    public static FragmentMove getInstance(Object arg) {
        /* example:
        Bundle args = new Bundle();
        int id_constant = 123; //replace!!
        args.put ... (id_constant, arg); */
        FragmentMove fragment = FragmentMove.getInstance(null);
        //fragment.setArguments(args); --> arguments can be accessed via getArguments;
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewMvcMove viewMvcMove = getCompositionRoot().getViewMvcFactory().getViewMvcMove(null);

        try {
            mControllerMove = getCompositionRoot().getControllerMove();
        } catch (Exception e) {
            Log.i("ERROR", Objects.requireNonNull(e.getMessage()));
        }

        mControllerMove.bindView(viewMvcMove);

        return viewMvcMove.getRootView();
    }

    @Override
    public void onStart() {
        super.onStart();
        mControllerMove.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        mControllerMove.onStop();
    }

}
