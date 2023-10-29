package org.example;

import org.example.monster.Monster;
import java.util.Random;

public class GameBoard {
    Object [][] boardGrid;
    private static String  previousInitialPosition;
    private static String previousTreasurePosition;
    private static String previousMonsterPosition;

    public GameBoard(int numberOfGrids) {
        this.boardGrid = new Object[numberOfGrids][numberOfGrids];

        for(int i = 0; i < this.boardGrid.length; i++){
            for(int j = 0; j < this.boardGrid.length; j++){
                if(j%2 == 0){
                    if(i % 2 == 0 ){
                        this.boardGrid[i][j] = "0";
                    }else{
                        this.boardGrid[i][j] = "1";
                    }

                }else{
                    if(i % 2 == 0 ){
                        this.boardGrid[i][j] = "1";
                    }else{
                        this.boardGrid[i][j] = "0";
                    }
                }
            }
        }
    }

    public Object[][] getBoardGrid() {
        return boardGrid;
    }

    public void setBoardGrid(Object[][] boardGrid) {
        this.boardGrid = boardGrid;
    }

    public String getPlayerPosition() {
        Object player = new Player();
        int startRow;
        int startColumn;
        String position;

        do {
            startRow = new Random().nextInt(this.boardGrid.length);
            startColumn = new Random().nextInt(this.boardGrid.length);
            position = startRow + "," + startColumn;

        } while (!this.boardGrid[startRow][startColumn].equals("0") || position.equals(previousInitialPosition) );

        if(previousInitialPosition == null){
            previousInitialPosition = position;
        }

        previousInitialPosition = position;
        this.boardGrid[startRow][startColumn] = player;
        return position;
    }


    public String getTreasurePosition() {
        Object treasure = new Treasure();
        int startRow;
        int startColumn;
        String position;

        do {
            startRow = new Random().nextInt(this.boardGrid.length);
            startColumn = new Random().nextInt(this.boardGrid.length);
            position = startRow + "," + startColumn;

        } while (!this.boardGrid[startRow][startColumn].equals("0") || position.equals(previousTreasurePosition) );

        if(previousTreasurePosition == null){
            previousTreasurePosition = position;
        }

        previousTreasurePosition = position;
        this.boardGrid[startRow][startColumn] = treasure;
        return position;
    }

    public String[] getMonstersPosition() {
        String monsterOnePosition = getSingleMonster();
        String monsterTwoPosition = getSingleMonster();
        String[] positions = {monsterOnePosition, monsterTwoPosition};
        return positions;
    }

    private String getSingleMonster() {
        Object monster = new Monster();
        int startRow;
        int startColumn;
        String position;

        do {
            startRow = new Random().nextInt(this.boardGrid.length);
            startColumn = new Random().nextInt(this.boardGrid.length);
            position = startRow + "," + startColumn;

        } while (!this.boardGrid[startRow][startColumn].equals("0") || position.equals(previousMonsterPosition) );

        if(previousMonsterPosition == null){
            previousMonsterPosition = position;
        }

        previousMonsterPosition = position;
        this.boardGrid[startRow][startColumn] = monster;
        return position;
    }

    public int playerDistanceFromTeasure(String currentPlayerPosition, String treasurePosition){
        String playerPosition = currentPlayerPosition;
        int[] playerCoordinates = convertStringToArray(playerPosition);

        String treasurePos = treasurePosition;
        int[] treasureCoordinates  = convertStringToArray(treasurePos);

        int rowDistance = playerCoordinates[0] - treasureCoordinates [0];
        if(rowDistance < 0){
            rowDistance = Math.abs( rowDistance) ;
        }
        int columnDistance = playerCoordinates[1] - treasureCoordinates[1];
        if(columnDistance < 0){
            columnDistance = Math.abs(columnDistance);
        }

        int playerDistanceToTreasure = 0;
        if(rowDistance == 0 && columnDistance != 0){
            playerDistanceToTreasure = columnDistance;
        } else if (rowDistance != 0 && columnDistance == 0) {
            playerDistanceToTreasure = rowDistance;
        }else{
            playerDistanceToTreasure = rowDistance + columnDistance;
        }

        return playerDistanceToTreasure;
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
