/*
 * Copyright 2024, Julia Michaely, All rights reserved.
 */

package com.example.cthulhucompanion.screens.activity.setup;

import static org.junit.Assert.assertTrue;
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

import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.*;

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
                mContextMock);

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
    public void onSetUp_avatarsEmptyDeleteDisabled(){
        verify(mViewMvcMock, times(0)).setPlayerAvatar(any(), any());
        verify(mViewMvcMock).disableCharacterDelete();
    }

    @Test
    public void onSetUp_popUpSetAndBoundToAvatarButton(){
        ViewMvcSetUp.PlayerColor color = ViewMvcSetUp.PlayerColor.PLAYER_BLUE;

        verify(mViewMvcMock).setCharacterSelectionPopUp(color, CHARACTERS);
        verify(mViewMvcMock).bindCharacterSelectionPopUp();
    }

    @Test
    public void onCharacterSelected_playerAvatarUpdated(){
        ViewMvcSetUp.PlayerColor playerColor = ViewMvcSetUp.PlayerColor.PLAYER_GREEN;
        ViewMvcPlayerAvatar.Character character = ViewMvcPlayerAvatar.Character.AHMED_YASIN;

        SUT.onCharacterSelected(playerColor, character);
        verify(mViewMvcMock).setPlayerAvatar(playerColor, character);
        verify(mViewMvcMock, times(0)).removePlayerAvatar(playerColor);
    }

    @Test
    public void onCharacterDeleted_playerAvatarEmpty(){

        ViewMvcSetUp.PlayerColor playerColor = ViewMvcSetUp.PlayerColor.PLAYER_BLUE;
        ViewMvcPlayerAvatar.Character character = ViewMvcPlayerAvatar.Character.BORDEN;

        SUT.onCharacterDeleted(playerColor);
        verify(mViewMvcMock, times(1)).removePlayerAvatar(playerColor);
        verify(mViewMvcMock, times(0)).setPlayerAvatar(playerColor, character);
    }

    @Test
    public void onCharacterSelected_characterRemovedFromPopUpSelection(){

        ViewMvcSetUp.PlayerColor playerColor = ViewMvcSetUp.PlayerColor.PLAYER_RED;
        ViewMvcPlayerAvatar.Character character = ViewMvcPlayerAvatar.Character.JOHN_MORGAN;

        SUT.onCharacterSelected(playerColor, character);
        verify(mViewMvcMock, times(1)).removeCharacterFromPopUpSelection(character);
        verify(mViewMvcMock, times(0)).addCharacterToPopUpSelection(character);
    }

    @Test
    public void onCharacterDeleted_characterResetInPopUpSelection(){

        ViewMvcSetUp.PlayerColor playerColor = ViewMvcSetUp.PlayerColor.PLAYER_ORANGE;
        ViewMvcPlayerAvatar.Character character = ViewMvcPlayerAvatar.Character.LORD_ADAM_BENCHLEY;

        when(mViewMvcMock.getSelectedCharacter(playerColor)).thenReturn(character);

        SUT.onCharacterSelected(playerColor, character);
        SUT.onCharacterDeleted(playerColor);
        verify(mViewMvcMock).removeCharacterFromPopUpSelection(character);
        verify(mViewMvcMock, atLeastOnce()).addCharacterToPopUpSelection(character);
    }

    @Test
    public void onMultipleCharactersSelected_charactersRemovedFromPopUpSelection(){

        ViewMvcSetUp.PlayerColor playerColor1 = ViewMvcSetUp.PlayerColor.PLAYER_ORANGE;
        ViewMvcSetUp.PlayerColor playerColor2 = ViewMvcSetUp.PlayerColor.PLAYER_VIOLET;

        ViewMvcPlayerAvatar.Character character1 = ViewMvcPlayerAvatar.Character.LORD_ADAM_BENCHLEY;
        ViewMvcPlayerAvatar.Character character2 = ViewMvcPlayerAvatar.Character.SERGEANT_IAN_WELLES;

        SUT.onCharacterSelected(playerColor1, character1);
        SUT.onCharacterSelected(playerColor2, character2);
        verify(mViewMvcMock).removeCharacterFromPopUpSelection(character1);
        verify(mViewMvcMock).removeCharacterFromPopUpSelection(character2);
    }

    @Test
    public void onMultipleCharactersDeleted_charactersResetInPopUpSelection(){

        ViewMvcSetUp.PlayerColor playerColor1 = ViewMvcSetUp.PlayerColor.PLAYER_VIOLET;
        ViewMvcSetUp.PlayerColor playerColor2 = ViewMvcSetUp.PlayerColor.PLAYER_GREEN;

        ViewMvcPlayerAvatar.Character character1 = ViewMvcPlayerAvatar.Character.RASPUTIN;
        ViewMvcPlayerAvatar.Character character2 = ViewMvcPlayerAvatar.Character.SERGEANT_IAN_WELLES;

        when(mViewMvcMock.getSelectedCharacter(playerColor1)).thenReturn(character1);
        when(mViewMvcMock.getSelectedCharacter(playerColor2)).thenReturn(character2);

        SUT.onCharacterDeleted(playerColor1);
        SUT.onCharacterDeleted(playerColor2);
        verify(mViewMvcMock).addCharacterToPopUpSelection(character1);
        verify(mViewMvcMock).addCharacterToPopUpSelection(character2);
        verify(mViewMvcMock, times(0)).removeCharacterFromPopUpSelection(any());
    }

    @Test
    public void onCharacterReplaced_characterSelectionUpdated(){
        ViewMvcSetUp.PlayerColor playerColor = ViewMvcSetUp.PlayerColor.PLAYER_GREEN;
        ViewMvcPlayerAvatar.Character character1 = ViewMvcPlayerAvatar.Character.BORDEN;
        ViewMvcPlayerAvatar.Character character2 = ViewMvcPlayerAvatar.Character.SISTER_BETH;

        ArgumentCaptor<ViewMvcPlayerAvatar.Character> firstCharacterRemoved = ArgumentCaptor.forClass(ViewMvcPlayerAvatar.Character.class);

        when(mViewMvcMock.getSelectedCharacter(playerColor)).thenReturn(character1);

        SUT.onCharacterSelected(playerColor, character2);

        verify(mViewMvcMock).removeCharacterFromPopUpSelection(firstCharacterRemoved.capture());
        verify(mViewMvcMock).addCharacterToPopUpSelection(character1);

        assertTrue(firstCharacterRemoved.getAllValues().contains(character2));
    }

    @Test
    public void onMultipleCharactersReplaced_characterSelectionUpdated(){
        ViewMvcSetUp.PlayerColor playerColor1 = ViewMvcSetUp.PlayerColor.PLAYER_GREEN;
        ViewMvcSetUp.PlayerColor playerColor2 = ViewMvcSetUp.PlayerColor.PLAYER_VIOLET;

        ViewMvcPlayerAvatar.Character character1 = ViewMvcPlayerAvatar.Character.FATIMA_SAFAR;
        ViewMvcPlayerAvatar.Character character2 = ViewMvcPlayerAvatar.Character.THE_KID;

        when(mViewMvcMock.getSelectedCharacter(playerColor1)).thenReturn(character2);
        when(mViewMvcMock.getSelectedCharacter(playerColor2)).thenReturn(character1);

        ArgumentCaptor<ViewMvcPlayerAvatar.Character> charactersRemoved = ArgumentCaptor.forClass(ViewMvcPlayerAvatar.Character.class);

        SUT.onCharacterSelected(playerColor1, character1);
        when(mViewMvcMock.getSelectedCharacter(playerColor1)).thenReturn(character1);
        SUT.onCharacterSelected(playerColor2, character1);
        SUT.onCharacterSelected(playerColor1, character2);

        verify(mViewMvcMock, atLeast(2)).removeCharacterFromPopUpSelection(charactersRemoved.capture());

        assertTrue(charactersRemoved.getAllValues().contains(character1));
        assertTrue(charactersRemoved.getAllValues().contains(character2));
    }

    @Test
    public void onCharacterSelected_popUpSelectionDeleteAvailable(){
        ViewMvcSetUp.PlayerColor playerColor = ViewMvcSetUp.PlayerColor.PLAYER_BLUE;
        ViewMvcPlayerAvatar.Character character = ViewMvcPlayerAvatar.Character.ELIZABETH_IVES;

        SUT.onCharacterSelected(playerColor, character);

        verify(mViewMvcMock).provideCharacterDelete();
    }

    @Test
    public void onAllCharactersDeleted_popUpSelectionDisableDelete(){
        ViewMvcSetUp.PlayerColor playerColor1 = ViewMvcSetUp.PlayerColor.PLAYER_RED;
        ViewMvcSetUp.PlayerColor playerColor2 = ViewMvcSetUp.PlayerColor.PLAYER_VIOLET;

        ViewMvcPlayerAvatar.Character character1 = ViewMvcPlayerAvatar.Character.BORDEN;
        ViewMvcPlayerAvatar.Character character2 = ViewMvcPlayerAvatar.Character.THE_KID;

        SUT.onCharacterSelected(playerColor1, character1);
        SUT.onCharacterSelected(playerColor2, character2);
        SUT.onCharacterDeleted(playerColor1);
        SUT.onCharacterDeleted(playerColor2);

        verify(mViewMvcMock).disableCharacterDelete();
    }
}