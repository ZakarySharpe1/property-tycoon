package main;

import Tiles.Tile;
import misc.Card;

import java.util.ArrayList;

public class GameBoard {

    private static Tile[] board;
    private static ArrayList<Card> potluckCards;


    public static void main(String argv[]) {

        ConfigTranslator builder = new ConfigTranslator();
        board = builder.readTiles();

        potluckCards = builder.readCards("potluck");

        System.out.println(potluckCards);


    }


}

