package main;

import Tiles.Tile;
import misc.Card;

import java.util.ArrayList;

public interface ConfigTranslatorInterface {
    Tile[] readTiles();
    ArrayList<Card> readCards(String potluckorcommunitychest);
}
