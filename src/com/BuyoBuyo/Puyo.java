package com.BuyoBuyo;

import java.util.Random;

public class Puyo {
    private puyoColor color;

    Puyo(){
        color = null;
    }

    Puyo(Random blessRNG){
        int pick = blessRNG.nextInt(puyoColor.values().length);
        color = puyoColor.values()[pick];
    }

    public puyoColor getColor() {
        return color;
    }

    public void setColor(puyoColor color) {
        this.color = color;
    }
}

enum puyoColor {RED, BLUE, GREEN, PURPLE}