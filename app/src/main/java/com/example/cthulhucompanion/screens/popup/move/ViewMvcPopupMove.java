package com.example.cthulhucompanion.screens.popup.move;


import com.example.cthulhucompanion.screens.popup.common.ObservablePopupViewMvc;

public interface ViewMvcPopupMove extends ObservablePopupViewMvc<ViewMvcPopupMove.Listener> {

    interface Listener {
        void onConfirmButtonClicked();
    }
}
