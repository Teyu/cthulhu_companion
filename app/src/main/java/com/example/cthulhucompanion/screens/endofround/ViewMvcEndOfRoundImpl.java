/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.screens.endofround;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.cthulhucompanion.R;
import com.example.cthulhucompanion.screens.common.ViewMvcFactory;
import com.example.cthulhucompanion.screens.common.mvcviews.BaseObservableViewMvc;

public class ViewMvcEndOfRoundImpl extends BaseObservableViewMvc<ViewMvcEndOfRound.Listener> implements ViewMvcEndOfRound {

    private final Button mButtonContinue;

    public ViewMvcEndOfRoundImpl(LayoutInflater inflater, ViewGroup parent, ViewMvcFactory viewMvcFactory){
        setRootView(inflater.inflate(R.layout.activity_end_of_round, parent, false));

        mButtonContinue = this.findViewById(R.id.next_player_btn);
        mButtonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (Listener listener : getListeners()){
                    listener.OnNextPlayerClicked();
                }
            }
        });
    }
}