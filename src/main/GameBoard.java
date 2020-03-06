package main;

import Tiles.Tile;
import misc.Card;

import java.util.ArrayList;
import java.util.Map;

public class GameBoard {

    private static Tile[] board;
    private static ArrayList<Card> potluckCards;
    private static Dice dice;
    private static Player player;
    private static Map<Player, Integer> playerPos;




    public GameBoard(){

        ConfigTranslator builder = new ConfigTranslator();
        board = builder.getTiles();
        dice = new Dice();
        player = new Player();


        potluckCards = builder.getPotluckChestCards();

        System.out.println(potluckCards.get(0).getAction());

        System.out.println(board[32]);

    }


    public void testRun(){

        for(int i = 0; i<100; i++) {



            movePlayer(player,dice.rollDice());

            System.out.println(player.getPlayerPosition());
        }



    }



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

