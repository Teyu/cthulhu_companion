package com.example.cthulhucompanion.screens.popup.selectcharacter;

import com.example.cthulhucompanion.screens.activity.setup.playeravatar.ViewMvcPlayerAvatar;
import com.example.cthulhucompanion.screens.common.mvcviews.observable.ObservableViewMvc;

public interface PopUpViewMvcSelectCharacter extends ObservableViewMvc<PopUpViewMvcSelectCharacter.PopUpListener> {

    interface PopUpListener {
        void onCharacterButtonClicked(ViewMvcPlayerAvatar.Character character);
        void onDeleteButtonClicked();
    }
    void addDeleteButton();
    void removeDeleteButton();
    void setCharacterImage(int imageResource, final ViewMvcPlayerAvatar.Character character);
    int getCharacterImage(ViewMvcPlayerAvatar.Character character);
    void removeCharacter(ViewMvcPlayerAvatar.Character character);
    void showCharacter(ViewMvcPlayerAvatar.Character character);
}
