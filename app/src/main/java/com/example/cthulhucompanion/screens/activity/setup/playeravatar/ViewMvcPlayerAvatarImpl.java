package com.example.cthulhucompanion.screens.activity.setup.playeravatar;

import static com.example.cthulhucompanion.screens.activity.setup.playeravatar.ViewMvcPlayerAvatar.Character.NONE;

import android.view.*;
import android.widget.*;

import com.example.cthulhucompanion.R;
import com.example.cthulhucompanion.screens.common.ViewMvcFactory;
import com.example.cthulhucompanion.screens.common.mvcviews.observable.BaseObservableViewMvc;
import com.example.cthulhucompanion.screens.common.popupmanager.PopUpManager;
import com.example.cthulhucompanion.screens.popup.selectcharacter.PopUpViewMvcSelectCharacter;

public class ViewMvcPlayerAvatarImpl extends BaseObservableViewMvc<ViewMvcPlayerAvatar.Listener> implements ViewMvcPlayerAvatar, PopUpViewMvcSelectCharacter.PopUpListener {

    private final ImageView mPlayerAvatarBackground;
    private final ImageButton mPlayerAvatarButton;
    private final PopUpViewMvcSelectCharacter mPopUpViewMvc;
    private Character mSelectedCharacter = NONE;

    public ViewMvcPlayerAvatarImpl(LayoutInflater inflater, ViewGroup parent, ViewMvcFactory viewMvcFactory){
        setRootView(inflater.inflate(R.layout.item_player_avatar, parent, false));

        this.mPlayerAvatarBackground = findViewById(R.id.player_color_background_img);
        this.mPlayerAvatarButton = findViewById(R.id.player_avatar_btn);
        this.mPopUpViewMvc = viewMvcFactory.getViewMvcPopupSelectPlayer();

        mPlayerAvatarButton.setOnClickListener(
                v -> {
                    for (Listener listener: getListeners()){
                        listener.onAvatarButtonClicked();
                    }
                }
        );
    }

    @Override
    public void bindCharacterSelectionPopUp(PopUpManager popUpManager) {
        popUpManager.anchorPopUpAddPlayer(mPlayerAvatarButton, mPopUpViewMvc, this);
    }

    public void setBackgroundColor(int resourceId){
        mPlayerAvatarBackground.setBackgroundResource(resourceId);
    }

    @Override
    public void setAvatar(Character character) {
        int imageResource = mPopUpViewMvc.getCharacterImage(character);
        mPlayerAvatarButton.setImageResource(imageResource);
        mSelectedCharacter = character;
    }

    @Override
    public Character getSelectedCharacter() {
        return mSelectedCharacter;
    }

    public void addCharacterToPopUpSelection(Integer imageResource, Character character) {
        //mPopUpViewMvc.setCharacterImage(imageResource, character);
        mPopUpViewMvc.setCharacterImage(imageResource, character);
    }

    @Override
    public void enableCharacterInPopUpSelection(Character character) {
        mPopUpViewMvc.enableCharacter(character);
    }

    public void disableCharacterInPopUpSelection(Character character) {
        mPopUpViewMvc.disableCharacter(character);
    }

    @Override
    public void makeCharacterDeletableInPopUpSelection(Character character, boolean deletable) {
        mPopUpViewMvc.makeCharacterDeletable(character, deletable);
    }

    @Override
    public boolean popUpSelectionContainsCharacter(Character character) {
        return mPopUpViewMvc.contains(character);
    }

    public void makeAvatarEmpty() {
        mPlayerAvatarButton.setImageResource(android.R.color.transparent);
        mPlayerAvatarButton.setImageResource(R.color.white);
        mPlayerAvatarButton.setBackgroundResource(R.color.white);
        mSelectedCharacter = NONE;
    }

    @Override
    public void onCharacterButtonClicked(Character character) {
        for (Listener listener : getListeners()){
            listener.onCharacterButtonClicked(character);
        }
    }
}
