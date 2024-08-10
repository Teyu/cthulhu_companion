package com.example.cthulhucompanion.screens.common.popupmanager;

import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import androidx.annotation.NonNull;

import com.example.cthulhucompanion.screens.common.ViewMvcFactory;
import com.example.cthulhucompanion.screens.common.mvcviews.observable.ObservableViewMvc;
import com.example.cthulhucompanion.screens.popup.addplayer.PopUpViewMvcAddPlayer;
import com.example.cthulhucompanion.screens.popup.attack.PopUpViewMvcAttack;
import com.example.cthulhucompanion.screens.popup.move.PopUpViewMvcMove;
import com.example.cthulhucompanion.screens.popup.rest.PopUpViewMvcRest;
import com.example.cthulhucompanion.screens.popup.trade.PopUpViewMvcTrade;


public class PopUpManager {

    ViewMvcFactory mViewMvcFactory;
    PopupWindow mPopUpWindowMove, mPopUpWindowAttack, mPopUpWindowRest, mPopUpWindowTrade;
    PopupWindow mPopUpWindowAddPlayer;

    public PopUpManager(ViewMvcFactory viewMvcFactory) {
        this.mViewMvcFactory = viewMvcFactory;
    }

    public void anchorPopUpAttackAndNotify(@NonNull final View anchorView, PopUpViewMvcAttack.Listener listener){
        PopUpViewMvcAttack viewMvcAttack = mViewMvcFactory.getViewMvcPopupAttack();

        mPopUpWindowAttack = new PopupWindow(
                viewMvcAttack.getRootView(),
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);;

        anchorPopUpToView(viewMvcAttack, anchorView, listener , mPopUpWindowAttack);
    }

    public boolean isPopUpAttackShowing(){
        return mPopUpWindowAttack.isShowing();
    }

    public void dismissPopUpAttack() {
        mPopUpWindowAttack.dismiss();
    }

    public void anchorPopUpMoveAndNotify(@NonNull final View anchorView, PopUpViewMvcMove.Listener listener){
        PopUpViewMvcMove viewMvcMove = mViewMvcFactory.getViewMvcPopupMove();

        mPopUpWindowMove = new PopupWindow(
                viewMvcMove.getRootView(),
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);

        anchorPopUpToView(viewMvcMove, anchorView, listener, mPopUpWindowMove);
    }

    public boolean isPopUpMoveShowing(){
        return mPopUpWindowMove.isShowing();
    }

    public void dismissPopUpMove(){
        mPopUpWindowMove.dismiss();
    }

    public void anchorPopUpRest(@NonNull final View anchorView, PopUpViewMvcRest.Listener listener){
        PopUpViewMvcRest viewMvcRest = mViewMvcFactory.getViewMvcPopupRest();

        mPopUpWindowRest = new PopupWindow(
                viewMvcRest.getRootView(),
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);

        anchorPopUpToView(viewMvcRest, anchorView, listener, mPopUpWindowRest);
    }

    public boolean isPopUpRestShowing() {
        return mPopUpWindowRest.isShowing();
    }

    public void dismissPopUpRest() {
        mPopUpWindowRest.dismiss();
    }

    public void anchorPopUpTrade(@NonNull final View anchorView, PopUpViewMvcTrade.Listener listener){
        PopUpViewMvcTrade viewMvcTrade = mViewMvcFactory.getViewMvcPopupTrade();

        mPopUpWindowTrade = new PopupWindow(
                viewMvcTrade.getRootView(),
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);

        anchorPopUpToView(viewMvcTrade, anchorView, listener, mPopUpWindowTrade);
    }

    public boolean isPopUpTradeShowing() {
        return mPopUpWindowTrade.isShowing();
    }

    public void dismissPopUpTrade() {
        mPopUpWindowTrade.dismiss();
    }

    public void anchorPopUpAddPlayer(@NonNull final View anchorView, PopUpViewMvcAddPlayer viewMvcAddPlayer, PopUpViewMvcAddPlayer.Listener listener) {

        mPopUpWindowAddPlayer = new PopupWindow(
                viewMvcAddPlayer.getRootView(),
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);

        anchorPopUpToView(viewMvcAddPlayer, anchorView, listener, mPopUpWindowAddPlayer);
    }

    public void dismissPopUpAddPlayer() {
        mPopUpWindowAddPlayer.dismiss();
    }

    private <ListenerType> void anchorPopUpToView(@NonNull ObservableViewMvc<ListenerType> popUpViewMvc,
                                                  @NonNull View anchorView,
                                                  @NonNull ListenerType listener,
                                                  @NonNull final PopupWindow popupWindow){

        anchorView.setOnClickListener(v -> {
            popupWindow.setOutsideTouchable(true);
            popupWindow.setFocusable(true);
            popupWindow.showAtLocation(popUpViewMvc.getRootView(), Gravity.CENTER, 0, 0);

            popUpViewMvc.registerListener(listener);
        });

        popupWindow.setOnDismissListener(() -> popUpViewMvc.unregisterListener(listener));
    }
}
