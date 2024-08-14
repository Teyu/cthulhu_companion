package com.example.cthulhucompanion.screens.popup.selectcharacter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;

import com.example.cthulhucompanion.R;
import com.example.cthulhucompanion.screens.common.mvcviews.observable.BaseObservableViewMvc;

import java.util.ArrayList;

import kotlin.Pair;

public class PopUpViewMvcSelectCharacterImpl extends BaseObservableViewMvc<PopUpViewMvcSelectCharacter.PopUpListener> implements PopUpViewMvcSelectCharacter {

    private final ImageButton mCharacterDeleteButton;
    private final ArrayList<ImageButton> mCharacterButtons = new ArrayList<>();
    private final ArrayList<Pair<Integer, Character>> mCharacterImageButtons = new ArrayList<>();

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

        Pair<Integer, Character> character = new Pair<>(R.id.avatar_ahmed_yasin_btn, Character.AHMED_YASIN);
        mCharacterImageButtons.add(character);

        character = new Pair<>(R.id.avatar_ahmed_yasin_btn, Character.AHMED_YASIN);
        mCharacterImageButtons.add(character);

        character = new Pair<>(R.id.avatar_borden_btn, Character.BORDEN);
        mCharacterImageButtons.add(character);

        character = new Pair<>(R.id.avatar_elizabeth_ives_btn, Character.ELIZABETH_IVES);
        mCharacterImageButtons.add(character);

        character = new Pair<>(R.id.avatar_fatima_safar_btn, Character.FATIMA_SAFAR);
        mCharacterImageButtons.add(character);

        character = new Pair<>(R.id.avatar_john_morgan_btn, Character.JOHN_MORGAN);
        mCharacterImageButtons.add(character);

        character = new Pair<>(R.id.avatar_lord_benchley_btn, Character.LORD_ADAM_BENCHLEY);
        mCharacterImageButtons.add(character);

        character = new Pair<>(R.id.avatar_rasputin_btn, Character.RASPUTIN);
        mCharacterImageButtons.add(character);

        character = new Pair<>(R.id.avatar_sergeant_welles_btn, Character.SERGEANT_IAN_WELLES);
        mCharacterImageButtons.add(character);

        character = new Pair<>(R.id.avatar_sister_beth_btn, Character.SISTER_BETH);
        mCharacterImageButtons.add(character);

        character = new Pair<>(R.id.avatar_the_kid_btn, Character.THE_KID);
        mCharacterImageButtons.add(character);
    }

    @Override
    public void setCharacterImage(int imageResource, final Character character){
        for (Pair<Integer, Character> characterImageButton : mCharacterImageButtons){
            if (characterImageButton.getSecond() == character){

                ImageButton imageButton = findViewById(characterImageButton.getFirst());
                imageButton.setVisibility(View.VISIBLE);

                imageButton.setImageResource(imageResource);
                imageButton.setOnClickListener(v -> {
                    for (PopUpListener popUpListener : getListeners()){
                        popUpListener.onCharacterButtonClicked(character);
                    }
                });
            }
        }
    }

    @Override
    public int getCharacterImage(Character character) {
        for (Pair<Integer, Character> characterImageButton : mCharacterImageButtons){
            if (characterImageButton.getSecond() == character){
                return characterImageButton.getFirst();
            }
        }
        return 0;
    }

    @Override
    public void removeCharacter(Character character) {
        for (Pair<Integer, Character> characterImageButton : mCharacterImageButtons) {
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
    public void showCharacter(Character character) {

        for (Pair<Integer, Character> characterImageButton : mCharacterImageButtons) {
            if (characterImageButton.getSecond() == character){
                ImageButton characterButton = findViewById(characterImageButton.getFirst());
                characterButton.setVisibility(View.VISIBLE);
            }
        }
    }
}
