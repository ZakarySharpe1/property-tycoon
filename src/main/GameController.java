package main;

public interface GameController {
    void endGame(); //ends game if called by setting gameRunning Boolean instance variable to false
    int rollDice(); //returns a random integer between 1-12
    int getPotLuck(); //returns an int to use in a switch statement that carries out respective potLuck functionality
    int getOpportunityKnocks(); //returns an int to use in a switch statement that carries out respective opportunityKnocks functionality
}
