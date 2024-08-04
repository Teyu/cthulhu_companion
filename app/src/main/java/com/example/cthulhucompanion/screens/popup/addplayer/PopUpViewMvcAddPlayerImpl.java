package com.example.cthulhucompanion.screens.popup.addplayer;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;

import com.example.cthulhucompanion.R;
import com.example.cthulhucompanion.screens.common.mvcviews.BaseViewMvc;
import com.example.cthulhucompanion.screens.common.mvcviews.observable.BaseObservableViewMvc;

public class PopUpViewMvcAddPlayerImpl extends BaseObservableViewMvc<PopUpViewMvcAddPlayer.Listener> implements PopUpViewMvcAddPlayer{

    @SuppressLint("InflateParams")
    public PopUpViewMvcAddPlayerImpl(LayoutInflater inflater){
        setRootView(inflater.inflate(R.layout.popup_add_player, null, false));

        /*
        Button buttonConfirm = findViewById(R.id.popup_attack_confirm_btn);
        buttonConfirm.setOnClickListener(v -> {
            for (Listener listener : getListeners()){
                listener.onConfirmButtonClicked();
            }
        });*/
    }
}
