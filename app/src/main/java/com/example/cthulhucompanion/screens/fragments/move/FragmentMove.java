/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.screens.fragments.move;

import android.os.Bundle;
import android.util.Log;
import android.view.*;

import androidx.annotation.*;

import com.example.cthulhucompanion.screens.fragments.common.BaseFragment;

import java.util.Objects;

public class FragmentMove extends BaseFragment {

    private ControllerMove mControllerMove;

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
