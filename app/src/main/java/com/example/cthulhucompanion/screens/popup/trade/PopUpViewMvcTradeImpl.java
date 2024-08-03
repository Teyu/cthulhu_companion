package com.example.cthulhucompanion.screens.popup.trade;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.widget.Button;

import com.example.cthulhucompanion.R;
import com.example.cthulhucompanion.screens.common.mvcviews.observable.BaseObservableViewMvc;

public class PopUpViewMvcTradeImpl extends BaseObservableViewMvc<PopUpViewMvcTrade.Listener> implements PopUpViewMvcTrade {

    @SuppressLint("InflateParams")
    public PopUpViewMvcTradeImpl(LayoutInflater inflater){
        setRootView(inflater.inflate(R.layout.popup_trade, null, false));

        Button buttonConfirm = findViewById(R.id.pop_trade_confirm_btn);
        buttonConfirm.setOnClickListener(v -> {
            for (Listener listener : getListeners()){
                listener.onConfirmButtonClicked();
            }
        });
    }
}
