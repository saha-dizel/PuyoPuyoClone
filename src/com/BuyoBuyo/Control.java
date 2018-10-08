package com.BuyoBuyo;

public class Control {
    private int controlElemX;
    private int controlElemY;
    private int nonControlElemX;
    private int nonControlElemY;
    private int orientation;

    public int getOrientation() {
        return orientation;
    }
    public int getControlElemX() {
        return controlElemX;
    }
    public int getControlElemY() {
        return controlElemY;
    }
    public int getNonControlElemX() {
        return nonControlElemX;
    }
    public int getNonControlElemY() {
        return nonControlElemY;
    }
    public int getLower(){
        if (controlElemY > nonControlElemY)
            return controlElemY;
        else
            return nonControlElemY;
    }

    public void setControlElemX(int controlElemX) {
        this.controlElemX = controlElemX;
    }
    public void setControlElemY(int controlElemY) {
        this.controlElemY = controlElemY;
    }
    public void setNonControlElemX(int nonControlElemX) {
        this.nonControlElemX = nonControlElemX;
    }
    public void setNonControlElemY(int nonControlElemY) {
        this.nonControlElemY = nonControlElemY;
    }
    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }

    /* orientation of nonControl puyo: 0-up, 1-right, 2-down, 3-left
     * moving clockwise, basically */

    //starting position for puyo drops
    Control(){
        controlElemX = 2;
        controlElemY = 5;
        nonControlElemX = 2;
        nonControlElemY = 6;
        orientation = 2;
    }

    public void lowerBlock(){
        controlElemY++;
        nonControlElemY++;
    }

    //rotating around control block, movement shown for nonControl
    public void rotateClockwise(){
        orientation = (orientation + 1) % 4;
        moveToOrient();
    }
    public void rotateCounterClockwise(){
        if (orientation == 0)
            orientation = 3;
        else
            orientation--;
        moveToOrient();
    }

    public void moveToOrient(){
        switch(orientation){
            case 0:
                nonControlElemX = controlElemX;
                nonControlElemY = controlElemY - 1;
                break;
            case 1:
                nonControlElemX = controlElemX + 1;
                nonControlElemY = controlElemY;
                break;
            case 2:
                nonControlElemX = controlElemX;
                nonControlElemY = controlElemY + 1;
                break;
            case 3:
                nonControlElemX = controlElemX - 1;
                nonControlElemY = controlElemY;
                break;
        }
    }
}
