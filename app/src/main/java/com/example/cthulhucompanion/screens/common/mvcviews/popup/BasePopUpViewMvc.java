package com.example.cthulhucompanion.screens.common.mvcviews.popup;

import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import com.example.cthulhucompanion.screens.common.mvcviews.BaseViewMvc;

public class BasePopUpViewMvc extends BaseViewMvc implements PopUpViewMvc{

    @Override
    public void bindAnchorView(View view) {
        view.setOnClickListener(v -> {
            PopupWindow popupWindow = new PopupWindow(
                    getRootView(),
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            popupWindow.setOutsideTouchable(true);
            popupWindow.setFocusable(true);
            popupWindow.showAtLocation(getRootView(), Gravity.CENTER, 0, 0);
        });
    }
}
