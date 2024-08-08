/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.screens.activity.setup;

import android.util.Pair;
import android.view.*;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toolbar;

import com.example.cthulhucompanion.R;
import com.example.cthulhucompanion.screens.common.ViewMvcFactory;
import com.example.cthulhucompanion.screens.common.mvcviews.observable.BaseObservableViewMvc;
import com.example.cthulhucompanion.screens.common.popupmanager.PopUpManager;
import com.example.cthulhucompanion.screens.toolbar.main.ViewMvcToolbarMain;

import java.util.ArrayList;

public class ViewMvcSetUpImpl extends BaseObservableViewMvc<ViewMvcSetUp.Listener> implements ViewMvcSetUp {

    private final Toolbar mToolbar;
    private final ViewMvcToolbarMain mToolbarViewMvc;
    private final ArrayList<ImageButton> mChoosePlayerColorButtons = new ArrayList<>();
    private final Button mButtonContinue;
    private final ViewMvcFactory mViewMvcFactory;
    private ArrayList<PopUpManager> mAddPlayerPopUpManagers = new ArrayList<>();

    private Spinner mSpinnerChooseEpisode;
    private Spinner mSpinnerChooseGreatOldOne;

    public ViewMvcSetUpImpl(LayoutInflater inflater,
                            ViewGroup parent,
                            ViewMvcFactory viewMvcFactory){
        setRootView(inflater.inflate(R.layout.activity_set_up, parent, false));
        this.mViewMvcFactory = viewMvcFactory;

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

        ImageButton PlayerColorButton5 = findViewById(R.id.player5_color_btn);
        PlayerColorButton4.setOnClickListener(v -> {
            for (Listener listener : getListeners()){
                listener.onPlayerColorButtonClicked(4);
            }
        });
        mChoosePlayerColorButtons.add(PlayerColorButton5);

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

        mSpinnerChooseEpisode = findViewById(R.id.choose_episode_list);

        mSpinnerChooseGreatOldOne = findViewById(R.id.choose_great_old_list);
    }

    @Override
    public void bindAddPlayerPopUpsToPlayerColorButtons() {
        for (ImageButton choosePlayerColorButton : mChoosePlayerColorButtons){
            PopUpManager popUpManager = new PopUpManager(mViewMvcFactory);
            popUpManager.anchorPopUpAddPlayer(choosePlayerColorButton, () -> {
                for (Listener listener : getListeners()){
                    listener.onCharacterAvatarClicked();
                }
            });

            mAddPlayerPopUpManagers.add(popUpManager);
        }
    }

    @Override
    public void dismissAddPlayerPopUp() {
        for (PopUpManager popUpManager : mAddPlayerPopUpManagers){
            popUpManager.dismissPopUpAddPlayer();
        }
    }

    @Override
    public void setEpisodeList(final ArrayList<Pair<String, Integer>> titleAndCountPairs) {

        ArrayList<String> spinnerArray = new ArrayList<>();
        for (Pair<String, Integer> titleAndCount : titleAndCountPairs){
            spinnerArray.add("Episode " + titleAndCount.second + ": " + titleAndCount.first);
        }

        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<>(
                this.getContext(),
                android.R.layout.simple_spinner_dropdown_item,
                spinnerArray);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout
                .simple_spinner_dropdown_item);
        mSpinnerChooseEpisode.setAdapter(spinnerArrayAdapter);
    }

    @Override
    public void setGreatOldOnesList(ArrayList<String> names) {

        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<>(
                this.getContext(),
                android.R.layout.simple_spinner_dropdown_item,
                names);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout
                .simple_spinner_dropdown_item);
        mSpinnerChooseGreatOldOne.setAdapter(spinnerArrayAdapter);
    }
}
