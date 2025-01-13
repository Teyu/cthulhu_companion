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

    //TODO: use character as key (Hashmap) and remove all loops
    private final ArrayList<Pair<Integer, ViewMvcPlayerAvatar.Character>> mCharacterButtons = new ArrayList<>();

    @SuppressLint("InflateParams")
    public PopUpViewMvcSelectCharacterImpl(LayoutInflater inflater){
        setRootView(inflater.inflate(R.layout.popup_add_player, null, false));

        Pair<Integer, ViewMvcPlayerAvatar.Character> character = new Pair<>(R.id.avatar_ahmed_yasin, ViewMvcPlayerAvatar.Character.AHMED_YASIN);
        mCharacterButtons.add(character);

        character = new Pair<>(R.id.avatar_borden, ViewMvcPlayerAvatar.Character.BORDEN);
        mCharacterButtons.add(character);

        character = new Pair<>(R.id.avatar_elizabeth_ives, ViewMvcPlayerAvatar.Character.ELIZABETH_IVES);
        mCharacterButtons.add(character);

        character = new Pair<>(R.id.avatar_fatima_safar, ViewMvcPlayerAvatar.Character.FATIMA_SAFAR);
        mCharacterButtons.add(character);

        character = new Pair<>(R.id.avatar_john_morgan, ViewMvcPlayerAvatar.Character.JOHN_MORGAN);
        mCharacterButtons.add(character);

        character = new Pair<>(R.id.avatar_lord_benchley, ViewMvcPlayerAvatar.Character.LORD_ADAM_BENCHLEY);
        mCharacterButtons.add(character);

        character = new Pair<>(R.id.avatar_rasputin, ViewMvcPlayerAvatar.Character.RASPUTIN);
        mCharacterButtons.add(character);

        character = new Pair<>(R.id.avatar_sergeant_welles, ViewMvcPlayerAvatar.Character.SERGEANT_IAN_WELLES);
        mCharacterButtons.add(character);

        character = new Pair<>(R.id.avatar_sister_beth, ViewMvcPlayerAvatar.Character.SISTER_BETH);
        mCharacterButtons.add(character);

        character = new Pair<>(R.id.avatar_the_kid, ViewMvcPlayerAvatar.Character.THE_KID);
        mCharacterButtons.add(character);
    }

    @Override
    public void setCharacterImage(int imageResource, final ViewMvcPlayerAvatar.Character character){
        for (Pair<Integer, ViewMvcPlayerAvatar.Character> characterImageButton : mCharacterButtons){
            if (characterImageButton.getSecond() == character){

                ImageButton imageButton = findViewById(characterImageButton.getFirst()).findViewById(R.id.character_btn);
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
                ImageButton imageButton = findViewById(characterImageButton.getFirst()).findViewById(R.id.character_btn);
                return (int) imageButton.getTag();
            }
        }
        return 0;
    }

    @Override
    public void disableCharacter(ViewMvcPlayerAvatar.Character character) {
        for (Pair<Integer, ViewMvcPlayerAvatar.Character> characterImageButton : mCharacterButtons) {
            if (characterImageButton.getSecond() == character){
                ImageButton characterButton = findViewById(characterImageButton.getFirst()).findViewById(R.id.character_btn);
                characterButton.setAlpha(0.2f);
                characterButton.setEnabled(false);
            }
        }
    }

    @Override
    public void enableCharacter(ViewMvcPlayerAvatar.Character character) {

        for (Pair<Integer, ViewMvcPlayerAvatar.Character> characterImageButton : mCharacterButtons) {
            if (characterImageButton.getSecond() == character){
                ImageButton characterButton = findViewById(characterImageButton.getFirst()).findViewById(R.id.character_btn);
                characterButton.setAlpha(1.0f);
                characterButton.setEnabled(true);
            }
        }
    }

    @Override
    public void makeCharacterDeletable(ViewMvcPlayerAvatar.Character character, boolean deletable) {

        for (Pair<Integer, ViewMvcPlayerAvatar.Character> characterImageButton : mCharacterButtons) {
            if (characterImageButton.getSecond() == character){
                ImageButton deleteButton = findViewById(characterImageButton.getFirst()).findViewById(R.id.delete_character_btn);
                if (deletable) {
                    deleteButton.setEnabled(true);
                    deleteButton.setVisibility(View.VISIBLE);
                } else {
                    deleteButton.setEnabled(false);
                    deleteButton.setVisibility(View.GONE);
                }
            }
        }
    }

    // WARNING: !!! deprecated
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
