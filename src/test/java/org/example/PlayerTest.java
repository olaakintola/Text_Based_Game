package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {
    private Player player;

    @BeforeEach
    public void setUp(){
        player = new Player();
    }

    @Test
    public void navigatePlayerMove(){

        int gridSize = 4;
        GameBoard gameBoard = new GameBoard(4);
        String playerPosition = "0,0";
        String expectedNextPlayerPosition = "0,2";
        String direction = "R";
        int steps = 2;
        String actualNextPlayerPosition  = player.navigateMove(playerPosition, steps, direction, gridSize);
        assertEquals(expectedNextPlayerPosition, actualNextPlayerPosition);

    }
}
