package org.example;

import org.example.monster.Dragon;
import org.example.monster.WereWolf;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int[] playerPositions;
        boolean continuePlay = false;
        String currentPlayerPosition;
        int steps;
        String direction;
        int gridSize;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Grid Size: ");
        gridSize = scanner.nextInt();

        GameBoard gameBoard = new GameBoard(4);

        playerPositions = convertStringToArray(gameBoard.getPlayerPosition());
        Player player = new Player(playerPositions[0], playerPositions[1]);
        String treasurePosition = gameBoard.getTreasurePosition();
        String monsterOnePosition = gameBoard.getMonstersPosition()[0];
        String monsterTwoPosition = gameBoard.getMonstersPosition()[1];

        System.out.println("Treasure Position is :" + treasurePosition );
        System.out.println("Player Starting Position is :" + player.getPlayerPosition() );
        System.out.println("Monster 1 position : " + monsterOnePosition);
        System.out.println("Monster 2 position : " + monsterTwoPosition );


        do {
            int distanceFromTreasure = gameBoard.playerDistanceFromTeasure(player.getPlayerPosition(), treasurePosition);
            if(distanceFromTreasure == 0){
                System.out.println("Game Over, You Won");
                continuePlay = false;
                break;
            }

            System.out.println("Player distance from Treasure in steps is "
                    + distanceFromTreasure);

            System.out.println("Enter Number of Steps - Multiples of 2 only: ");
            steps = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Enter Direction: ");
            System.out.println("L for Left, R for Right, D for Down, U for Up");
            direction = scanner.nextLine();

            currentPlayerPosition = player.navigateMove(player.getPlayerPosition(), steps, direction, gridSize);

            while(currentPlayerPosition.equals("Invalid Entry")){
                System.out.println("You Entered Invalid Move: ");
                System.out.println("Enter Number of Steps - Multiples of 2 only: ");
                steps = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Enter Direction: ");
                System.out.println("L for Left, R for Right, D for Down, U for Up");
                direction = scanner.nextLine();
                currentPlayerPosition = player.navigateMove(player.getPlayerPosition(), steps, direction, gridSize);
            }

            if (currentPlayerPosition.equals(gameBoard.getTreasurePosition())) {
                System.out.println("Game Over, You Won");
                continuePlay = false;
            } else if (currentPlayerPosition.equals(monsterOnePosition)) {
                Dragon dragon =new Dragon();
                System.out.println( dragon.monsterGreeting() );
                System.out.println("Monster Caught You");
                continuePlay = false;
            } else if (currentPlayerPosition.equals(monsterTwoPosition )) {
                System.out.println("Second Monster Caught You");
                WereWolf wereWolf = new WereWolf();
                System.out.println( wereWolf.monsterGreeting() );
                continuePlay = false;
            }else {
                continuePlay = true;
            }

            int[] newPlayerPosition = convertStringToArray(currentPlayerPosition);
            player.setxPostion(newPlayerPosition[0]);
            player.setyPostion(newPlayerPosition[1]);

        }while( continuePlay );

        System.out.println("Game End");
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
