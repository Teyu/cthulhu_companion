package com.example.cthulhucompanion.screens.popup.rest;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.widget.Button;

import com.example.cthulhucompanion.R;
import com.example.cthulhucompanion.screens.common.mvcviews.observable.BaseObservableViewMvc;

public class PopUpViewMvcRestImpl extends BaseObservableViewMvc<PopUpViewMvcRest.Listener> implements PopUpViewMvcRest {

    @SuppressLint("InflateParams")
    public PopUpViewMvcRestImpl(LayoutInflater inflater){
        setRootView(inflater.inflate(R.layout.popup_rest, null, false));

        Button buttonConfirm = findViewById(R.id.popup_rest_confirm_btn);
        buttonConfirm.setOnClickListener(v -> {
            for (Listener listener : getListeners()){
                listener.onConfirmButtonClicked();
            }
        });
    }
}
