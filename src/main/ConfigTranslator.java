package main;

import Tiles.*;
import misc.Card;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.*;


/**
 * Translates provided configuration file into game Tile and Card objects for the board.
 */


public class ConfigTranslator implements ConfigTranslatorInterface {

    private Tile[] tileList = new Tile[40];
    private ArrayList<ArrayList<Card>> cardDecks;

    private DocumentBuilderFactory docBuilderFactory;
    private DocumentBuilder docBuilder;
    private Document document;


    /**
     * Initialises instance variables and builds node lists
     */

    public ConfigTranslator() {

        try {

            File file = new File("resources/config/property-config.xml");

            docBuilderFactory = DocumentBuilderFactory.newInstance();
            docBuilder = docBuilderFactory.newDocumentBuilder();
            document = docBuilder.parse(file);
            document.getDocumentElement().normalize();


            genTiles();
            genCards();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Generates a list of set up Tile objects for the game board.
     */
    @Override
    public void genTiles() {

        NodeList tileNodeList = document.getElementsByTagName("tile");

        for (int i = 0; i < 40; i++) {

            Node aNode = tileNodeList.item(i);

            if (aNode.getNodeType() == Node.ELEMENT_NODE) {
                Element tileElement = (Element) aNode;
                Tile tile = new Tile();


                try {
                    switch (tileElement.getElementsByTagName("type").item(0).getTextContent()) {

                        case "property":

                            List<String> houses = Arrays.asList("one-house", "two-house", "three-house", "four-house", "hotel");

                            tile.setTileName(tileElement.getElementsByTagName("name").item(0).getTextContent());
                            tile = new Property();
                            tile.setBuyable(true);

                            ((Property) tile).setColour(tileElement.getElementsByTagName("colour").item(0).getTextContent());

                            for (String house : houses) {
                                ((Property) tile).addHousePrice(Integer.parseInt(tileElement.getElementsByTagName(house).item(0).getTextContent()));
                            }
                            break;

                        case "go":

                            tile = new Go();

                            break;
                        case "jail":

                            tile = new Jail();
                            break;
                        case "tax":

                            tile = new Tax();
                            break;
                        case "communitychest":

                            tile = new CommunityChest();
                            break;
                        case "station":

                            tile = new Station();
                            tile.setBuyable(true);
                            break;
                        case "parking":

                            tile = new FreeParking();
                            break;
                        case "gotojail":

                            tile = new GoToJail();

                            break;
                        case "potluck":
                            tile = new PotLuck();
                            break;

                    }


                    //ASK IF WATSON GAMES WANTS CHANGEABLE NAMES FOR JAIL FOR THEMABLE GAMES
                    //tile.setTileName(tileElement.getElementsByTagName("name").item(0).getTextContent());


                    tile.setTilePos(i);
                    tileList[i] = tile;

                } catch (Exception e) {

                    System.out.println("error in config file setup");

                }

            }
        }

    }


    /**
     * Generates lists of set up Card objects for the community chest and potluck draws.
     *
     * @param
     */


    @Override
    public void genCards() {

        ArrayList<NodeList> cardNodeLists = new ArrayList<>();
        cardDecks = new ArrayList<>();

        cardNodeLists.add(document.getElementsByTagName("potluckcard"));
        cardNodeLists.add(document.getElementsByTagName("communitychestcard"));


        for (NodeList nodes : cardNodeLists) {

            ArrayList<Card> cardList = new ArrayList<>();

            for (int i = 0; i < nodes.getLength(); i++) {


                Node aNode = nodes.item(i);

                if (aNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element cardElement = (Element) aNode;

                    Card card = new Card();


                    try {

                        card.setValue(Integer.parseInt(cardElement.getElementsByTagName("value").item(0).getTextContent()));
                        card.setAction(cardElement.getElementsByTagName("action").item(0).getTextContent());
                        cardList.add(card);

                    } catch (Exception e) {

                        System.out.println("error in config file card setup");

                    }


                }
            }

            cardDecks.add(cardList);
        }
    }

    public ArrayList<Card> getCommunityChestCards() {

        return cardDecks.get(0);


    }

    public ArrayList<Card> getPotluckChestCards() {

        return cardDecks.get(0);


    }

    public Tile[] getTiles() {


        return tileList;

    }

}
