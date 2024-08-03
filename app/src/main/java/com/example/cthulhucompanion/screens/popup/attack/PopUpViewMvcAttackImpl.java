package com.example.cthulhucompanion.screens.popup.attack;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.widget.Button;

import com.example.cthulhucompanion.R;
import com.example.cthulhucompanion.screens.common.mvcviews.observable.BaseObservableViewMvc;

public class PopUpViewMvcAttackImpl extends BaseObservableViewMvc<PopUpViewMvcAttack.Listener> implements PopUpViewMvcAttack {

    @SuppressLint("InflateParams")
    public PopUpViewMvcAttackImpl(LayoutInflater inflater){
        setRootView(inflater.inflate(R.layout.popup_attack, null, false));

        Button buttonConfirm = findViewById(R.id.popup_attack_confirm_btn);
        buttonConfirm.setOnClickListener(v -> {
            for (Listener listener : getListeners()){
                listener.onConfirmButtonClicked();
            }
        });
    }
}
