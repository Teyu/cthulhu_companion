package com.example.cthulhucompanion.screens.common.fragmentnavigator;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;

import com.example.cthulhucompanion.R;
import com.example.cthulhucompanion.screens.fragments.move.FragmentMove;

public class FragmentNavigator {

    private final FragmentManager mManager;
    private final FragmentFrameWrapper mFrameWrapper;

    public FragmentNavigator(FragmentManager manager, FragmentFrameWrapper frameWrapper) {
        this.mManager = manager;
        this.mFrameWrapper = frameWrapper;
    }

    public void displayFragmentMove(@Nullable Bundle bundle) {
        if (bundle == null) {
            mManager.beginTransaction()
                    .setReorderingAllowed(true)
                    .add(mFrameWrapper.getFragmentFrame().getId(), FragmentMove.class, null)
                    .commit();
        }
    }
}
