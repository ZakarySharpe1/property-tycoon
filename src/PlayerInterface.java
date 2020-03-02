public interface PlayerInterface {
    boolean getProperties(); // return properties the player owns
    int getMoney(); // return how much money the player has
    Tile getPlayerTile(); // return the tile the player is on
    boolean getOutOfJailFree(); // return whether the player has GOJF card
    boolean getIsBankrupt(); // return whether the player is bankrupt
    String getPlayerToken(); // return a string representation of the player's token
}