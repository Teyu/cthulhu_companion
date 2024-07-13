/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.common.dependencyinjection;

import android.content.Context;
import android.view.LayoutInflater;

import androidx.fragment.app.FragmentActivity;

import com.example.cthulhucompanion.screens.Main.ControllerMain;
import com.example.cthulhucompanion.screens.common.ViewMvcFactory;
import com.example.cthulhucompanion.screens.common.screensnavigator.ScreensNavigator;

public class ControllerCompositionRoot {

    private final CompositionRoot mCompositionRoot;
    private final FragmentActivity mActivity;

    public ControllerCompositionRoot(CompositionRoot mCompositionRoot, FragmentActivity mActivity) {
        this.mCompositionRoot = mCompositionRoot;
        this.mActivity = mActivity;
    }

    /** ------------------------------------- common ------------------------------------- **/

    private LayoutInflater getLayoutInflater() {
        return LayoutInflater.from(getActivity());
    }

    private Context getContext() {
        return getActivity();
    }

    private FragmentActivity getActivity() {
        return mActivity;
    }

    public ViewMvcFactory getViewMvcFactory() {
        return new ViewMvcFactory(getLayoutInflater());
    }

    public ScreensNavigator getScreensNavigator() {
        return new ScreensNavigator(getContext());
    }

    /** ------------------------------------- controllers ------------------------------------- **/

    public ControllerMain getControllerMain(ScreensNavigator screensNavigator){
        return new ControllerMain(screensNavigator, getContext());
    }

    /** ------------------------------------- use cases ------------------------------------- **/

    /*public GlobalExample getGlobalExample() {
        return mCompositionRoot.getGlobalExample();
    }*/
}
