package com.example.cthulhucompanion.screens.activity.setup.playeravatar;


import com.example.cthulhucompanion.screens.common.mvcviews.observable.ObservableViewMvc;

import java.util.ArrayList;

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
        void onDeleteButtonClicked();
    }

    void bindCharacterSelectionPopUp();
    void setBackgroundColor(int resourceId);
    void setAvatar(Character character);
    Character getSelectedCharacter();
    void makeAvatarEmpty();
    void addDeleteButtonToPopUpSelection(); // delegation to PopUp view mvc
    void removeDeleteButtonFromPopUpSelection(); // delegation to PopUp viewMvc
    void addCharacterToPopUpSelection(Integer imageResource, Character character);
    void showCharacterInPopUpSelection(Character character);
    void removeCharacterFromPopUpSelection(Character character);
    boolean popUpSelectionContainsCharacter(Character character);
}
