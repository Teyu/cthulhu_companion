package com.example.cthulhucompanion.screens.popup.common;

public interface ObservablePopupViewMvc<ListenerType> extends ViewMvc{


    void registerListener(ListenerType listener);

    void unregisterListener(ListenerType listener);
}
