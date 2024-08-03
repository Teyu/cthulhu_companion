package com.example.cthulhucompanion.screens.popup.attack;

import com.example.cthulhucompanion.screens.common.mvcviews.observable.ObservableViewMvc;
import com.example.cthulhucompanion.screens.popup.PopUpConfirmListener;

public interface PopUpViewMvcAttack extends ObservableViewMvc<PopUpViewMvcAttack.Listener> {

    interface Listener extends PopUpConfirmListener {

    }
}
