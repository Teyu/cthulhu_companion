package com.example.cthulhucompanion.screens.popup.move;

import com.example.cthulhucompanion.screens.common.mvcviews.observable.ObservableViewMvc;

public interface PopUpViewMvcMove extends ObservableViewMvc<PopUpViewMvcMove.Listener> {

    interface  Listener{
        void onConfirmButtonClicked();
    }
}
