package com.example.cthulhucompanion.screens.popup.move;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.widget.Button;

import com.example.cthulhucompanion.R;
import com.example.cthulhucompanion.screens.common.mvcviews.observable.BaseObservableViewMvc;

public class PopUpViewMvcMoveImpl extends BaseObservableViewMvc<PopUpViewMvcMove.Listener> implements PopUpViewMvcMove {

    @SuppressLint("InflateParams")
    public PopUpViewMvcMoveImpl(LayoutInflater inflater){
        setRootView(inflater.inflate(R.layout.popup_move, null, false));

        Button confirmButton = findViewById(R.id.popup_move_confirm_btn);
        confirmButton.setOnClickListener(v -> {
            for (Listener listener : getListeners()){
                listener.onConfirmButtonClicked();
            }
        });
    }
}
