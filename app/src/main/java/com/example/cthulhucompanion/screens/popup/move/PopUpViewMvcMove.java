package com.example.cthulhucompanion.screens.popup.move;

import com.example.cthulhucompanion.screens.common.mvcviews.observable.ObservableViewMvc;
import com.example.cthulhucompanion.screens.popup.PopUpConfirmListener;

public interface PopUpViewMvcMove extends ObservableViewMvc<PopUpViewMvcMove.Listener> {

    interface  Listener extends PopUpConfirmListener {
    }
}
