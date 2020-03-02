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

    @Override
    public ArrayList<Tile> getProperties(){
        return properties;
    }

    @Override
    public int getMoney(){
        return balance;
    }

    @Override
    public Tile getPlayerTile(){
        return position;
    }

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

    @Override
    public String getPlayerToken(){
        // This needs work depending on how we want to implement game pieces
        return gameToken;
    }
}
