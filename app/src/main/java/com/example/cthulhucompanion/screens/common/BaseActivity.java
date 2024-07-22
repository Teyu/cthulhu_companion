/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.screens.common;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cthulhucompanion.common.CustomApplication;
import com.example.cthulhucompanion.common.dependencyinjection.ControllerCompositionRoot;

public class BaseActivity extends AppCompatActivity {

    private ControllerCompositionRoot mCompositionRoot;

    protected ControllerCompositionRoot getCompositionRoot() {
        if (mCompositionRoot == null) {
            mCompositionRoot = new ControllerCompositionRoot(((CustomApplication) getApplication()).getCompositionRoot(), this);
        }

        return mCompositionRoot;
    }
}
