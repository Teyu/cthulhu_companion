package com.example.cthulhucompanion.screens.common.popupnavigator;

import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import androidx.annotation.NonNull;

import com.example.cthulhucompanion.screens.common.ViewMvcFactory;
import com.example.cthulhucompanion.screens.common.mvcviews.ViewMvc;
import com.example.cthulhucompanion.screens.popup.move.PopUpViewMvcMove;


public class PopUpNavigator {

    ViewMvcFactory mViewMvcFactory;

    public PopUpNavigator(ViewMvcFactory viewMvcFactory) {
        this.mViewMvcFactory = viewMvcFactory;
    }

    public void anchorPopUpAttack(@NonNull final View anchorView){
        anchorPopUpToView(mViewMvcFactory.getViewMvcPopupAttack(), anchorView);
    }

    public void anchorPopUpMove(@NonNull final View anchorView, PopUpViewMvcMove.Listener listener){
        PopUpViewMvcMove viewMvcMove = mViewMvcFactory.getViewMvcPopupMove();
        anchorPopUpToView(viewMvcMove, anchorView);
        viewMvcMove.registerListener(listener);
    }

    public void anchorPopUpRest(@NonNull final View anchorView){
        anchorPopUpToView(mViewMvcFactory.getViewMvcPopupRest(), anchorView);
    }

    public void anchorPopUpTrade(@NonNull final View anchorView){
        anchorPopUpToView(mViewMvcFactory.getViewMvcPopupTrade(), anchorView);
    }

    private void anchorPopUpToView(ViewMvc popUpViewMvc, View anchorView){
        anchorView.setOnClickListener(v -> {
            PopupWindow popupWindow = new PopupWindow(
                    popUpViewMvc.getRootView(),
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            popupWindow.setOutsideTouchable(true);
            popupWindow.setFocusable(true);
            popupWindow.showAtLocation(popUpViewMvc.getRootView(), Gravity.CENTER, 0, 0);
        });
    }
}
