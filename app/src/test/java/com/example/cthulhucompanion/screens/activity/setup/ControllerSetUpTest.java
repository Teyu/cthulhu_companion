/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.screens.activity.setup;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.cthulhucompanion.database.characters.DataBaseCharacters;
import com.example.cthulhucompanion.database.characters.WrapperCharacterEntry;
import com.example.cthulhucompanion.database.episodes.DataBaseEpisodes;
import com.example.cthulhucompanion.database.greatoldone.DataBaseGreatOldOnes;
import com.example.cthulhucompanion.screens.activity.setup.playeravatar.ViewMvcPlayerAvatar;
import com.example.cthulhucompanion.screens.common.popupmanager.PopUpManager;
import com.example.cthulhucompanion.screens.common.screensnavigator.ScreensNavigator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.HashMap;

@RunWith(MockitoJUnitRunner.class)
public class ControllerSetUpTest {

    private static final HashMap<Integer, ViewMvcPlayerAvatar.Character> CHARACTERS = new HashMap<>();

    private ControllerSetUp SUT;
    @Mock ViewMvcSetUp mViewMvcMock;
    @Mock ScreensNavigator mScreensNavigatorMock;
    @Mock SQLiteDatabase mSQLDataBaseMock;
    @Mock DataBaseGreatOldOnes mDBGreatOldOnesMock;
    @Mock DataBaseEpisodes mDBEpisodesMock;
    @Mock DataBaseCharacters mDBCharactersMock;
    @Mock Context mContextMock;
    @Mock PopUpManager mPopUpManagerMock;
    @Mock ViewMvcSetUp.Listener mListenerMock1, mListenerMock2;

    @Before
    public void setUp() {
        int someImageResource = 0;
        for (ViewMvcPlayerAvatar.Character character : ViewMvcPlayerAvatar.Character.values()){
            CHARACTERS.put(someImageResource++, character);
        }

        SUT = new ControllerSetUp(mScreensNavigatorMock,
                mSQLDataBaseMock,
                mDBGreatOldOnesMock,
                mDBEpisodesMock,
                mDBCharactersMock,
                mPopUpManagerMock,
                mContextMock);

        mViewMvcMock.registerListener(mListenerMock1);
        mViewMvcMock.registerListener(mListenerMock2);

        ArrayList<WrapperCharacterEntry> characterEntries = new ArrayList<>();
        for (int key : CHARACTERS.keySet()){
            characterEntries.add(new WrapperCharacterEntry(key, CHARACTERS.get(key)));
        }
        when(mDBCharactersMock.readData(mSQLDataBaseMock)).thenReturn(characterEntries);

        SUT.bindView(mViewMvcMock);
    }

    @After
    public void tearDown() {
        mViewMvcMock.unregisterListener(mListenerMock1);
        mViewMvcMock.unregisterListener(mListenerMock2);
    }

    @Test
    public void onSetUp_popUpSetAndBoundToAvatarButton(){
        ViewMvcSetUp.PlayerColor color = ViewMvcSetUp.PlayerColor.PLAYER_BLUE;

        verify(mViewMvcMock).setCharacterSelectionPopUp(color, CHARACTERS, null/*PopUpListener not needed*/);
        verify(mViewMvcMock).bindCharacterSelectionPopUp(color);
    }

    @Test
    public void onCharacterSelected_playerAvatarUpdated(){
        ViewMvcSetUp.PlayerColor playerColor = ViewMvcSetUp.PlayerColor.PLAYER_GREEN;
        ViewMvcPlayerAvatar.Character character = ViewMvcPlayerAvatar.Character.AHMED_YASIN;

        SUT.onCharacterSelected(playerColor, character);
        verify(mViewMvcMock).setPlayerAvatar(playerColor, character);

        SUT.onCharacterSelected(playerColor, character);
        verify(mViewMvcMock, times(2)).setPlayerAvatar(playerColor, character);

        verify(mViewMvcMock, times(0)).removePlayerAvatar(playerColor);
    }

    //onCharacterDeleted_playerAvatarEmpty
    @Test
    public void onCharacterDeleted_playerAvatarEmpty(){

        ViewMvcSetUp.PlayerColor playerColor = ViewMvcSetUp.PlayerColor.PLAYER_BLUE;
        ViewMvcPlayerAvatar.Character character = ViewMvcPlayerAvatar.Character.BORDEN;

        mListenerMock1.onCharacterDeleted(playerColor);
        verify(mViewMvcMock).removePlayerAvatar(playerColor);
        verify(mViewMvcMock, times(0)).setPlayerAvatar(playerColor, character);

        mListenerMock2.onCharacterDeleted(playerColor);
        verify(mViewMvcMock).removePlayerAvatar(playerColor);
        verify(mViewMvcMock, times(0)).setPlayerAvatar(playerColor, character);
    }

    //onCharacterSelected_characterRemovedFromPopUpSelection
    @Test
    public void onCharacterSelected_characterRemovedFromPopUpSelection(){

        ViewMvcSetUp.PlayerColor playerColor = ViewMvcSetUp.PlayerColor.PLAYER_RED;
        ViewMvcPlayerAvatar.Character character = ViewMvcPlayerAvatar.Character.JOHN_MORGAN;

        mListenerMock1.onCharacterSelected(playerColor, character);
        verify(mViewMvcMock).removeCharacterFromPopUpSelection(character);
        verify(mViewMvcMock, times(0)).addCharacterToPopUpSelection(character);

        mListenerMock2.onCharacterSelected(playerColor, character);
        verify(mViewMvcMock).removeCharacterFromPopUpSelection(character);
        verifyNoMoreInteractions(mViewMvcMock);
        verify(mViewMvcMock, times(0)).addCharacterToPopUpSelection(character);
    }

    //onCharacterDeleted_characterInsertedIntoPopUpSelection
    @Test
    public void onCharacterDeleted_characterResetInPopUpSelection(){

        ViewMvcSetUp.PlayerColor playerColor = ViewMvcSetUp.PlayerColor.PLAYER_ORANGE;
        ViewMvcPlayerAvatar.Character character = ViewMvcPlayerAvatar.Character.LORD_ADAM_BENCHLEY;

        mListenerMock1.onCharacterDeleted(playerColor);
        verify(mViewMvcMock).addCharacterToPopUpSelection(character);
        verify(mViewMvcMock, times(0)).removeCharacterFromPopUpSelection(character);

        mListenerMock2.onCharacterDeleted(playerColor);
        verify(mViewMvcMock).addCharacterToPopUpSelection(character);
        verify(mViewMvcMock, times(0)).removeCharacterFromPopUpSelection(character);
    }

    //onMultipleCharactersSelected_charactersRemovedFromPopUpSelection
    @Test
    public void onMultipleCharactersSelected_charactersRemovedFromPopUpSelection(){

        ViewMvcSetUp.PlayerColor playerColor1 = ViewMvcSetUp.PlayerColor.PLAYER_ORANGE;
        ViewMvcSetUp.PlayerColor playerColor2 = ViewMvcSetUp.PlayerColor.PLAYER_VIOLET;

        ViewMvcPlayerAvatar.Character character1 = ViewMvcPlayerAvatar.Character.LORD_ADAM_BENCHLEY;
        ViewMvcPlayerAvatar.Character character2 = ViewMvcPlayerAvatar.Character.SERGEANT_IAN_WELLES;

        mListenerMock1.onCharacterSelected(playerColor1, character1);
        mListenerMock1.onCharacterSelected(playerColor2, character2);
        verify(mViewMvcMock).removeCharacterFromPopUpSelection(character1);
        verify(mViewMvcMock).removeCharacterFromPopUpSelection(character2);
        verify(mViewMvcMock, times(0)).addCharacterToPopUpSelection(any());

        mListenerMock2.onCharacterSelected(playerColor1, character1);
        mListenerMock2.onCharacterSelected(playerColor2, character2);
        verify(mViewMvcMock).removeCharacterFromPopUpSelection(character1);
        verify(mViewMvcMock).removeCharacterFromPopUpSelection(character2);
        verify(mViewMvcMock, times(0)).addCharacterToPopUpSelection(any());
    }

    //onMultipleCharactersDeleted_characterInsertedIntoPopUpSelection
    @Test
    public void onMultipleCharactersDeleted_charactersResetInPopUpSelection(){

        ViewMvcSetUp.PlayerColor playerColor1 = ViewMvcSetUp.PlayerColor.PLAYER_VIOLET;
        ViewMvcSetUp.PlayerColor playerColor2 = ViewMvcSetUp.PlayerColor.PLAYER_GREEN;

        ViewMvcPlayerAvatar.Character character1 = ViewMvcPlayerAvatar.Character.RASPUTIN;
        ViewMvcPlayerAvatar.Character character2 = ViewMvcPlayerAvatar.Character.SERGEANT_IAN_WELLES;

        mListenerMock1.onCharacterDeleted(playerColor1);
        mListenerMock1.onCharacterDeleted(playerColor2);
        verify(mViewMvcMock).addCharacterToPopUpSelection(character1);
        verify(mViewMvcMock).addCharacterToPopUpSelection(character2);
        verify(mViewMvcMock, times(0)).removeCharacterFromPopUpSelection(any());

        mListenerMock2.onCharacterDeleted(playerColor1);
        mListenerMock2.onCharacterDeleted(playerColor2);
        verify(mViewMvcMock).addCharacterToPopUpSelection(character1);
        verify(mViewMvcMock).addCharacterToPopUpSelection(character2);
        verify(mViewMvcMock, times(0)).removeCharacterFromPopUpSelection(any());
    }

    //onCharacterReplaced_characterSelectionUpdated
    @Test
    public void onCharacterReplaced_characterSelectionUpdated(){
        ViewMvcSetUp.PlayerColor playerColor = ViewMvcSetUp.PlayerColor.PLAYER_GREEN;
        ViewMvcPlayerAvatar.Character character1 = ViewMvcPlayerAvatar.Character.BORDEN;
        ViewMvcPlayerAvatar.Character character2 = ViewMvcPlayerAvatar.Character.SISTER_BETH;

        mListenerMock1.onCharacterSelected(playerColor, character1);
        mListenerMock1.onCharacterSelected(playerColor, character2);

        verify(mViewMvcMock).removeCharacterFromPopUpSelection(character1);
        verify(mViewMvcMock).addCharacterToPopUpSelection(character1);
        verify(mViewMvcMock).removeCharacterFromPopUpSelection(character2);
        verify(mViewMvcMock, times(0)).addCharacterToPopUpSelection(any());
        verify(mViewMvcMock, times(0)).removeCharacterFromPopUpSelection(any());

        mListenerMock2.onCharacterSelected(playerColor, character1);
        mListenerMock2.onCharacterSelected(playerColor, character2);

        verify(mViewMvcMock).removeCharacterFromPopUpSelection(character1);
        verify(mViewMvcMock).addCharacterToPopUpSelection(character1);
        verify(mViewMvcMock).removeCharacterFromPopUpSelection(character2);
        verify(mViewMvcMock, times(0)).addCharacterToPopUpSelection(any());
        verify(mViewMvcMock, times(0)).removeCharacterFromPopUpSelection(any());
    }

    @Test
    public void onMultipleCharactersReplaced_characterSelectionUpdated(){
        ViewMvcSetUp.PlayerColor playerColor1 = ViewMvcSetUp.PlayerColor.PLAYER_GREEN;
        ViewMvcSetUp.PlayerColor playerColor2 = ViewMvcSetUp.PlayerColor.PLAYER_VIOLET;

        ViewMvcPlayerAvatar.Character character1 = ViewMvcPlayerAvatar.Character.FATIMA_SAFAR;
        ViewMvcPlayerAvatar.Character character2 = ViewMvcPlayerAvatar.Character.THE_KID;

        mListenerMock1.onCharacterSelected(playerColor1, character1);
        mListenerMock1.onCharacterSelected(playerColor2, character1);
        mListenerMock1.onCharacterSelected(playerColor1, character2);

        verify(mViewMvcMock).removeCharacterFromPopUpSelection(character1);
        verify(mViewMvcMock).removeCharacterFromPopUpSelection(character2);
        verify(mViewMvcMock, times(0)).addCharacterToPopUpSelection(any());

        mListenerMock2.onCharacterSelected(playerColor1, character1);
        mListenerMock2.onCharacterSelected(playerColor2, character1);
        mListenerMock2.onCharacterSelected(playerColor1, character2);

        verify(mViewMvcMock).removeCharacterFromPopUpSelection(character1);
        verify(mViewMvcMock).removeCharacterFromPopUpSelection(character2);
        verify(mViewMvcMock, times(0)).addCharacterToPopUpSelection(any());
    }

    @Test
    public void onCharacterSelected_popUpSelectionDeleteButtonAvailable(){
        ViewMvcSetUp.PlayerColor playerColor = ViewMvcSetUp.PlayerColor.PLAYER_BLUE;
        ViewMvcPlayerAvatar.Character character = ViewMvcPlayerAvatar.Character.ELIZABETH_IVES;

        mListenerMock1.onCharacterSelected(playerColor, character);

        verify(mViewMvcMock).provideCharacterDeleteButton();
        verify(mViewMvcMock, times(0)).disableCharacterDeleteButton();

        mListenerMock2.onCharacterSelected(playerColor, character);

        verify(mViewMvcMock).provideCharacterDeleteButton();
        verify(mViewMvcMock, times(0)).disableCharacterDeleteButton();
    }

    @Test
    public void onAllCharactersDeleted_popUpSelectionRemoveDeleteButton(){
        ViewMvcSetUp.PlayerColor playerColor1 = ViewMvcSetUp.PlayerColor.PLAYER_RED;
        ViewMvcSetUp.PlayerColor playerColor2 = ViewMvcSetUp.PlayerColor.PLAYER_VIOLET;

        ViewMvcPlayerAvatar.Character character1 = ViewMvcPlayerAvatar.Character.BORDEN;
        ViewMvcPlayerAvatar.Character character2 = ViewMvcPlayerAvatar.Character.THE_KID;

        mListenerMock1.onCharacterSelected(playerColor1, character1);
        mListenerMock1.onCharacterSelected(playerColor2, character2);
        mListenerMock1.onCharacterDeleted(playerColor1);
        mListenerMock1.onCharacterDeleted(playerColor2);

        verify(mViewMvcMock).disableCharacterDeleteButton();
        verify(mViewMvcMock, times(0)).provideCharacterDeleteButton();

        mListenerMock2.onCharacterSelected(playerColor1, character1);
        mListenerMock2.onCharacterSelected(playerColor2, character2);
        mListenerMock2.onCharacterDeleted(playerColor1);
        mListenerMock2.onCharacterDeleted(playerColor2);

        verify(mViewMvcMock).disableCharacterDeleteButton();
        verifyNoMoreInteractions(mViewMvcMock);
        verify(mViewMvcMock, times(0)).provideCharacterDeleteButton();
    }
}