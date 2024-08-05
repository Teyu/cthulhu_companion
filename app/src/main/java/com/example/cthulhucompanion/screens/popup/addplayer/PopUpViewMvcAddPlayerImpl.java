package com.example.cthulhucompanion.screens.popup.addplayer;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.cthulhucompanion.R;
import com.example.cthulhucompanion.screens.common.mvcviews.observable.BaseObservableViewMvc;

public class PopUpViewMvcAddPlayerImpl extends BaseObservableViewMvc<PopUpViewMvcAddPlayer.Listener> implements PopUpViewMvcAddPlayer{

    @SuppressLint("InflateParams")
    public PopUpViewMvcAddPlayerImpl(LayoutInflater inflater){
        setRootView(inflater.inflate(R.layout.popup_add_player, null, false));

        ImageButton avatarAhmedYasinButton = findViewById(R.id.avatar_ahmed_yasin_btn);
        avatarAhmedYasinButton.setImageResource(R.drawable.avatar_ahmed_yasin);
        avatarAhmedYasinButton.setOnClickListener(v -> {
            for (Listener listener : getListeners()){
                listener.onAvatarClicked();
            }
        });

        ImageButton avatarBordenButton = findViewById(R.id.avatar_borden_btn);
        avatarBordenButton.setImageResource(R.drawable.avatar_borden);
        avatarBordenButton.setOnClickListener(v -> {
            for (Listener listener : getListeners()){
                listener.onAvatarClicked();
            }
        });

        ImageButton avatarElizabethIvesButton = findViewById(R.id.avatar_elizabeth_ives_btn);
        avatarElizabethIvesButton.setImageResource((R.drawable.avatar_elizabeth_ives));
        avatarElizabethIvesButton.setOnClickListener(v -> {
            for (Listener listener : getListeners()){
                listener.onAvatarClicked();
            }
        });

        ImageButton avatarFatimaSafarButton = findViewById(R.id.avatar_fatima_safar_btn);
        avatarFatimaSafarButton.setImageResource(R.drawable.avatar_fatima_safar);
        avatarFatimaSafarButton.setOnClickListener(v -> {
            for (Listener listener : getListeners()){
                listener.onAvatarClicked();
            }
        });

        ImageButton avatarJohnMorganButton = findViewById(R.id.avatar_john_morgan_btn);
        avatarJohnMorganButton.setImageResource(R.drawable.avatar_john_morgan);
        avatarJohnMorganButton.setOnClickListener(v -> {
            for (Listener listener : getListeners()){
                listener.onAvatarClicked();
            }
        });

        ImageButton avatarLordBenchleyButton = findViewById(R.id.avatar_lord_benchley_btn);
        avatarLordBenchleyButton.setImageResource(R.drawable.avatar_lord_adam_benchley);
        avatarLordBenchleyButton.setOnClickListener(v -> {
            for (Listener listener : getListeners()){
                listener.onAvatarClicked();
            }
        });

        ImageButton avatarRasputinButton = findViewById(R.id.avatar_rasputin_btn);
        avatarRasputinButton.setImageResource(R.drawable.avatar_rasputin);
        avatarRasputinButton.setOnClickListener(v -> {
            for (Listener listener : getListeners()){
                listener.onAvatarClicked();
            }
        });

        ImageButton avatarSergeantWellesButton = findViewById(R.id.avatar_sergeant_welles_btn);
        avatarSergeantWellesButton.setImageResource(R.drawable.avatar_sergeant_ian_welles);
        avatarSergeantWellesButton.setOnClickListener(v -> {
            for (Listener listener : getListeners()){
                listener.onAvatarClicked();
            }
        });

        ImageButton avatarSisterBethButton = findViewById(R.id.avatar_sister_beth_btn);
        avatarSisterBethButton.setImageResource(R.drawable.avatar_sister_beth);
        avatarSisterBethButton.setOnClickListener(v -> {
            for (Listener listener : getListeners()){
                listener.onAvatarClicked();
            }
        });

        ImageButton avatarTheKidButton = findViewById(R.id.avatar_the_kid_btn);
        avatarTheKidButton.setImageResource(R.drawable.avatar_the_kid);
        avatarTheKidButton.setOnClickListener(v -> {
            for (Listener listener : getListeners()){
                listener.onAvatarClicked();
            }
        });

        ImageButton avatarDeleteButton = findViewById(R.id.delete_avatar_btn);
        avatarDeleteButton.setImageResource(R.drawable.icon_delete);
        avatarDeleteButton.setOnClickListener(v -> {
            for (Listener listener : getListeners()){
                listener.onAvatarClicked();
            }
        });
    }
}
