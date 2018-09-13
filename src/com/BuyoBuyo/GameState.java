package com.BuyoBuyo;

import java.util.Random;

public class GameState {
    private Puyo[][] field;
    private Puyo[] next;
    private Puyo[] drop;
    private long score;
    private Random blessRNG;

    GameState(){
        field = new Puyo[12][6];
        for(Puyo[] e: field)
            for (Puyo g: e)
                g = new Puyo();

        score = 0;

        //getting random seed
        blessRNG = new Random(System.currentTimeMillis());

        next = genNext();
    }

    public int mainLoop(){
        drop = genDrop(next);

        next = genNext();

        //player drops puyo on the field

        //count score here as well
        field = clearPuyo(field);

        if(isGameOver(field))
            return 0;

        //if not => repeat loop

        //if lost => return 0
        //if exit from pause (if u will do pause, lol) => return 1
        return 1;
    }

    public Puyo[] genNext(){
        Puyo[] nextBlock = new Puyo[2];
        nextBlock[0] = new Puyo(blessRNG);
        nextBlock[1] = new Puyo(blessRNG);

        return nextBlock;
    }

    public Puyo[] genDrop(Puyo[] next){
        Puyo[] newDrop = new Puyo[2];
        newDrop[0] = next[0];
        newDrop[1] = next[1];

        return newDrop;
    }

    public Puyo[][] clearPuyo(Puyo[][] field){
        /*TIER LISTS EXISTED IN PUYO PUYO! OMG*/

        //go through the field, if can clear something, then count it, clear it, add score and then
        //field = this.clearPuyo(field);

        //about score: add it by using this simplified formula: score += 10 * (clearedPuyoCount + chainNum - 1)

        return field;
    }

    private boolean isGameOver(Puyo[][] field){
        if (field[0][2] != null)
            return true;
        else
            return false;
    }

    public Random getBlessRNG() {
        return blessRNG;
    }
}
