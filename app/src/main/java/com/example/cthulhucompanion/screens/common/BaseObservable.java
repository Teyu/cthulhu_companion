/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.screens.common;

import java.util.*;

public class BaseObservable<ListenerType> {

    private final Set<ListenerType> mListeners = new HashSet<>();

    public void registerListener(ListenerType listener) {
        mListeners.add(listener);
    }

    public void unregisterListener(ListenerType listener) {
        mListeners.remove(listener);
    }

    protected Set<ListenerType> getListeners(){
        return Collections.unmodifiableSet(mListeners);
    }
}
