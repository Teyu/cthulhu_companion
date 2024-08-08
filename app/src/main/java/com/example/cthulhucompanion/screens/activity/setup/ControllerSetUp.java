/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.screens.activity.setup;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Pair;

import com.example.cthulhucompanion.database.episodes.DataBaseEpisodes;
import com.example.cthulhucompanion.database.episodes.WrapperEpisodeEntry;
import com.example.cthulhucompanion.database.greatoldone.DataBaseGreatOldOnes;
import com.example.cthulhucompanion.database.greatoldone.WrapperGreatOldOneEntry;
import com.example.cthulhucompanion.screens.common.screensnavigator.ScreensNavigator;

import java.util.ArrayList;

public class ControllerSetUp implements ViewMvcSetUp.Listener{

    private final ScreensNavigator mScreensNavigator;

    private ViewMvcSetUp mViewMvcSetUp;
    private final SQLiteDatabase mReadableDataBase;
    private final DataBaseGreatOldOnes mDataBaseGreatOldOnes;
    private final DataBaseEpisodes mDataBaseEpisodes;
    private final Context mContext;

    public ControllerSetUp(ScreensNavigator screensNavigator, SQLiteDatabase readableDataBase, Context context) {
        this.mScreensNavigator = screensNavigator;
        this.mReadableDataBase = readableDataBase;
        this.mDataBaseGreatOldOnes = new DataBaseGreatOldOnes();
        this.mDataBaseEpisodes = new DataBaseEpisodes();
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

        mViewMvcSetUp.bindAddPlayerPopUpsToPlayerColorButtons();

        initializeFromDataBase();
    }

    private void initializeFromDataBase() {

        ArrayList<Pair<String, Integer>> episodesTitleAndCount = new ArrayList<>();
        for (WrapperEpisodeEntry episodeEntry : mDataBaseEpisodes.readData(mReadableDataBase)) {
            episodesTitleAndCount.add(new Pair<>(episodeEntry.getTitle(), episodeEntry.getCount()));
        }
        mViewMvcSetUp.setEpisodeList(episodesTitleAndCount);

        ArrayList<String> greatOldOnes = new ArrayList<>();
        for (WrapperGreatOldOneEntry greatOldOneEntry : mDataBaseGreatOldOnes.readData(mReadableDataBase)){
            greatOldOnes.add(greatOldOneEntry.getName());
        }
        mViewMvcSetUp.setGreatOldOnesList(greatOldOnes);
    }

    @Override
    public void OnFinishSetUp() {
        mScreensNavigator.toActivityChooseAction(null);
    }

    @Override
    public void onPlayerColorButtonClicked(int position) {
    }

    @Override
    public void onCharacterAvatarClicked() {
        mViewMvcSetUp.dismissAddPlayerPopUp();
    }
}
