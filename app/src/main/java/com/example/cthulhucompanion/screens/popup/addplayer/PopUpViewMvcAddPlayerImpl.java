package com.example.cthulhucompanion.screens.popup.addplayer;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;

import com.example.cthulhucompanion.R;
import com.example.cthulhucompanion.screens.common.mvcviews.observable.BaseObservableViewMvc;

public class PopUpViewMvcAddPlayerImpl extends BaseObservableViewMvc<PopUpViewMvcAddPlayer.Listener> implements PopUpViewMvcAddPlayer {


    private final ImageButton mAvatarDeleteButton;

    @SuppressLint("InflateParams")
    public PopUpViewMvcAddPlayerImpl(LayoutInflater inflater){
        setRootView(inflater.inflate(R.layout.popup_add_player, null, false));

        this.mAvatarDeleteButton = findViewById(R.id.delete_avatar_btn);
        mAvatarDeleteButton.setImageResource(R.drawable.icon_delete);
        mAvatarDeleteButton.setOnClickListener(v -> {
            for (Listener listener : getListeners()){
                listener.onDeleteButtonClicked();
            }
        });
    }

    @Override
    public void setAvatarButton(int imageResource, int buttonId){
        ImageButton characterImageButton = findViewById(buttonId);
        characterImageButton.setImageResource(imageResource);
        characterImageButton.setOnClickListener(v -> {
            for (Listener listener : getListeners()){
                listener.onCharacterButtonClicked(imageResource);
            }
        });
    }

    @Override
    public void addDeleteButton(){
        mAvatarDeleteButton.setVisibility(View.VISIBLE);
    }

    @Override
    public void removeDeleteButton(){
        mAvatarDeleteButton.setVisibility(View.GONE);
    }
}
