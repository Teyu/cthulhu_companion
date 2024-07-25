package com.example.cthulhucompanion.screens.popup;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import com.example.cthulhucompanion.R;
import com.example.cthulhucompanion.screens.common.mvcviews.BaseViewMvc;
import com.example.cthulhucompanion.screens.common.mvcviews.popup.BasePopUpViewMvc;

public class ViewMvcTradeImpl extends BasePopUpViewMvc {

    @SuppressLint("InflateParams")
    public ViewMvcTradeImpl(LayoutInflater inflater){
        setRootView(inflater.inflate(R.layout.popup_trade, null, false));
    }
}
