package com.example.cthulhucompanion.screens.activity.setup.playeravatar;


import androidx.annotation.NonNull;

import com.example.cthulhucompanion.screens.activity.setup.ViewMvcSetUp;
import com.example.cthulhucompanion.screens.common.mvcviews.observable.ObservableViewMvc;
import com.example.cthulhucompanion.screens.popup.selectcharacter.PopUpViewMvcSelectCharacter;
import com.example.cthulhucompanion.screens.popup.selectcharacter.PopUpViewMvcSelectCharacterImpl;

public interface ViewMvcPlayerAvatar extends ObservableViewMvc<ViewMvcPlayerAvatar.Listener> {
    interface Listener{
        void onAvatarButtonClicked();
        void onCharacterButtonClicked(PopUpViewMvcSelectCharacter.Character character);
        void onDeleteButtonClicked();
    }

    void bindCharacterSelectionPopUp();
    void setBackgroundColor(int resourceId);
    void setAvatarImage(PopUpViewMvcSelectCharacter.Character character);
    void makeAvatarEmpty();
    void addDeleteButtonToPopUpSelection(); // delegation to PopUp view mvc
    void removeDeleteButtonFromPopUpSelection(); // delegation to PopUp viewMvc
    void addCharacterToPopUpSelection(Integer imageResource, PopUpViewMvcSelectCharacterImpl.Character character);
    void removeCharacterFromPopUpSelection(PopUpViewMvcSelectCharacterImpl.Character character);
}
