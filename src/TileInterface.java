import java.util.ArrayList;

interface TileInterface {
    boolean getBuyable(); // returns tileBuyable
    void setBuyable(boolean YesOrNo); // sets tileBuyable to true or false
    ArrayList<Player> getPlayers(); // returns list of players currently on tile
    void addPlayer(Player player); // appends player to tilePlayers
    void removePlayer(Player player); // removes player from tilePlayers
    void getTileName(); // returns tileName
    void setTileName(String name); // sets tileName to name
    void getTilePos(); // returns tilePosition
    void setTilePos(int position); // Sets tilePosition variable to position of tile in GameBoard
}