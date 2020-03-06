package main;

import java.util.ArrayList;
import java.util.Random;

class Dice implements DiceInterface {

    private ArrayList<Integer> numbers;
    private int counter;
    private int d1;
    private int d2;







//    public int rollDice(){
//
//        Random random = new Random();
//
//        d1 = random.nextInt(5) + 1;
//        d2 = random.nextInt(5) + 1;
//
//
//        if (d1 != d2) {
//
//            return (d1 + d2);
//
//
//        } else {
//
//            counter++;
//
//
//            movePlayer(d1+d2);
//
//
//
//        }
//
//        return 0;
//
//
//    }

    @Override
    public int rollDice(){

        Random r = new Random();
        return r.nextInt(5)+1;

    }



    }









