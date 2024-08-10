package com.example.cthulhucompanion.screens.popup.addplayer;

import com.example.cthulhucompanion.screens.common.mvcviews.observable.ObservableViewMvc;

public interface PopUpViewMvcAddPlayer extends ObservableViewMvc<PopUpViewMvcAddPlayer.Listener> {

    interface Listener{
        void onCharacterButtonClicked(int imageResource, int buttonId);
        void onDeleteButtonClicked();
    }
    void addDeleteButton();
    void removeDeleteButton();
    void setCharacterButton(int imageResource, int buttonId);
    void removeCharacterButton(int buttonId);

    void resetCharacterButton(int buttonId);
}
