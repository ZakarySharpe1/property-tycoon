package main;

import java.util.ArrayList;
import java.util.Random;

class Dice implements DiceInterface {
    private int counter;
    private int d1;
    private int d2;

    @Override
    public void reset(){
        counter = 0;
        d1 = 0;
        d2 = 0;
    }


    @Override
    public boolean rollDice(){
        Random r = new Random();

        d1 = r.nextInt(5) + 1;
        d2 = r.nextInt(5) + 1;
        counter++;

        if(d1 == d2){
            return true;
        }
        else{
            return false;
        }
    }


    @Override
    public boolean jailCheck(){
        if((d1 == d2) && (counter == 3)){
            return true;
        }
        else{
            return false;
        }
    }


    @Override
    public int getValue(){
        return d1+d2;
    }
}









