/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.screens.activity.setup;

import android.util.Pair;
import android.view.*;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Spinner;
import android.widget.Toolbar;

import com.example.cthulhucompanion.R;
import com.example.cthulhucompanion.screens.common.ViewMvcFactory;
import com.example.cthulhucompanion.screens.common.mvcviews.observable.BaseObservableViewMvc;
import com.example.cthulhucompanion.screens.common.popupmanager.PopUpManager;
import com.example.cthulhucompanion.screens.fragments.playeravatar.ViewMvcItemPlayerAvatar;
import com.example.cthulhucompanion.screens.toolbar.main.ViewMvcToolbarMain;

import java.util.ArrayList;

public class ViewMvcSetUpImpl extends BaseObservableViewMvc<ViewMvcSetUp.Listener> implements ViewMvcSetUp, ViewMvcItemPlayerAvatar.Listener {

    private final Toolbar mToolbar;
    private final ViewMvcToolbarMain mToolbarViewMvc;
    private final ArrayList<FrameLayout> mPlayerAvatars = new ArrayList<>();
    private final ArrayList<ViewMvcItemPlayerAvatar> mPlayervatarViewMvcs = new ArrayList<>();
    private final Button mButtonContinue;
    private ArrayList<PopUpManager> mAddPlayerPopUpManagers = new ArrayList<>();

    private Spinner mSpinnerChooseEpisode;
    private Spinner mSpinnerChooseGreatOldOne;

    public ViewMvcSetUpImpl(LayoutInflater inflater,
                            ViewGroup parent,
                            ViewMvcFactory viewMvcFactory){
        setRootView(inflater.inflate(R.layout.activity_set_up, parent, false));

        ArrayList<Integer> RColorsPlayer = new ArrayList<>();
        mPlayerAvatars.add(this.findViewById(R.id.element_player_avatar1));
        RColorsPlayer.add(R.color.player_blue);

        mPlayerAvatars.add(this.findViewById(R.id.element_player_avatar2));
        RColorsPlayer.add(R.color.player_green);

        mPlayerAvatars.add(this.findViewById(R.id.element_player_avatar3));
        RColorsPlayer.add(R.color.player_violet);

        mPlayerAvatars.add(this.findViewById(R.id.element_player_avatar4));
        RColorsPlayer.add(R.color.player_orange);

        mPlayerAvatars.add(this.findViewById(R.id.element_player_avatar5));
        RColorsPlayer.add(R.color.player_red);

        for (int i = 0 ; i < mPlayerAvatars.size(); i++){
            ViewMvcItemPlayerAvatar playerAvatarViewMvc = new ViewMvcItemPlayerAvatar(inflater, parent, viewMvcFactory);
            playerAvatarViewMvc.setBackgroundColor(RColorsPlayer.get(i));
            View view = playerAvatarViewMvc.getRootView();
            mPlayerAvatars.get(i).addView(view);

            mPlayervatarViewMvcs.add(playerAvatarViewMvc);
        }

        mButtonContinue = this.findViewById(R.id.continue_btn);
        mButtonContinue.setOnClickListener(v -> {
            for (Listener listener : getListeners()){
                listener.OnFinishSetUp();
            }
        });

        mToolbar = this.findViewById(R.id.toolbar);
        mToolbarViewMvc = viewMvcFactory.getViewMvcToolbarMain(mToolbar);
        mToolbar.addView(mToolbarViewMvc.getRootView());

        mSpinnerChooseEpisode = findViewById(R.id.choose_episode_list);

        mSpinnerChooseGreatOldOne = findViewById(R.id.choose_great_old_list);
    }

    @Override
    public void bindAddCharacterSelectionPopUpToPlayerColorButtons() {
        for (ViewMvcItemPlayerAvatar viewMvcItemPlayerAvatar : mPlayervatarViewMvcs){
            viewMvcItemPlayerAvatar.bindAddPlayerPopUpToPlayerAvatarButton();
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

    @Override
    public void setChooseCharacterPopUpList(ArrayList<Pair<Integer,Integer>> characterIdsImageAndButtons) {
        for (int i = 0; i < mPlayervatarViewMvcs.size(); i++){
            for (Pair<Integer, Integer> characterIdImageButton : characterIdsImageAndButtons){
                mPlayervatarViewMvcs.get(i).addCharacterToPopUpSelection(characterIdImageButton.first, characterIdImageButton.second);
            }
        }
    }

    @Override
    public void onAvatarButtonClicked() {
        for (Listener listener : getListeners()){
            listener.onPlayerColorButtonClicked(0);
        }
    }
}
