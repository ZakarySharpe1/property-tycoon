package main;

import Tiles.Tile;
import misc.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

public class GameBoard {

    private static Tile[] board;
    private static ArrayList<Card> potLuckCards;
    private static ArrayList<Card> opportunityKnocksCards;
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
        potLuckCards = builder.getPotluckChestCards();
        opportunityKnocksCards = builder.getCommunityChestCards();
        Collections.shuffle(potLuckCards);
        Collections.shuffle(opportunityKnocksCards);


    }



    public void playerTurn(Player player){


        movePlayer(player, dice.rollDice());




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

    //draw card at top of potluck cards pile
    public Card drawPotLuckCard() {
        return potLuckCards.remove(0) ;
    }

    //add card to bottom of potluck cards pile
    public void placePotLuckCard(Card card) {
        potLuckCards.add(potLuckCards.size()-1, card);
    }

    //draw card at top of opportunityKnocks cards pile
    public Card drawOpportunityKnocksCard() {
        return opportunityKnocksCards.remove(0);
    }

    //add card to bottom of opportunityKnocks cards pile
    public void placeOpportunityKnocksCard(Card card) {
        opportunityKnocksCards.add(opportunityKnocksCards.size()-1, card);
    }
}

