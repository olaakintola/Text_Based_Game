package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameBoardTest {
    private GameBoard gameBoard;

    @BeforeEach
    public void setUp(){
        gameBoard = new GameBoard(4);
    }

    @Test
    public void testAddPlayertoBoard(){
        String initialPlayerPosition = gameBoard.getPlayerPosition();
        String secondPlayerPosition = new GameBoard(4).getPlayerPosition();
        assertNotEquals(initialPlayerPosition, secondPlayerPosition);
    }

    @Test
    public void testAddMonsterstoBoard(){

        String[] monstersCoordinates = new String[2];
        monstersCoordinates = gameBoard.getMonstersPosition();

        assertNotNull(monstersCoordinates[0]);
    }

    @Test
    public void testPlaceTreasure(){

        String initialTreasurePosition = gameBoard.getTreasurePosition();
        String secondTreasurePosition = new GameBoard(4).getTreasurePosition();
        assertNotEquals(initialTreasurePosition, secondTreasurePosition);
    }

    @Test
    public void testPlayerDistanceFromTreasure(){

        String currentPlayerposition = "0,0";
        String treasurePosition = "3,3";
        int playerDistanceToTreasure = gameBoard.playerDistanceFromTeasure(currentPlayerposition, treasurePosition);

        boolean distance = playerDistanceToTreasure > 0;

        assertTrue(distance);
    }

    private static int[] convertStringToArray(String splited) {
        String temp = splited;
        int[] coordinateArrays = new int[splited.length()];
        String[] splitedArray = temp.split(",");

        for(int i =0; i < splitedArray.length; i++){
            coordinateArrays[i] = Integer.parseInt( splitedArray[i] );
        }
        return coordinateArrays;
    }


}
