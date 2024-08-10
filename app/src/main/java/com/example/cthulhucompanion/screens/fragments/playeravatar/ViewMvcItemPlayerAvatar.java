package com.example.cthulhucompanion.screens.fragments.playeravatar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.cthulhucompanion.R;
import com.example.cthulhucompanion.screens.common.ViewMvcFactory;
import com.example.cthulhucompanion.screens.common.mvcviews.observable.BaseObservableViewMvc;
import com.example.cthulhucompanion.screens.common.popupmanager.PopUpManager;

public class ViewMvcItemPlayerAvatar extends BaseObservableViewMvc<ViewMvcItemPlayerAvatar.Listener> {

    public interface Listener{
        void onAvatarButtonClicked();
    }

    private final ImageView mPlayerAvatarBackground;
    private final ImageButton mPlayerAvatarButton;
    private final PopUpManager mPopUpmanager;

    public ViewMvcItemPlayerAvatar(LayoutInflater inflater, ViewGroup parent, ViewMvcFactory viewMvcFactory){
        setRootView(inflater.inflate(R.layout.item_player_avatar, parent, false));

        this.mPlayerAvatarBackground = findViewById(R.id.player_color_background_img);
        this.mPlayerAvatarButton = findViewById(R.id.player_avatar_btn);
        this.mPopUpmanager = new PopUpManager(viewMvcFactory);

        mPlayerAvatarButton.setOnClickListener(v -> {
            for (Listener listener : getListeners()){
                listener.onAvatarButtonClicked();
            }
        });
    }

    public void bindAddPlayerPopUpToPlayerAvatarButton(){
        mPopUpmanager.anchorPopUpAddPlayer(mPlayerAvatarButton, null);
    }

    public void setBackgroundColor(int resourceId){
        mPlayerAvatarBackground.setBackgroundResource(resourceId);
    }
}
