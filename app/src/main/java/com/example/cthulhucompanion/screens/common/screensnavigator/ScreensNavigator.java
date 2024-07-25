/*
 * Copyright 2020, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.screens.common.screensnavigator;

import android.content.*;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.cthulhucompanion.screens.chooseaction.ActivityChooseAction;
import com.example.cthulhucompanion.screens.endofround.ActivityEndOfRound;
import com.example.cthulhucompanion.screens.fight.ActivityFight;
import com.example.cthulhucompanion.screens.investigate.ActivityInvestigate;
import com.example.cthulhucompanion.screens.mythosphase.ActivityMythosPhase;

public class ScreensNavigator {

    private final Context mContext;

    public ScreensNavigator(Context context) {
        this.mContext = context;
    }

    public void toActivityChooseAction(@Nullable Bundle bundle) {
        Intent intent = new Intent(mContext, ActivityChooseAction.class);
        mContext.startActivity(intent, bundle);
    }

    public void toActivityEndOfRound(@Nullable Bundle bundle) {
        Intent intent = new Intent(mContext, ActivityEndOfRound.class);
        mContext.startActivity(intent, bundle);
    }

    public void toActivityFight(@Nullable Bundle bundle) {
        Intent intent = new Intent(mContext, ActivityFight.class);
        mContext.startActivity(intent, bundle);
    }

    public void toActivityInvestigate(@Nullable Bundle bundle) {
        Intent intent = new Intent(mContext, ActivityInvestigate.class);
        mContext.startActivity(intent, bundle);
    }

    public void toActivityMythosPhase(@Nullable Bundle bundle) {
        Intent intent = new Intent(mContext, ActivityMythosPhase.class);
        mContext.startActivity(intent, bundle);
    }
}
