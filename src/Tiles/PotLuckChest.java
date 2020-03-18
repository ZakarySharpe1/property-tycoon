package Tiles;

import main.ConfigTranslator;
import misc.Card;

import java.util.ArrayList;
import java.util.Collections;

public class PotLuckChest {
    private static ArrayList<Card> potLuckCards;
    PotLuckChest() {
        ConfigTranslator builder = new ConfigTranslator();
        potLuckCards = builder.getPotluckChestCards();
        Collections.shuffle(potLuckCards);
    }

    //draw card at top of potluck cards pile
    public Card drawPotLuckCard() {
        return potLuckCards.remove(0) ;
    }

    //add card to bottom of potluck cards pile
    public void placePotLuckCard(Card card) {
        potLuckCards.add(potLuckCards.size()-1, card);
    }
}
