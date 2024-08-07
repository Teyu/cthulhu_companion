/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.screens.activity.setup;

import android.content.Context;
import android.util.Pair;

import com.example.cthulhucompanion.database.episodes.DataBaseEpisodes;
import com.example.cthulhucompanion.database.episodes.WrapperEpisodeEntry;
import com.example.cthulhucompanion.screens.common.screensnavigator.ScreensNavigator;

import java.util.ArrayList;

public class ControllerSetUp implements ViewMvcSetUp.Listener{

    private final ScreensNavigator mScreensNavigator;

    private ViewMvcSetUp mViewMvcSetUp;
    private final DataBaseEpisodes mDataBaseEpisodes;
    private final Context mContext;

    public ControllerSetUp(ScreensNavigator screensNavigator, Context context) {
        this.mScreensNavigator = screensNavigator;
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

        mDataBaseEpisodes.readData(mContext);
        initializeFromDataBase();
    }

    private void initializeFromDataBase() {
        ArrayList<Pair<String, Integer>> episodesTitleAndCount = new ArrayList<>();
        for (WrapperEpisodeEntry episodeEntry : mDataBaseEpisodes.access()) {
            episodesTitleAndCount.add(new Pair<>(episodeEntry.getTitle(), episodeEntry.getCount()));
        }
        mViewMvcSetUp.setEpisodeList(episodesTitleAndCount);
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
