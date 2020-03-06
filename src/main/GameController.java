package main;


import java.util.EventListener;

public class GameController implements GameControllerInterface {


    private int height;
    private int width;
    private boolean running;

    private static GameBoard board;


    public static void main(String[] args) {


        board = new GameBoard();
        board.testRun();


    }
//
//    public void runGame() {
//        while (running) {
//
//            for(Player player: players){
//
//                boolean playingTurn = true;
//
//                EventListener e = new EventListener(){
//
//
//
//
//
//                };
//
//
//
//                while(playingTurn){
//
//                }
//
//
//
//
//
//            }
//
//
//
//
//        }
//    }
//
//
//    }






    @Override
    public void endGame() {

    }



}
