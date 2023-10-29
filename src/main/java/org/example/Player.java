package org.example;
import java.util.Arrays;

public class Player {
    private int move;
    private int direction;

    private int xPostion;

    private int yPostion;

    public Player() {
    }

    public Player(int xPostion, int yPostion) {
        this.xPostion = xPostion;
        this.yPostion = yPostion;
    }

    public int getxPostion() {
        return xPostion;
    }

    public void setxPostion(int xPostion) {
        this.xPostion = xPostion;
    }

    public int getyPostion() {
        return yPostion;
    }

    public void setyPostion(int yPostion) {
        this.yPostion = yPostion;
    }

    public int getMove() {
        return move;
    }

    public void setMove(int move) {
        this.move = move;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public String getPlayerPosition(){
        return this.xPostion+","+this.yPostion;
    }

    public String navigateMove(String playerPosition, int steps, String direction, int gridSize) {
        String[] splited = playerPosition.split(",");

        int[] coordinateArrays = new int[splited.length];
        for(int i =0; i < splited.length; i++){
            coordinateArrays[i] = Integer.parseInt(splited[i]);
        }

        if(direction.equals("R") ){
            coordinateArrays[1] = coordinateArrays[1] + steps;
        } else if (direction.equals("D")) {
            coordinateArrays[0] = coordinateArrays[0] + steps;
        } else if (direction.equals("L")) {
            coordinateArrays[1] = coordinateArrays[1] - steps;
        } else if (direction.equals("U")) {
            coordinateArrays[0] = coordinateArrays[0] - steps;
        }

        if(coordinateArrays[0] < 0 || coordinateArrays [1] < 0 || coordinateArrays[0] >= gridSize
                || coordinateArrays[1] >= gridSize ){
            return "Invalid Entry";
        }

        return coordinateArrays[0]+","+coordinateArrays[1];
    }
}
