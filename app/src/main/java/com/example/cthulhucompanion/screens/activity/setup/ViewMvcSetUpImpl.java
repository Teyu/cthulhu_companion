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
import com.example.cthulhucompanion.screens.toolbar.main.ViewMvcToolbarMain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class ViewMvcSetUpImpl extends BaseObservableViewMvc<ViewMvcSetUp.Listener> implements ViewMvcSetUp {

    private final HashMap<PlayerColor, PlayerAvatar> mPlayerAvatars = new HashMap<>();
    private final Toolbar mToolbar;
    private final ViewMvcToolbarMain mToolbarViewMvc;
    private final Button mButtonContinue;
    private Spinner mSpinnerChooseEpisode;
    private Spinner mSpinnerChooseGreatOldOne;

    public ViewMvcSetUpImpl(LayoutInflater inflater,
                            ViewGroup parent,
                            ViewMvcFactory viewMvcFactory){
        setRootView(inflater.inflate(R.layout.activity_set_up, parent, false));

        mPlayerAvatars.put(PLAYER_BLUE, new PlayerAvatar(
                new ViewMvcPlayerAvatarImpl(inflater, parent, viewMvcFactory),
                PLAYER_BLUE,
                R.color.player_blue,
                findViewById(R.id.element_player_avatar1),
                getListeners(), PopUpManager.create(viewMvcFactory)
                ));

        mPlayerAvatars.put(PLAYER_GREEN, new PlayerAvatar(
                new ViewMvcPlayerAvatarImpl(inflater, parent, viewMvcFactory),
                PLAYER_GREEN,
                R.color.player_green,
                findViewById(R.id.element_player_avatar2),
                getListeners(), PopUpManager.create(viewMvcFactory)
        ));

        mPlayerAvatars.put(PLAYER_RED, new PlayerAvatar(
                new ViewMvcPlayerAvatarImpl(inflater, parent, viewMvcFactory),
                PLAYER_RED,
                R.color.player_red,
                findViewById(R.id.element_player_avatar3),
                getListeners(), PopUpManager.create(viewMvcFactory)
        ));

        mPlayerAvatars.put(PLAYER_ORANGE, new PlayerAvatar(
                new ViewMvcPlayerAvatarImpl(inflater, parent, viewMvcFactory),
                PLAYER_ORANGE,
                R.color.player_orange,
                findViewById(R.id.element_player_avatar4),
                getListeners(), PopUpManager.create(viewMvcFactory)
        ));

        mPlayerAvatars.put(PLAYER_VIOLET, new PlayerAvatar(
                new ViewMvcPlayerAvatarImpl(inflater, parent, viewMvcFactory),
                PLAYER_VIOLET,
                R.color.player_violet,
                findViewById(R.id.element_player_avatar5),
                getListeners(), PopUpManager.create(viewMvcFactory)
        ));

        for (PlayerAvatar playerAvatar : mPlayerAvatars.values()){
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
    public void enableCharacterInPopUpSelection(PlayerColor playerColor, ViewMvcPlayerAvatar.Character character) {
        mPlayerAvatars.get(playerColor).getViewMvc().enableCharacterInPopUpSelection(character);
    }

    @Override
    public void disableCharacterInPopUpSelection(PlayerColor playerColor, ViewMvcPlayerAvatar.Character character) {
        mPlayerAvatars.get(playerColor).getViewMvc().disableCharacterInPopUpSelection(character);
    }

    @Override
    public void makeCharacterDeletableInPopUpSelection(PlayerColor playerColor, ViewMvcPlayerAvatar.Character character, boolean deletable) {
        mPlayerAvatars.get(playerColor).getViewMvc().makeCharacterDeletableInPopUpSelection(character, deletable);
    }

    @Override
    public boolean selectionContainsCharacter(PlayerColor playerColor, ViewMvcPlayerAvatar.Character character) {
        return mPlayerAvatars.get(playerColor).getViewMvc().popUpSelectionContainsCharacter(character);
    }

    @Override
    public void setPlayerAvatar(PlayerColor playerColor, ViewMvcPlayerAvatar.Character character) {
        mPlayerAvatars.get(playerColor).getViewMvc().setAvatar(character);
    }

    @Override
    public ViewMvcPlayerAvatar.Character getSelectedCharacter(PlayerColor playerColor) {
        return mPlayerAvatars.get(playerColor).getViewMvc().getSelectedCharacter();
    }

    @Override
    public void removePlayerAvatar(PlayerColor playerColor) {
        mPlayerAvatars.get(playerColor).getViewMvc().makeAvatarEmpty();
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
    public void bindCharacterSelectionPopUp() {
        for (PlayerAvatar playerAvatar : mPlayerAvatars.values()){
            playerAvatar.getViewMvc().bindCharacterSelectionPopUp(playerAvatar.getPopUpManager());
        }
    }

    @Override
    public void dismissPopUpAddPlayer(PlayerColor playerColor) {
        mPlayerAvatars.get(playerColor).getPopUpManager().dismissPopUpAddPlayer();
    }

    @Override
    public void setCharacterSelectionPopUp(PlayerColor color, HashMap<Integer, ViewMvcPlayerAvatar.Character> characterImageResources) {
        for (int characterImage : characterImageResources.keySet()){
            mPlayerAvatars.get(color).getViewMvc().addCharacterToPopUpSelection(characterImage, characterImageResources.get(characterImage));
        }
    }

    private class PlayerAvatar implements ViewMvcPlayerAvatar.Listener{

        private final ViewMvcPlayerAvatar mViewMvc;
        private final PlayerColor mColor;
        private final int mColorResource;
        private final FrameLayout mLayout;
        private final Set<ViewMvcSetUp.Listener> mListeners;
        private final PopUpManager mPopUpManager;

        PlayerAvatar(ViewMvcPlayerAvatar viewMvc,
                     PlayerColor color,
                     int colorResource,
                     FrameLayout layout,
                     Set<ViewMvcSetUp.Listener> listeners,
                     PopUpManager popUpManager){
            this.mViewMvc = viewMvc;
            this.mColor = color;
            this.mColorResource = colorResource;
            this.mLayout = layout;
            this.mListeners = listeners;
            this.mPopUpManager = popUpManager;

            mViewMvc.registerListener(this);
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

        public PopUpManager getPopUpManager() {
            return mPopUpManager;
        }

        @Override
        public void onAvatarButtonClicked() {
            for (ViewMvcSetUp.Listener listener : mListeners){
                listener.onPlayerAvatarClicked(mColor);
            }
        }

        @Override
        public void onCharacterButtonClicked(ViewMvcPlayerAvatar.Character character) {
            for (ViewMvcSetUp.Listener listener : mListeners){
                listener.onCharacterClicked(mColor, character);
            }
        }
    }
}
