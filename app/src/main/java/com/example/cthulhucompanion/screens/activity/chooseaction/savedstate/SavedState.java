package com.example.cthulhucompanion.screens.activity.chooseaction.savedstate;

import java.io.Serializable;

public class SavedState implements Serializable {
    private ScreenState mScreenState;

    public enum ScreenState{
        ONE_ACTION_BUTTON_SHOWN,
        TWO_ACTION_BUTTONS_SHOWN,
        THREE_ACTION_BUTTONS_SHOWN
    }

    public ScreenState getScreenState(){
        return mScreenState;
    }

    public void setScreenState(ScreenState state){
        this.mScreenState = state;
    }

    private FragmentState mFragmentState;
    public enum FragmentState{
        DEFAULT,
        ATTACK_SHOWN,
        MOVE_SHOWN,
        REST_SHOWN,
        TRADE_SHOWN
    }

    public FragmentState getFragmentState(){
        return mFragmentState;
    }

    public void setFragmentState(FragmentState state){
        this.mFragmentState = state;
    }

    public SavedState() {
        this.mScreenState = ScreenState.ONE_ACTION_BUTTON_SHOWN;
        this.mFragmentState = FragmentState.DEFAULT;
    }
}
