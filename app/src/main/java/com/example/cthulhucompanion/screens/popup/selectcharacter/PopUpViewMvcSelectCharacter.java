package com.example.cthulhucompanion.screens.popup.selectcharacter;

import com.example.cthulhucompanion.screens.common.mvcviews.observable.ObservableViewMvc;

public interface PopUpViewMvcSelectCharacter extends ObservableViewMvc<PopUpViewMvcSelectCharacter.PopUpListener> {

    enum Character {
        AHMED_YASIN,
        BORDEN,
        ELIZABETH_IVES,
        FATIMA_SAFAR,
        JOHN_MORGAN,
        LORD_ADAM_BENCHLEY,
        RASPUTIN,
        SERGEANT_IAN_WELLES,
        SISTER_BETH,
        THE_KID
    }

    interface PopUpListener {
        void onCharacterButtonClicked(PopUpViewMvcSelectCharacterImpl.Character character);
        void onDeleteButtonClicked();
    }
    void addDeleteButton();
    void removeDeleteButton();
    void setCharacterImage(int imageResource, final PopUpViewMvcSelectCharacterImpl.Character character);
    int getCharacterImage(Character character);
    void removeCharacter(PopUpViewMvcSelectCharacterImpl.Character character);
    void showCharacter(PopUpViewMvcSelectCharacterImpl.Character character);
}
