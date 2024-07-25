/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.screens.investigate;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.cthulhucompanion.R;
import com.example.cthulhucompanion.screens.common.ViewMvcFactory;
import com.example.cthulhucompanion.screens.common.mvcviews.BaseObservableViewMvc;

public class ViewMvcInvestigateImpl extends BaseObservableViewMvc<ViewMvcInvestigate.Listener> implements ViewMvcInvestigate {

    private final Button mButtonContinue;

    public ViewMvcInvestigateImpl(LayoutInflater inflater, ViewGroup parent, ViewMvcFactory viewMvcFactory){
        setRootView(inflater.inflate(R.layout.activity_investigate, parent, false));

        this.mButtonContinue = findViewById(R.id.investigate_finish_round_btn);
        mButtonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (Listener listener : getListeners()) {
                    listener.OnContinueClicked();
                }
            }
        });
    }
}
