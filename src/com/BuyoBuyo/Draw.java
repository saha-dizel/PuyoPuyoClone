/*package com.BuyoBuyo;

public class Draw implements Runnable{
    private GameState test;

    public void run(){
        drawField();
    }

    public void drawField(Puyo[][] field){
        for(int x = 0; x < 6; x++) {
            for (int y = 6; y < 18; y++) {
                printColor(field[y][x]);
            }
            System.out.println();
        }
    }

    public void printColor(Puyo puyo){
        PuyoColor p = puyo.getColor();

        switch(p){
            case NO:
                System.out.print("N ");
                break;
            case RED:
                System.out.print("R ");
                break;
            case GREEN:
                System.out.print("G ");
                break;
            case BLUE:
                System.out.print("B ");
                break;
            case PURPLE:
                System.out.print("P ");
                break;
        }
    }

    public void setTest(GameState gs){
        test = gs;
    }
}
*/