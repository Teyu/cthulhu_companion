/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.screens.activity.setup;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.cthulhucompanion.database.characters.DataBaseCharacters;
import com.example.cthulhucompanion.database.characters.WrapperCharacterEntry;
import com.example.cthulhucompanion.database.episodes.DataBaseEpisodes;
import com.example.cthulhucompanion.database.greatoldone.DataBaseGreatOldOnes;
import com.example.cthulhucompanion.screens.activity.setup.playeravatar.ViewMvcPlayerAvatar;
import com.example.cthulhucompanion.screens.common.popupmanager.PopUpManager;
import com.example.cthulhucompanion.screens.common.screensnavigator.ScreensNavigator;

import java.util.HashMap;

public class ControllerSetUp implements ViewMvcSetUp.Listener{

    private final ScreensNavigator mScreensNavigator;
    private ViewMvcSetUp mViewMvcSetUp;
    private final SQLiteDatabase mReadableDataBase;
    private final DataBaseGreatOldOnes mDataBaseGreatOldOnes;
    private final DataBaseEpisodes mDataBaseEpisodes;
    private final DataBaseCharacters mDataBaseCharacters;
    private final Context mContext;

    private final PopUpManager mPopUpManager;

    public ControllerSetUp(ScreensNavigator screensNavigator,
                           SQLiteDatabase readableDataBase,
                           DataBaseGreatOldOnes dataBaseGreatOldOnes,
                           DataBaseEpisodes dataBaseEpisodes,
                           DataBaseCharacters dataBaseCharacters,
                           PopUpManager popUpManager, Context context) {
        this.mScreensNavigator = screensNavigator;
        this.mReadableDataBase = readableDataBase;
        this.mDataBaseGreatOldOnes = dataBaseGreatOldOnes;
        this.mDataBaseEpisodes = dataBaseEpisodes;
        this.mDataBaseCharacters = dataBaseCharacters;
        this.mContext = context;
        this.mPopUpManager = popUpManager;
    }

    void onStart() {
        mViewMvcSetUp.registerListener(this);
    }

    void onStop() {
        mViewMvcSetUp.unregisterListener(this);
    }

    void bindView (ViewMvcSetUp viewMvcSetUp) {
        mViewMvcSetUp = viewMvcSetUp;

        HashMap<Integer, ViewMvcPlayerAvatar.Character> characterIds = new HashMap<>();
        for (WrapperCharacterEntry characterEntry : mDataBaseCharacters.readData(mReadableDataBase)){
            characterIds.put(characterEntry.getImageResource(), characterEntry.getCharacterId());
        }

        for (ViewMvcSetUp.PlayerColor color : ViewMvcSetUp.PlayerColor.values()) {
            mViewMvcSetUp.setCharacterSelectionPopUp(color, characterIds, null);
            mViewMvcSetUp.bindCharacterSelectionPopUp(color);
        }

        initializeFromDataBase();
    }

    private void initializeFromDataBase() {

        /*ArrayList<Pair<String, Integer>> episodesTitleAndCount = new ArrayList<>();
        for (WrapperEpisodeEntry episodeEntry : mDataBaseEpisodes.readData(mReadableDataBase)) {
            episodesTitleAndCount.add(new Pair<>(episodeEntry.getTitle(), episodeEntry.getCount()));
        }
        mViewMvcSetUp.setEpisodeList(episodesTitleAndCount);

        ArrayList<String> greatOldOnes = new ArrayList<>();
        for (WrapperGreatOldOneEntry greatOldOneEntry : mDataBaseGreatOldOnes.readData(mReadableDataBase)){
            greatOldOnes.add(greatOldOneEntry.getName());
        }
        mViewMvcSetUp.setGreatOldOnesList(greatOldOnes);

        ArrayList<Pair<Integer, Integer>> characterIdsImageAndButton = new ArrayList<>();
        for (WrapperCharacterEntry characterEntry : mDataBaseCharacters.readData(mReadableDataBase)){
            characterIdsImageAndButton.add(new Pair<>(characterEntry.getImageResource(), characterEntry.getImageButtonId()));
        }

        mViewMvcSetUp.setCharacterSelectionPopUpList(characterIdsImageAndButton);*/
    }

    @Override
    public void OnFinishSetUp() {
        mScreensNavigator.toActivityChooseAction(null);
    }

    @Override
    public void onCharacterSelected(ViewMvcSetUp.PlayerColor playerColor, ViewMvcPlayerAvatar.Character character) {
        mViewMvcSetUp.setPlayerAvatar(playerColor, character);
        mViewMvcSetUp.removeCharacterFromPopUpSelection(character);
    }

    @Override
    public void onCharacterDeleted(ViewMvcSetUp.PlayerColor playerColor) {
        ViewMvcPlayerAvatar.Character selectedCharacter = mViewMvcSetUp.getSelectedCharacter(playerColor);
        mViewMvcSetUp.removePlayerAvatar(playerColor);
        mViewMvcSetUp.addCharacterToPopUpSelection(selectedCharacter);
    }

    @Override
    public void onPlayerAvatarClicked(ViewMvcSetUp.PlayerColor playerColor) {
    }
}
