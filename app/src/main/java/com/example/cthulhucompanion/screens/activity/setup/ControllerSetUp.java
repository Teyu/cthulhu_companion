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

    public ControllerSetUp(ScreensNavigator screensNavigator,
                           SQLiteDatabase readableDataBase,
                           DataBaseGreatOldOnes dataBaseGreatOldOnes,
                           DataBaseEpisodes dataBaseEpisodes,
                           DataBaseCharacters dataBaseCharacters,
                           Context context) {
        this.mScreensNavigator = screensNavigator;
        this.mReadableDataBase = readableDataBase;
        this.mDataBaseGreatOldOnes = dataBaseGreatOldOnes;
        this.mDataBaseEpisodes = dataBaseEpisodes;
        this.mDataBaseCharacters = dataBaseCharacters;
        this.mContext = context;
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

        mViewMvcSetUp.bindCharacterSelectionPopUp();
        for (ViewMvcSetUp.PlayerColor color : ViewMvcSetUp.PlayerColor.values()) {
            mViewMvcSetUp.setCharacterSelectionPopUp(color, characterIds);
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
    public void onCharacterClicked(ViewMvcSetUp.PlayerColor playerColor, ViewMvcPlayerAvatar.Character character) {
        ViewMvcPlayerAvatar.Character prevCharacter = mViewMvcSetUp.getSelectedCharacter(playerColor);

        //TODO: this is a use case -> unit test instead

        if (prevCharacter != ViewMvcPlayerAvatar.Character.NONE) {
            for (ViewMvcSetUp.PlayerColor player : ViewMvcSetUp.PlayerColor.values()) {
                //re-enable
                mViewMvcSetUp.enableCharacterInPopUpSelection(player, prevCharacter);
                //mViewMvcSetUp.makeCharacterDeletableInPopUpSelection(player, character, false);
                if (player != playerColor){
                    // disable for all other players:
                    mViewMvcSetUp.disableCharacterInPopUpSelection(player, character);
                }
            }
        }

        if (prevCharacter == character){ // deletes currently selected character
            mViewMvcSetUp.removePlayerAvatar(playerColor);
            for (ViewMvcSetUp.PlayerColor player : ViewMvcSetUp.PlayerColor.values()) {
                //re-enable
                mViewMvcSetUp.enableCharacterInPopUpSelection(player, prevCharacter);
                //mViewMvcSetUp.makeCharacterDeletableInPopUpSelection(player, character, false);
            }
        } else {
            mViewMvcSetUp.setPlayerAvatar(playerColor, character);

            for (ViewMvcSetUp.PlayerColor player : ViewMvcSetUp.PlayerColor.values()) {
                if (player != playerColor){
                    // disable for all other players:
                    mViewMvcSetUp.disableCharacterInPopUpSelection(player, character);
                } else {
                    //mViewMvcSetUp.disableCharacterInPopUpSelection(player, character);
                    //mViewMvcSetUp.makeCharacterDeletableInPopUpSelection(player, character, true);
                }
            }
        }

        mViewMvcSetUp.dismissPopUpAddPlayer(playerColor);
    }

    @Override
    public void onPlayerAvatarClicked(ViewMvcSetUp.PlayerColor playerColor) {
        // PopUp already bound
    }
}
