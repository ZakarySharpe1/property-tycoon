package main;

import Tiles.Tile;
import misc.Card;

import java.util.ArrayList;

public class GameBoard {

    private static Tile[] board;
    private static ArrayList<Card> potluckcards;


    public static void main(String argv[]) {

        ConfigReader builder = new ConfigReader();
        board = builder.readTiles();

        potluckcards = builder.readCards("potluck");

        System.out.println(potluckcards);


    }


}

