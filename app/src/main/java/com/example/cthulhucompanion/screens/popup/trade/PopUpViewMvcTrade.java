package com.example.cthulhucompanion.screens.popup.trade;

import com.example.cthulhucompanion.screens.common.mvcviews.observable.ObservableViewMvc;
import com.example.cthulhucompanion.screens.popup.PopUpConfirmListener;

public interface PopUpViewMvcTrade extends ObservableViewMvc<PopUpViewMvcTrade.Listener> {
    interface Listener extends PopUpConfirmListener {
    }
}
