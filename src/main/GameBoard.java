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



    public void playerTurn(Player player){


        movePlayer(player, dice.rollDice());




    }







// THIS NEEDS TO BE REDONE TO WORK WITH THE NEW WAY WE ARE TRACKIN GPLAYERS POSITIONS, IN THE playerPos dictionary
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

