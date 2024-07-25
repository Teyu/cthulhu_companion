package com.example.cthulhucompanion.screens.popup;

import android.annotation.SuppressLint;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.PopupWindow;

import com.example.cthulhucompanion.R;
import com.example.cthulhucompanion.screens.common.ViewMvcFactory;
import com.example.cthulhucompanion.screens.common.mvcviews.BaseViewMvc;
import com.example.cthulhucompanion.screens.common.mvcviews.popup.BasePopUpViewMvc;
import com.example.cthulhucompanion.screens.common.mvcviews.popup.PopUpViewMvc;

public class ViewMvcPlayerInfoImpl extends BasePopUpViewMvc {

    private final ImageButton mViewCardsButton;
    private final PopUpViewMvc mCardsViewMvc;

    @SuppressLint("InflateParams")
    public ViewMvcPlayerInfoImpl(LayoutInflater inflater, ViewMvcFactory viewMvcFactory){
        setRootView(inflater.inflate(R.layout.popup_player_info_mutable, null, false));

        mViewCardsButton = this.findViewById(R.id.show_cards_btn);
        mCardsViewMvc = viewMvcFactory.getViewMvcCards();
        mCardsViewMvc.bindAnchorView(mViewCardsButton);
    }
}
