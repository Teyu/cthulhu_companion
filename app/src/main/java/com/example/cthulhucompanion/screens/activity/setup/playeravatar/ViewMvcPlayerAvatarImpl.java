package com.example.cthulhucompanion.screens.activity.setup.playeravatar;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.example.cthulhucompanion.R;
import com.example.cthulhucompanion.screens.common.ViewMvcFactory;
import com.example.cthulhucompanion.screens.common.mvcviews.observable.BaseObservableViewMvc;
import com.example.cthulhucompanion.screens.common.popupmanager.PopUpManager;
import com.example.cthulhucompanion.screens.popup.selectcharacter.PopUpViewMvcSelectCharacter;
import com.example.cthulhucompanion.screens.popup.selectcharacter.PopUpViewMvcSelectCharacterImpl;

public class ViewMvcPlayerAvatarImpl extends BaseObservableViewMvc<ViewMvcPlayerAvatar.Listener> implements ViewMvcPlayerAvatar {

    private final ImageView mPlayerAvatarBackground;
    private final ImageButton mPlayerAvatarButton;
    private final PopUpManager mPopUpmanager;
    private final ViewMvcFactory mViewMvcFactory;
    private final PopUpViewMvcSelectCharacter mPopUpViewMvc;

    public ViewMvcPlayerAvatarImpl(LayoutInflater inflater, ViewGroup parent, ViewMvcFactory viewMvcFactory){
        setRootView(inflater.inflate(R.layout.item_player_avatar, parent, false));

        this.mPlayerAvatarBackground = findViewById(R.id.player_color_background_img);
        this.mPlayerAvatarButton = findViewById(R.id.player_avatar_btn);
        this.mViewMvcFactory = viewMvcFactory;
        this.mPopUpmanager = new PopUpManager(mViewMvcFactory);
        this.mPopUpViewMvc = viewMvcFactory.getViewMvcPopupAddPlayer();
    }

    @Override
    public void bindCharacterSelectionPopUp(@NonNull PopUpViewMvcSelectCharacter.Listener listener) {
        mPopUpmanager.anchorPopUpAddPlayer(mPlayerAvatarButton, mPopUpViewMvc, listener);
    }

    public void setBackgroundColor(int resourceId){
        mPlayerAvatarBackground.setBackgroundResource(resourceId);
    }

    @Override
    public void setAvatarImage(int resourceId) {
        mPlayerAvatarButton.setImageResource(resourceId);
    }

    public void addCharacterToPopUpSelection(Integer imageResource, PopUpViewMvcSelectCharacterImpl.Character character) {
        mPopUpViewMvc.setCharacterImage(imageResource, character);
    }

    public void removeCharacterFromPopUpSelection(PopUpViewMvcSelectCharacterImpl.Character character) {
        mPopUpViewMvc.removeCharacter(character);
    }

    public void makeAvatarEmpty() {
        mPlayerAvatarButton.setImageResource(android.R.color.transparent);
        mPlayerAvatarButton.setImageResource(R.color.white);
        mPlayerAvatarButton.setBackgroundResource(R.color.white);
    }

    @Override
    public void addDeleteButtonToPopUp() {
        mPopUpViewMvc.addDeleteButton();
    }

    @Override
    public void removeDeleteButtonFromPopUp() {
        mPopUpViewMvc.removeDeleteButton();
    }
}
