package com.example.cthulhucompanion.screens.popup.selectcharacter;

import com.example.cthulhucompanion.screens.common.mvcviews.observable.ObservableViewMvc;

public interface PopUpViewMvcSelectCharacter extends ObservableViewMvc<PopUpViewMvcSelectCharacter.Listener> {

    interface Listener{
        void onCharacterButtonClicked(PopUpViewMvcSelectCharacterImpl.Character character);
        void onDeleteButtonClicked();
    }
    void addDeleteButton();
    void removeDeleteButton();
    void setCharacterImage(int imageResource, final PopUpViewMvcSelectCharacterImpl.Character character);
    void removeCharacter(PopUpViewMvcSelectCharacterImpl.Character character);
    void showCharacter(PopUpViewMvcSelectCharacterImpl.Character character);
}
