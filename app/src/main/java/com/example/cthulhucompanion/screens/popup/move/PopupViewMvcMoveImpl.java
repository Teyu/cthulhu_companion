package com.example.cthulhucompanion.screens.popup.move;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.widget.Button;

import com.example.cthulhucompanion.R;
import com.example.cthulhucompanion.screens.popup.common.BaseObservablePopupViewMvc;

public class PopupViewMvcMoveImpl extends BaseObservablePopupViewMvc<ViewMvcPopupMove.Listener> implements ViewMvcPopupMove {

    @SuppressLint("InflateParams")
    public PopupViewMvcMoveImpl(LayoutInflater inflater){
        setRootView(inflater.inflate(R.layout.popup_move, null, false));

        Button buttonConfirm = findViewById(R.id.popup_move_confirm_btn);
        buttonConfirm.setOnClickListener(v -> {
            for (ViewMvcPopupMove.Listener listener : getListeners()){
                listener.onConfirmButtonClicked();
            }
        }
        );
    }
}
