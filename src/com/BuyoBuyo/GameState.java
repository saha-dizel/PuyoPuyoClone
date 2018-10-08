package com.BuyoBuyo;

import java.util.Random;

public class GameState {
    private Puyo[][] field;
    private Puyo[] next;
    private Puyo[] drop;
    private long score;
    private Random blessRNG;
    private int count = 0;

    GameState(){
        //initialising field
        field = new Puyo[18][6];

        for (int i = 0; i < 18; i++){
            for (int j= 0; j < 6; j++)
                field[i][j] = new Puyo();
        }

        score = 0;

        //getting random seed
        blessRNG = new Random(System.currentTimeMillis());

        //initialising first pair
        next = genNext();

        //starting the game loop
        int gameRes = mainLoop();

        //maybe add records, if feeling fancy
    }

    private int mainLoop(){
        while(true) {
            drop = genDrop(next);

            next = genNext();

            //player drops puyo on the field
            dropIt(drop);

            //count score here as well
            field = clearPuyo(field);

            count++;

            if (isGameOver(field))
                return count;
        }
        //if not => repeat loop

        //if lost => return 0
        //if exit from pause (if u will do pause, lol) => return 1
    }

    private Puyo[] genNext(){
        Puyo[] nextBlock = new Puyo[2];
        nextBlock[0] = new Puyo(blessRNG);
        nextBlock[1] = new Puyo(blessRNG);

        return nextBlock;
    }

    private Puyo[] genDrop(Puyo[] next){
        Puyo[] newDrop = new Puyo[2];
        newDrop[0] = next[0];
        newDrop[1] = next[1];

        return newDrop;
    }

    //check if you can drop it
    private boolean need2Drop(Control control){
        if (control.getLower() < 17) {
            if (control.getOrientation() % 2 == 0 &&
                    field[control.getLower() + 1][control.getControlElemX()].getColor() == PuyoColor.NO ||
                    control.getOrientation() % 2 == 1 &&
                            field[control.getLower() + 1][control.getControlElemX()].getColor() == PuyoColor.NO &&
                            field[control.getLower() + 1][control.getNonControlElemX()].getColor() == PuyoColor.NO)
                return true;
            else return false;
        }
        else return false;
    }

    private void dropIt(Puyo[] drop){
        Control control = new Control();
        //starting position on the field: [0] - [5][2]; [1] - [6][2]
        field[control.getControlElemY()][control.getControlElemX()].setColor(drop[0].getColor());
        field[control.getNonControlElemY()][control.getNonControlElemX()].setColor(drop[1].getColor());

        //while u can lower it DROP IT
        while(need2Drop(control)){
            field[control.getControlElemY()][control.getControlElemX()].setColor(PuyoColor.NO);
            field[control.getNonControlElemY()][control.getNonControlElemX()].setColor(PuyoColor.NO);
            control.lowerBlock();
            field[control.getControlElemY()][control.getControlElemX()].setColor(drop[0].getColor());
            field[control.getNonControlElemY()][control.getNonControlElemX()].setColor(drop[1].getColor());
        }
    }

    private Puyo[][] clearPuyo(Puyo[][] field){
        //go through the field, if can clear something, then count it, clear it, add score and then
        //field = clearPuyo(field);

        //about score: add it by using this simplified formula: score += 10 * (clearedPuyoCount + chainNum - 1)

        return field;
    }

    //public just for test purposes, change to private after
    public boolean isGameOver(Puyo[][] field){
        if (field[6][2].getColor() != PuyoColor.NO)
            return true;
        else
            return false;
    }

    public int getCount(){
        return count;
    }

    public Random getBlessRNG() {
        return blessRNG;
    }
    public Puyo[][] getField() {
        return field;
    }
}
