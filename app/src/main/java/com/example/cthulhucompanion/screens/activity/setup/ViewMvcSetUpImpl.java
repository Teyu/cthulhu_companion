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
import com.example.cthulhucompanion.screens.common.popupmanager.PopUpManager;
import com.example.cthulhucompanion.screens.popup.selectcharacter.PopUpViewMvcSelectCharacter;
import com.example.cthulhucompanion.screens.popup.selectcharacter.PopUpViewMvcSelectCharacterImpl;
import com.example.cthulhucompanion.screens.toolbar.main.ViewMvcToolbarMain;

import java.util.ArrayList;

public class ViewMvcSetUpImpl extends BaseObservableViewMvc<ViewMvcSetUp.Listener> implements ViewMvcSetUp {

    private final ArrayList<PlayerAvatar> mPlayerAvatars = new ArrayList<>();
    private final Toolbar mToolbar;
    private final ViewMvcToolbarMain mToolbarViewMvc;
    private final Button mButtonContinue;
    private Spinner mSpinnerChooseEpisode;
    private Spinner mSpinnerChooseGreatOldOne;

    public ViewMvcSetUpImpl(LayoutInflater inflater,
                            ViewGroup parent,
                            ViewMvcFactory viewMvcFactory){
        setRootView(inflater.inflate(R.layout.activity_set_up, parent, false));

        mPlayerAvatars.add(new PlayerAvatar(
                new ViewMvcPlayerAvatarImpl(inflater, parent, viewMvcFactory),
                PLAYER_BLUE,
                R.color.player_blue,
                findViewById(R.id.element_player_avatar1)
                ));

        mPlayerAvatars.add(new PlayerAvatar(
                new ViewMvcPlayerAvatarImpl(inflater, parent, viewMvcFactory),
                PLAYER_GREEN,
                R.color.player_green,
                findViewById(R.id.element_player_avatar2)
        ));

        mPlayerAvatars.add(new PlayerAvatar(
                new ViewMvcPlayerAvatarImpl(inflater, parent, viewMvcFactory),
                PLAYER_RED,
                R.color.player_red,
                findViewById(R.id.element_player_avatar3)
        ));

        mPlayerAvatars.add(new PlayerAvatar(
                new ViewMvcPlayerAvatarImpl(inflater, parent, viewMvcFactory),
                PLAYER_ORANGE,
                R.color.player_orange,
                findViewById(R.id.element_player_avatar4)
        ));

        mPlayerAvatars.add(new PlayerAvatar(
                new ViewMvcPlayerAvatarImpl(inflater, parent, viewMvcFactory),
                PLAYER_VIOLET,
                R.color.player_violet,
                findViewById(R.id.element_player_avatar5)
        ));

        for (PlayerAvatar playerAvatar : mPlayerAvatars){
            View view = playerAvatar.getViewMvc().getRootView();
            playerAvatar.getLayout().addView(view);
            playerAvatar.getViewMvc().makeAvatarEmpty();
            playerAvatar.getViewMvc().setBackgroundColor(playerAvatar.getColorResource());
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
    public void setCharacterSelectionPopUp(ArrayList<Pair<Integer, PopUpViewMvcSelectCharacterImpl.Character>> characterImageResources, PopUpViewMvcSelectCharacter.PopUpListener popUpListener) {
        for (PlayerAvatar playerAvatar : mPlayerAvatars){
            playerAvatar.getViewMvc().bindCharacterSelectionPopUp(popUpListener);
            for (Pair<Integer, PopUpViewMvcSelectCharacterImpl.Character> characterImage : characterImageResources){
                playerAvatar.getViewMvc().addCharacterToPopUpSelection(characterImage.first, characterImage.second);
            }
        }
    }

    @Override
    public void addCharacterToPopUpSelection(PopUpViewMvcSelectCharacter.Character character) {

    }

    @Override
    public void removeCharacterFromPopUpSelection(PopUpViewMvcSelectCharacter.Character character) {

    }

    @Override
    public void provideCharacterDeleteButton() {

    }

    @Override
    public void disableCharacterDeleteButton() {

    }

    @Override
    public void setPlayerAvatar(PlayerColor playerColor, PopUpViewMvcSelectCharacter.Character character) {
        for (PlayerAvatar playerAvatar : mPlayerAvatars){
            if (playerAvatar.getColor() == playerColor) {
                playerAvatar.getViewMvc().setAvatarImage(character);
                break;
            }
        }
    }

    @Override
    public void removePlayerAvatar(PlayerColor playerColor) {
        for (PlayerAvatar playerAvatar : mPlayerAvatars){
            if (playerAvatar.getColor() == playerColor){
                playerAvatar.getViewMvc().makeAvatarEmpty();
            }
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
    public void bindCharacterSelectionPopUp(PopUpManager mPopUpManagerMock) {

    }


    private class PlayerAvatar {

        private final ViewMvcPlayerAvatar mViewMvc;
        private final PlayerColor mColor;
        private final int mColorResource;
        private final FrameLayout mLayout;
        PlayerAvatar(ViewMvcPlayerAvatar viewMvc,
                     PlayerColor color,
                     int colorResource,
                     FrameLayout layout){
            this.mViewMvc = viewMvc;
            this.mColor = color;
            this.mColorResource = colorResource;
            this.mLayout = layout;
        }
        public ViewMvcPlayerAvatar getViewMvc() {
            return mViewMvc;
        }

        public PlayerColor getColor() {
            return mColor;
        }

        public int getColorResource() {
            return mColorResource;
        }

        public FrameLayout getLayout() {
            return mLayout;
        }
    }
}
