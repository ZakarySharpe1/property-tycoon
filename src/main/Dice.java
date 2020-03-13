package main;

import java.util.ArrayList;
import java.util.Random;

class Dice implements DiceInterface {
    private int d;

    /**
     * rollDice will roll two 6 sided dice and combine to return one value
     * @return value of dice combined (plus 12 if a double)
     */
    @Override
    public int rollDice(){
        Random r = new Random();

        d = r.nextInt(5) + 1;

        return d;

    }
}









