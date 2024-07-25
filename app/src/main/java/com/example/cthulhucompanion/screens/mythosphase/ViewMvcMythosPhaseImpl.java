/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.screens.mythosphase;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.cthulhucompanion.R;
import com.example.cthulhucompanion.screens.common.ViewMvcFactory;
import com.example.cthulhucompanion.screens.common.mvcviews.BaseObservableViewMvc;

public class ViewMvcMythosPhaseImpl extends BaseObservableViewMvc<ViewMvcMythosPhase.Listener> implements ViewMvcMythosPhase {

    private final Button mButtonFight;
    private final Button mButtonInvestigate;

    public ViewMvcMythosPhaseImpl(LayoutInflater inflater, ViewGroup parent, ViewMvcFactory viewMvcFactory){
        setRootView(inflater.inflate(R.layout.activity_mythos_phase, parent, false));

        mButtonFight = this.findViewById(R.id.fight_btn);
        mButtonFight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (Listener listener : getListeners()){
                    listener.OnFightClicked();
                }
            }
        });

        mButtonInvestigate = this.findViewById(R.id.next_player_btn);
        mButtonInvestigate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (Listener listener : getListeners()){
                    listener.OnInvestigateClicked();
                }
            }
        });
    }
}
