package com.example.cthulhucompanion.screens.activity.setup.playeravatar;

import static com.example.cthulhucompanion.screens.activity.setup.playeravatar.ViewMvcPlayerAvatar.Character.NONE;

import android.view.*;
import android.widget.*;

import com.example.cthulhucompanion.R;
import com.example.cthulhucompanion.screens.common.ViewMvcFactory;
import com.example.cthulhucompanion.screens.common.mvcviews.observable.BaseObservableViewMvc;
import com.example.cthulhucompanion.screens.common.popupmanager.PopUpManager;
import com.example.cthulhucompanion.screens.popup.selectcharacter.PopUpViewMvcSelectCharacter;

import java.util.ArrayList;

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
        mPopUpViewMvc.setCharacterImage(imageResource, character);
    }

    @Override
    public void showCharacterInPopUpSelection(Character character) {
        mPopUpViewMvc.showCharacter(character);
    }

    public void removeCharacterFromPopUpSelection(Character character) {
        mPopUpViewMvc.removeCharacter(character);
    }

    @Override
    public boolean popUpSelectionContainsCharacter(Character character) {
        return mPopUpViewMvc.contains(character);
    }

    public void makeAvatarEmpty() {
        mPlayerAvatarButton.setImageResource(android.R.color.transparent);
        mPlayerAvatarButton.setImageResource(R.color.white);
        mPlayerAvatarButton.setBackgroundResource(R.color.white);
    }

    @Override
    public void addDeleteButtonToPopUpSelection() {
        mPopUpViewMvc.addDeleteButton();
    }

    @Override
    public void removeDeleteButtonFromPopUpSelection() {
        mPopUpViewMvc.removeDeleteButton();
    }

    @Override
    public void onCharacterButtonClicked(Character character) {
        for (Listener listener : getListeners()){
            listener.onCharacterButtonClicked(character);
        }
    }

    @Override
    public void onDeleteButtonClicked() {
        for (Listener listener : getListeners()){
            listener.onDeleteButtonClicked();
        }
    }
}
