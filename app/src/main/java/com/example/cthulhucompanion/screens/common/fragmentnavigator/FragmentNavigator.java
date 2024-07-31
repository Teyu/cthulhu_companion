package com.example.cthulhucompanion.screens.common.fragmentnavigator;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;

import com.example.cthulhucompanion.R;
import com.example.cthulhucompanion.screens.fragments.attack.FragmentAttack;
import com.example.cthulhucompanion.screens.fragments.move.FragmentMove;
import com.example.cthulhucompanion.screens.fragments.rest.FragmentRest;
import com.example.cthulhucompanion.screens.fragments.trade.FragmentTrade;

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
                    .replace(mFrameWrapper.getFragmentFrame().getId(), FragmentMove.class, null)
                    .commit();
        }
    }

    public void displayFragmentAttack(@Nullable Bundle bundle) {
        if (bundle == null) {
            mManager.beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(mFrameWrapper.getFragmentFrame().getId(), FragmentAttack.class, null)
                    .commit();
        }
    }

    public void displayFragmentRest(@Nullable Bundle bundle) {
        if (bundle == null) {
            mManager.beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(mFrameWrapper.getFragmentFrame().getId(), FragmentRest.class, null)
                    .commit();
        }
    }

    public void displayFragmentTrade(@Nullable Bundle bundle) {
        if (bundle == null) {
            mManager.beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(mFrameWrapper.getFragmentFrame().getId(), FragmentTrade.class, null)
                    .commit();
        }
    }
}
