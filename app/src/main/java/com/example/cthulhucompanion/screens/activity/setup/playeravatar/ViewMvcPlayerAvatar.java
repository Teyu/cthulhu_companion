package com.example.cthulhucompanion.screens.activity.setup.playeravatar;


import com.example.cthulhucompanion.screens.common.mvcviews.observable.ObservableViewMvc;
import com.example.cthulhucompanion.screens.common.popupmanager.PopUpManager;

public interface ViewMvcPlayerAvatar extends ObservableViewMvc<ViewMvcPlayerAvatar.Listener> {


    enum Character {
        NONE,
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

    interface Listener{
        void onAvatarButtonClicked();
        void onCharacterButtonClicked(Character character);
    }

    void bindCharacterSelectionPopUp(PopUpManager popUpManager);
    void setBackgroundColor(int resourceId);
    void setAvatar(Character character);
    Character getSelectedCharacter();
    void makeAvatarEmpty();
    void addCharacterToPopUpSelection(Integer imageResource, Character character);
    void enableCharacterInPopUpSelection(Character character);
    void disableCharacterInPopUpSelection(Character character);
    void makeCharacterDeletableInPopUpSelection(Character character, boolean deletable);
    boolean popUpSelectionContainsCharacter(Character character);
}
