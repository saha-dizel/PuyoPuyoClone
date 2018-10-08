package com.BuyoBuyo;

import java.util.Random;

public class Puyo {
    private PuyoColor color;

    Puyo(){
        color = PuyoColor.NO;
    }

    Puyo(Random blessRNG){
        int pick = blessRNG.nextInt(PuyoColor.values().length - 1);
        color = PuyoColor.values()[pick];
    }

    public PuyoColor getColor() {
        return color;
    }

    public void setColor(PuyoColor color) {
        this.color = color;
    }
}

enum PuyoColor {RED, BLUE, GREEN, PURPLE, NO}