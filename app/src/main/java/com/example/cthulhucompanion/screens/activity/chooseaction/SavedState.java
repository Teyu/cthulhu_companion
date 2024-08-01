package com.example.cthulhucompanion.screens.activity.chooseaction;

import java.io.Serializable;

public class SavedState implements Serializable {

    public enum ScreenState{
        ONE_ACTION_BUTTON_SHOWN,
        TWO_ACTION_BUTTONS_SHOWN,
        THREE_ACTION_BUTTONS_SHOWN
    }
    private ScreenState mScreenState;

    public SavedState() {
        this.mScreenState = ScreenState.ONE_ACTION_BUTTON_SHOWN;
    }

    public ScreenState getState(){
        return mScreenState;
    }

    public void setState(ScreenState state){
        this.mScreenState = state;
    }
}
