package main;

import Tiles.Tile;
import misc.Card;

import java.util.ArrayList;
import java.util.Map;

public class GameBoard {

    private static Tile[] board;
    private static ArrayList<Card> potluckCards;
    private static ArrayList<Card> oppourtunityKnocksCards;
    private static Dice dice;
    private static Map<Player, Integer> playerPos;




    public GameBoard(Player[] players){


        // sets all players position to GO tile at 0
        for(Player player: players){
            playerPos.put(player, 0);
        }


        ConfigTranslator builder = new ConfigTranslator(); // This ceases to exist after initialization

        board = builder.getTiles();
        dice = new Dice();
        potluckCards = builder.getPotluckChestCards();
        oppourtunityKnocksCards = builder.getCommunityChestCards();
    }


    // Functional dice setup, logic should be working
    // Logic behind rolling doubles and when to go to jail setup
    // Need the process of going to jail to be implemented
    public void playerTurn(Player player){
        int i = 1;
        int num = 0;

        while (i < 4){
            num = dice.rollDice();
            // If on the third roll, a double is rolled
            // Player gets sent to jail
            if((i == 3) && (num > 12)){
                //Player goes to jail

            }
            // If a double is rolled, 12 is added to value in rollDice()
            // Therefore, remove the added 12 and move player
            // Then roll the dice again
            else if(num > 12){
                num = num - 12;
                movePlayer(player, num);
                i = i + 1;
            }
            // If the two dice are different, move player value of dice combined
            else{
                movePlayer(player,num);
                i = 4;
            }
        }
    }








// need to implement moving backwards condition
    public void movePlayer(Player player, int moves){

        int position = player.getPlayerPosition();
        int moveTo = position + moves;

        if(moveTo > 39){
            //change this based on go tile amount set (for now 200)
            player.payPlayer(200);
            player.setPlayerPosition(moveTo - 40);

        }else{
            player.setPlayerPosition(moveTo);
        }
    }


    //check if the player has landed on another players properties etc
    public void checkBoardCircumstances(){}



}

