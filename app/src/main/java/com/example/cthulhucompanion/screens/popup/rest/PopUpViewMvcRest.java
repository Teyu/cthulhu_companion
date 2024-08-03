package com.example.cthulhucompanion.screens.popup.rest;

import com.example.cthulhucompanion.screens.common.mvcviews.observable.ObservableViewMvc;
import com.example.cthulhucompanion.screens.popup.PopUpConfirmListener;

public interface PopUpViewMvcRest extends ObservableViewMvc<PopUpViewMvcRest.Listener> {

    interface Listener extends PopUpConfirmListener {
    }
}
