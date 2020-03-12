package main;

import java.util.ArrayList;
import java.util.Random;

class Dice implements DiceInterface {
    private int d1;
    private int d2;

    /**
     * rollDice will roll two 6 sided dice and combine to return one value
     * @return value of dice combined (plus 12 if a double)
     */
    @Override
    public int rollDice(){
        Random r = new Random();

        d1 = r.nextInt(5) + 1;
        d2 = r.nextInt(5) + 1;

        if(d1 == d2){
            d1 = d1 + 12;
        }

        return d1+d2;

    }
}









