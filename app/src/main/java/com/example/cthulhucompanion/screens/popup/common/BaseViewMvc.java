package com.example.cthulhucompanion.screens.popup.common;

import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import androidx.annotation.NonNull;

public class BaseViewMvc extends com.example.cthulhucompanion.screens.common.mvcviews.BaseViewMvc implements ViewMvc {

    @Override
    public void bindAnchorView(@NonNull View view) {
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
