package com.example.cthulhucompanion.screens.fragments.playeravatar;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.cthulhucompanion.R;
import com.example.cthulhucompanion.screens.common.ViewMvcFactory;
import com.example.cthulhucompanion.screens.common.mvcviews.observable.BaseObservableViewMvc;
import com.example.cthulhucompanion.screens.common.popupmanager.PopUpManager;
import com.example.cthulhucompanion.screens.popup.addplayer.PopUpViewMvcAddPlayer;

public class ViewMvcItemPlayerAvatar extends BaseObservableViewMvc<ViewMvcItemPlayerAvatar.Listener> implements PopUpViewMvcAddPlayer.Listener {

    public interface Listener{
        void onAvatarButtonClicked();
    }

    private final ImageView mPlayerAvatarBackground;
    private final ImageButton mPlayerAvatarButton;
    private final PopUpManager mPopUpmanager;
    private final ViewMvcFactory mViewMvcFactory;
    private final PopUpViewMvcAddPlayer mPopUpViewMvc;

    public ViewMvcItemPlayerAvatar(LayoutInflater inflater, ViewGroup parent, ViewMvcFactory viewMvcFactory){
        setRootView(inflater.inflate(R.layout.item_player_avatar, parent, false));

        this.mPlayerAvatarBackground = findViewById(R.id.player_color_background_img);
        this.mPlayerAvatarButton = findViewById(R.id.player_avatar_btn);
        this.mViewMvcFactory = viewMvcFactory;
        this.mPopUpmanager = new PopUpManager(mViewMvcFactory);
        this.mPopUpViewMvc = viewMvcFactory.getViewMvcPopupAddPlayer();

        mPlayerAvatarButton.setOnClickListener(v -> {
            for (Listener listener : getListeners()){
                listener.onAvatarButtonClicked();
            }
        });

        mPopUpViewMvc.removeDeleteButton();
    }

    public void bindAddPlayerPopUpToPlayerAvatarButton(){
        mPopUpmanager.anchorPopUpAddPlayer(mPlayerAvatarButton, mPopUpViewMvc, this);
    }

    public void setBackgroundColor(int resourceId){
        mPlayerAvatarBackground.setBackgroundResource(resourceId);
    }

    public void addCharacterToPopUpSelection(Integer imageResource, Integer buttonId) {
        mPopUpViewMvc.setAvatarButton(imageResource, buttonId);
    }

    public void setAvatarButtonToEmpty() {
        mPlayerAvatarButton.setImageResource(android.R.color.transparent);
        mPlayerAvatarButton.setImageResource(R.color.white);
        mPlayerAvatarButton.setBackgroundResource(R.color.white);
    }

    @Override
    public void onCharacterButtonClicked(int imageResource) {
        mPlayerAvatarButton.setImageResource(imageResource);
        mPopUpmanager.dismissPopUpAddPlayer();
        mPopUpViewMvc.addDeleteButton();
    }

    @Override
    public void onDeleteButtonClicked() {
        mPopUpViewMvc.removeDeleteButton();
        setAvatarButtonToEmpty();
        mPopUpmanager.dismissPopUpAddPlayer();
    }
}
