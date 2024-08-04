/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.screens.activity.setup;

import android.view.*;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toolbar;

import com.example.cthulhucompanion.R;
import com.example.cthulhucompanion.screens.common.ViewMvcFactory;
import com.example.cthulhucompanion.screens.common.mvcviews.observable.BaseObservableViewMvc;
import com.example.cthulhucompanion.screens.toolbar.main.ViewMvcToolbarMain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ViewMvcSetUpImpl extends BaseObservableViewMvc<ViewMvcSetUp.Listener> implements ViewMvcSetUp {

    private final Toolbar mToolbar;
    private final ViewMvcToolbarMain mToolbarViewMvc;
    private final ArrayList<ImageButton> mChoosePlayerColorButtons = new ArrayList<>();
    private final Button mButtonContinue;

    public ViewMvcSetUpImpl(LayoutInflater inflater,
                            ViewGroup parent,
                            ViewMvcFactory viewMvcFactory){
        setRootView(inflater.inflate(R.layout.activity_set_up, parent, false));

        ImageButton PlayerColorButton1 = findViewById(R.id.player1_color_btn);
        PlayerColorButton1.setOnClickListener(v -> {
            for (Listener listener : getListeners()){
                listener.onPlayerColorButtonClicked(0);
            }
        });
        mChoosePlayerColorButtons.add(PlayerColorButton1);

        ImageButton PlayerColorButton2 = findViewById(R.id.player2_color_btn);
        PlayerColorButton2.setOnClickListener(v -> {
            for (Listener listener : getListeners()){
                listener.onPlayerColorButtonClicked(1);
            }
        });
        mChoosePlayerColorButtons.add(PlayerColorButton2);

        ImageButton PlayerColorButton3 = findViewById(R.id.player3_color_btn);
        PlayerColorButton1.setOnClickListener(v -> {
            for (Listener listener : getListeners()){
                listener.onPlayerColorButtonClicked(2);
            }
        });
        mChoosePlayerColorButtons.add(PlayerColorButton3);

        ImageButton PlayerColorButton4 = findViewById(R.id.player4_color_btn);
        PlayerColorButton4.setOnClickListener(v -> {
            for (Listener listener : getListeners()){
                listener.onPlayerColorButtonClicked(3);
            }
        });
        mChoosePlayerColorButtons.add(PlayerColorButton4);

        mButtonContinue = this.findViewById(R.id.continue_btn);
        mButtonContinue.setOnClickListener(v -> {
            for (Listener listener : getListeners()){
                listener.OnFinishSetUp();
            }
        });
        mChoosePlayerColorButtons.add(PlayerColorButton4);

        mToolbar = this.findViewById(R.id.toolbar);
        mToolbarViewMvc = viewMvcFactory.getViewMvcToolbarMain(mToolbar);
        mToolbar.addView(mToolbarViewMvc.getRootView());
    }

    @Override
    public List<View> getAllPlayerChooseColorButtons() {
        View[] buttonsArray = new View[mChoosePlayerColorButtons.size()];
        buttonsArray = mChoosePlayerColorButtons.toArray(buttonsArray);
        return Arrays.asList(buttonsArray);
    }
}
