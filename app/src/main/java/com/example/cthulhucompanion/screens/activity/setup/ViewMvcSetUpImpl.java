/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.screens.activity.setup;

import static com.example.cthulhucompanion.screens.activity.setup.ViewMvcSetUp.PlayerColor.*;

import android.util.Pair;
import android.view.*;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Spinner;
import android.widget.Toolbar;

import com.example.cthulhucompanion.R;
import com.example.cthulhucompanion.screens.activity.setup.playeravatar.ViewMvcPlayerAvatar;
import com.example.cthulhucompanion.screens.common.ViewMvcFactory;
import com.example.cthulhucompanion.screens.common.mvcviews.observable.BaseObservableViewMvc;
import com.example.cthulhucompanion.screens.activity.setup.playeravatar.ViewMvcPlayerAvatarImpl;
import com.example.cthulhucompanion.screens.popup.selectcharacter.PopUpViewMvcSelectCharacter;
import com.example.cthulhucompanion.screens.popup.selectcharacter.PopUpViewMvcSelectCharacterImpl;
import com.example.cthulhucompanion.screens.toolbar.main.ViewMvcToolbarMain;

import java.util.ArrayList;

public class ViewMvcSetUpImpl extends BaseObservableViewMvc<ViewMvcSetUp.Listener> implements ViewMvcSetUp {

    private final Pair<PlayerColor, Integer>
            mPlayerButtonBlue = new Pair<>(PLAYER_BLUE, R.color.player_blue),
            mPlayerButtonRed = new Pair<>(PLAYER_RED, R.color.player_red),
            mPlayerButtonGreen = new Pair<>(PLAYER_GREEN, R.color.player_green),
            mPlayerButtonOrange = new Pair<>(PLAYER_ORANGE, R.color.player_orange),
            mPlayerButtonViolet = new Pair<>(PLAYER_VIOLET, R.color.player_violet);

    private final ArrayList<Pair<PlayerColor, Integer>> mPlayerColorButtons= new ArrayList<>();
    private final Toolbar mToolbar;
    private final ViewMvcToolbarMain mToolbarViewMvc;
    private final ArrayList<FrameLayout> mPlayerAvatars = new ArrayList<>();
    private final ArrayList<ViewMvcPlayerAvatar> mPlayerAvatarViewMvcs = new ArrayList<>();
    private final Button mButtonContinue;
    private Spinner mSpinnerChooseEpisode;
    private Spinner mSpinnerChooseGreatOldOne;

    public ViewMvcSetUpImpl(LayoutInflater inflater,
                            ViewGroup parent,
                            ViewMvcFactory viewMvcFactory){
        setRootView(inflater.inflate(R.layout.activity_set_up, parent, false));

        mPlayerAvatars.add(this.findViewById(R.id.element_player_avatar1));
        mPlayerAvatars.add(this.findViewById(R.id.element_player_avatar2));
        mPlayerAvatars.add(this.findViewById(R.id.element_player_avatar3));
        mPlayerAvatars.add(this.findViewById(R.id.element_player_avatar4));
        mPlayerAvatars.add(this.findViewById(R.id.element_player_avatar5));

        mPlayerColorButtons.add(mPlayerButtonBlue);
        mPlayerColorButtons.add(mPlayerButtonRed);
        mPlayerColorButtons.add(mPlayerButtonGreen);
        mPlayerColorButtons.add(mPlayerButtonOrange);
        mPlayerColorButtons.add(mPlayerButtonViolet);

        //TODO: create a class containing viewmvcs, colorButtons, frameLayouts
        for (int i = 0 ; i < mPlayerAvatars.size(); i++){
            ViewMvcPlayerAvatarImpl playerAvatarViewMvc = new ViewMvcPlayerAvatarImpl(inflater, parent, viewMvcFactory);
            playerAvatarViewMvc.setBackgroundColor(mPlayerColorButtons.get(i).second);
            View view = playerAvatarViewMvc.getRootView();
            mPlayerAvatars.get(i).addView(view);

            mPlayerAvatarViewMvcs.add(playerAvatarViewMvc);
        }

        for (ViewMvcPlayerAvatar playerAvatarViewMvc : mPlayerAvatarViewMvcs){
            playerAvatarViewMvc.makeAvatarEmpty();
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
    public void setCharacterSelectionPopUpList(ArrayList<Pair<Integer, PopUpViewMvcSelectCharacterImpl.Character>> characterImages, PopUpViewMvcSelectCharacter.Listener listener) {
        for (ViewMvcPlayerAvatar viewMvcPlayerAvatar : mPlayerAvatarViewMvcs){
            //TODO: delegation of listener no good -> use event bus or something
            viewMvcPlayerAvatar.bindCharacterSelectionPopUp(listener);
            for (Pair<Integer, PopUpViewMvcSelectCharacterImpl.Character> characterImage : characterImages){
                viewMvcPlayerAvatar.addCharacterToPopUpSelection(characterImage.first, characterImage.second);
            }
            //viewMvcPlayerAvatar.registerListener(this);
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
