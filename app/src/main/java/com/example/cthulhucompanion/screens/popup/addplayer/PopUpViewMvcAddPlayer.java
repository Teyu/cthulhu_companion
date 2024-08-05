package com.example.cthulhucompanion.screens.popup.addplayer;

import com.example.cthulhucompanion.screens.common.mvcviews.observable.ObservableViewMvc;
import com.example.cthulhucompanion.screens.popup.PopUpConfirmListener;

public interface PopUpViewMvcAddPlayer extends ObservableViewMvc<PopUpViewMvcAddPlayer.Listener> {
    interface Listener{
        void onAvatarClicked();
    }
}
