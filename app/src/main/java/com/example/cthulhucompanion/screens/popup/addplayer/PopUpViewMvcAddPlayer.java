package com.example.cthulhucompanion.screens.popup.addplayer;

import com.example.cthulhucompanion.screens.common.mvcviews.observable.ObservableViewMvc;

public interface PopUpViewMvcAddPlayer extends ObservableViewMvc<PopUpViewMvcAddPlayer.Listener> {
    interface Listener{
        void onCharacterButtonClicked(int imageResource);
        void onDeleteButtonClicked();
    }
    void setAvatarButton(int imageResource, int buttonId);
    void addDeleteButton();
    void removeDeleteButton();
}
