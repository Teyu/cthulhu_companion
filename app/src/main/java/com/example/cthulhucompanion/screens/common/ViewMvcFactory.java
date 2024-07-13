/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.screens.common;

import android.view.*;

import androidx.annotation.Nullable;

import com.example.cthulhucompanion.screens.Main.ViewMvcMainImpl;

public class ViewMvcFactory {

    private final LayoutInflater mLayoutInflater;

    public ViewMvcFactory(LayoutInflater mLayoutInflater) {
        this.mLayoutInflater = mLayoutInflater;
    }

    public ViewMvcMainImpl getViewMvcMain(@Nullable ViewGroup parent) {
        return new ViewMvcMainImpl(mLayoutInflater, parent, this);
    }
}
