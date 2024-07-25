package com.example.cthulhucompanion.screens.settings;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import com.example.cthulhucompanion.R;
import com.example.cthulhucompanion.screens.common.mvcviews.BaseViewMvc;
import com.example.cthulhucompanion.screens.setup.ViewMvcSetUpImpl;

public class ViewMvcSettingsImpl extends BaseViewMvc implements ViewMvcSettings {

    public ViewMvcSettingsImpl(LayoutInflater inflater){
        //setRootView(inflater.inflate(R.layout.settings, null, false));
    }
    @Override
    public void bindAnchorView(View view) {
        view.setOnClickListener(v -> {
            PopupWindow popupWindow = new PopupWindow(
                    getRootView(),
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            popupWindow.setOutsideTouchable(true);
            popupWindow.setFocusable(true);
            //popupWindow.showAsDropDown(view);
        });
    }
}
