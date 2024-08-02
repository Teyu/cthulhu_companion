package com.example.cthulhucompanion.screens.popup;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.widget.ImageButton;

import com.example.cthulhucompanion.R;
import com.example.cthulhucompanion.screens.common.ViewMvcFactory;
import com.example.cthulhucompanion.screens.popup.common.BasePopupViewMvc;
import com.example.cthulhucompanion.screens.popup.common.ViewMvc;

public class ViewMvcPlayerInfoImpl extends BasePopupViewMvc {

    private final ImageButton mViewCardsButton;
    private final ViewMvc mCardsViewMvc;

    @SuppressLint("InflateParams")
    public ViewMvcPlayerInfoImpl(LayoutInflater inflater, ViewMvcFactory viewMvcFactory){
        setRootView(inflater.inflate(R.layout.popup_player_info_mutable, null, false));

        mViewCardsButton = this.findViewById(R.id.show_cards_btn);
        mCardsViewMvc = viewMvcFactory.getViewMvcCards();
        mCardsViewMvc.bindAnchorView(mViewCardsButton);
    }
}
