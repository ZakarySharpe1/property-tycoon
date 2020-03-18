package Tiles;

import main.ConfigTranslator;
import misc.Card;

import java.util.ArrayList;
import java.util.Collections;

public class OpportunityKnocksChest extends Tile implements OpportunityKnocksInterface {
    private static ArrayList<Card> opportunityKnocksCards;
    OpportunityKnocksChest() {
        ConfigTranslator builder = new ConfigTranslator();
        opportunityKnocksCards = builder.getCommunityChestCards();
        Collections.shuffle(opportunityKnocksCards);
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
