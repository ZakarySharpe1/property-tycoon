package main;

import Tiles.Tile;

import java.util.ArrayList;

public class Player implements PlayerInterface {
    private ArrayList<Tile> properties;
    private ArrayList<Tile> morgagedProperties;
    private int balance;
    private Tile position;
    private int getOfJailCards;
    private String gameToken;

    public Player(){
        getOfJailCards = 0;
    }

    /**
     * getProperties returns an array list with all the properties that the player owns
     * @return returns properties, ArrayList with all the properties player owns
     */
    @Override
    public ArrayList<Tile> getProperties(){
        return properties;
    }

    /**
     * getMoney returns an integer that represents the current balance of the player (how much money he has)
     * @return returns balance as an integer
     */
    @Override
    public int getMoney(){
        return balance;
    }

    /**
     * getPlayerTile will return the object tile that the player is currently standing on
     * @return returns position as an tile object
     */
    @Override
    public Tile getPlayerTile(){
        return position;
    }

    /**
     * getOutOfJailFree will return true if player has at least one card and false otherwise
     * @return returns true or false depending if "get out of jail" card is present or not
     */
    @Override
    public boolean getOutOfJailFree(){
        if(getOfJailCards > 0){
            getOfJailCards--;
            return true;
        }
        else{
            return false;
        }
    }

    /*boolean getIsBankrupt(int cost){
        if (balance < cost){
            int subcost = 0;
            for(int i = 0; i<properties.size();i++){
            // Need to implement properties first
                subcost += properties[i].
            }
        }
        else{
            return false;
        }
    }*/

    /**
     * getPlayerToken will return the game piece that the player is using in the current game
     * @return returns gameToken as a string
     */
    @Override
    public String getPlayerToken(){
        // This needs work depending on how we want to implement game pieces
        return gameToken;
    }
}
