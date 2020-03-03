package main;

import Tiles.Tile;
import main.ConfigReader;

import java.util.ArrayList;
import java.util.Map;

public class GameBoard{

    private static Tile[] board;


    public static void main(String argv[]) {

        board = new Tile[40];

        ConfigReader builder = new ConfigReader();
        ArrayList<Map> tileList = builder.ConfigReader();

        for(int i = 0; i < 40;i++){


            Tile tile = new Tile();

            tile.setTileName((String) tileList.get(i).get("name"));

            board[i] = tile;


        }



    }
}
