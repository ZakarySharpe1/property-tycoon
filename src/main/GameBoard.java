package main;

import Tiles.Tile;
import misc.Card;

import java.util.ArrayList;

public class GameBoard {

    private static Tile[] board;
    private static ArrayList<Card> potluckCards;


    public static void main(String argv[]) {

        ConfigTranslator builder = new ConfigTranslator();
        board = builder.getTiles();

        potluckCards = builder.getPotluckChestCards();

        System.out.println(potluckCards.get(0).getAction());

        System.out.println(board[32]);

    }


}

