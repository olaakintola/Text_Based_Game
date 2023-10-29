package org.example;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TreasureTest {
    private Treasure treasure;
    private GameBoard gameBoard;

    @BeforeEach
    public void setUp(){
        treasure = new Treasure();
        gameBoard = new GameBoard(4);
    }

    @Test
    public void testTreasure_Is_Found_After_Game_Initialisation(){

        String treaurePosition = gameBoard.getTreasurePosition();
        int[] treasureCoordinates = convertStringToArray(treaurePosition);
        Treasure treasure = new Treasure(treasureCoordinates[0], treasureCoordinates[1]);
        assertFalse(treasure.isFound() );
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
