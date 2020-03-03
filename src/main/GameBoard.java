package main;

import Tiles.Tile;

public class GameBoard {

    private static Tile[] board;


    public static void main(String argv[]) {

        ConfigReader builder = new ConfigReader();
        board = builder.ConfigReader();


    }


}

