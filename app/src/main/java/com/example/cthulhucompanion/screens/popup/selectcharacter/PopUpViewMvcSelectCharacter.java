package com.example.cthulhucompanion.screens.popup.selectcharacter;

import com.example.cthulhucompanion.screens.activity.setup.playeravatar.ViewMvcPlayerAvatar;
import com.example.cthulhucompanion.screens.common.mvcviews.observable.ObservableViewMvc;

public interface PopUpViewMvcSelectCharacter extends ObservableViewMvc<PopUpViewMvcSelectCharacter.PopUpListener> {

    interface PopUpListener {
        void onCharacterButtonClicked(ViewMvcPlayerAvatar.Character character);
    }
    void setCharacterImage(int imageResource, final ViewMvcPlayerAvatar.Character character);
    int getCharacterImage(ViewMvcPlayerAvatar.Character character);
    void disableCharacter(ViewMvcPlayerAvatar.Character character);
    void enableCharacter(ViewMvcPlayerAvatar.Character character);
    void makeCharacterDeletable(ViewMvcPlayerAvatar.Character character, boolean deletable);
    boolean contains(ViewMvcPlayerAvatar.Character character);
}
