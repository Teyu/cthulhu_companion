package com.example.cthulhucompanion.screens.popup.selectcharacter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;

import com.example.cthulhucompanion.R;
import com.example.cthulhucompanion.screens.activity.setup.playeravatar.ViewMvcPlayerAvatar;
import com.example.cthulhucompanion.screens.common.mvcviews.observable.BaseObservableViewMvc;

import java.util.ArrayList;

import kotlin.Pair;

public class PopUpViewMvcSelectCharacterImpl extends BaseObservableViewMvc<PopUpViewMvcSelectCharacter.PopUpListener> implements PopUpViewMvcSelectCharacter {

    private final ImageButton mCharacterDeleteButton;
    private final ArrayList<Pair<Integer, ViewMvcPlayerAvatar.Character>> mCharacterButtons = new ArrayList<>();

    @SuppressLint("InflateParams")
    public PopUpViewMvcSelectCharacterImpl(LayoutInflater inflater){
        setRootView(inflater.inflate(R.layout.popup_add_player, null, false));

        this.mCharacterDeleteButton = findViewById(R.id.delete_avatar_btn);
        mCharacterDeleteButton.setImageResource(R.drawable.icon_delete);
        mCharacterDeleteButton.setOnClickListener(v -> {
            for (PopUpListener popUpListener : getListeners()){
                popUpListener.onDeleteButtonClicked();
            }
        });

        Pair<Integer, ViewMvcPlayerAvatar.Character> character = new Pair<>(R.id.avatar_ahmed_yasin_btn, ViewMvcPlayerAvatar.Character.AHMED_YASIN);
        mCharacterButtons.add(character);

        character = new Pair<>(R.id.avatar_ahmed_yasin_btn, ViewMvcPlayerAvatar.Character.AHMED_YASIN);
        mCharacterButtons.add(character);

        character = new Pair<>(R.id.avatar_borden_btn, ViewMvcPlayerAvatar.Character.BORDEN);
        mCharacterButtons.add(character);

        character = new Pair<>(R.id.avatar_elizabeth_ives_btn, ViewMvcPlayerAvatar.Character.ELIZABETH_IVES);
        mCharacterButtons.add(character);

        character = new Pair<>(R.id.avatar_fatima_safar_btn, ViewMvcPlayerAvatar.Character.FATIMA_SAFAR);
        mCharacterButtons.add(character);

        character = new Pair<>(R.id.avatar_john_morgan_btn, ViewMvcPlayerAvatar.Character.JOHN_MORGAN);
        mCharacterButtons.add(character);

        character = new Pair<>(R.id.avatar_lord_benchley_btn, ViewMvcPlayerAvatar.Character.LORD_ADAM_BENCHLEY);
        mCharacterButtons.add(character);

        character = new Pair<>(R.id.avatar_rasputin_btn, ViewMvcPlayerAvatar.Character.RASPUTIN);
        mCharacterButtons.add(character);

        character = new Pair<>(R.id.avatar_sergeant_welles_btn, ViewMvcPlayerAvatar.Character.SERGEANT_IAN_WELLES);
        mCharacterButtons.add(character);

        character = new Pair<>(R.id.avatar_sister_beth_btn, ViewMvcPlayerAvatar.Character.SISTER_BETH);
        mCharacterButtons.add(character);

        character = new Pair<>(R.id.avatar_the_kid_btn, ViewMvcPlayerAvatar.Character.THE_KID);
        mCharacterButtons.add(character);
    }

    @Override
    public void setCharacterImage(int imageResource, final ViewMvcPlayerAvatar.Character character){
        for (Pair<Integer, ViewMvcPlayerAvatar.Character> characterImageButton : mCharacterButtons){
            if (characterImageButton.getSecond() == character){

                ImageButton imageButton = findViewById(characterImageButton.getFirst());
                imageButton.setVisibility(View.VISIBLE);

                imageButton.setImageResource(imageResource);
                imageButton.setTag(imageResource);
                imageButton.setOnClickListener(v -> {
                    for (PopUpListener popUpListener : getListeners()){
                        popUpListener.onCharacterButtonClicked(character);
                    }
                });
            }
        }
    }

    @Override
    public int getCharacterImage(ViewMvcPlayerAvatar.Character character) {
        for (Pair<Integer, ViewMvcPlayerAvatar.Character> characterImageButton : mCharacterButtons){
            if (characterImageButton.getSecond() == character){
                ImageButton imageButton = findViewById(characterImageButton.getFirst());
                return (int) imageButton.getTag();
            }
        }
        return 0;
    }

    @Override
    public void removeCharacter(ViewMvcPlayerAvatar.Character character) {
        for (Pair<Integer, ViewMvcPlayerAvatar.Character> characterImageButton : mCharacterButtons) {
            if (characterImageButton.getSecond() == character){
                ImageButton characterButton = findViewById(characterImageButton.getFirst());
                characterButton.setVisibility(View.GONE);
            }
        }
    }

    @Override
    public void addDeleteButton(){
        mCharacterDeleteButton.setVisibility(View.VISIBLE);
    }

    @Override
    public void removeDeleteButton(){
        mCharacterDeleteButton.setVisibility(View.GONE);
    }

    @Override
    public void showCharacter(ViewMvcPlayerAvatar.Character character) {

        for (Pair<Integer, ViewMvcPlayerAvatar.Character> characterImageButton : mCharacterButtons) {
            if (characterImageButton.getSecond() == character){
                ImageButton characterButton = findViewById(characterImageButton.getFirst());
                characterButton.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public boolean contains(ViewMvcPlayerAvatar.Character character) {
        for (Pair<Integer, ViewMvcPlayerAvatar.Character> characterButton : mCharacterButtons) {
            if (characterButton.getSecond() == character){
                ImageButton imageButton = findViewById(characterButton.getFirst());
                return imageButton.getVisibility() == View.VISIBLE;
            }
        }
        return false;
    }
}
