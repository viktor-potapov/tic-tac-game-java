package com.hexlet.tictac;

public class Field {

    private int price;

    private boolean isFilled;

    private char symbol;

    private int x;

    private int y;

    public Field(int x, int y, int price){
        this.setX(x);
        this.setY(y);
        this.setPrice(price);
    }

    public void setPrice(int price) {
        this.price =  price;
    }

    public int getPrice() {
        return price;
    }

    public void setIsFilled(boolean parameter) {
        // TODO : to implement
    }

    public boolean getIsFilled() {
        return isFilled;
    }

    public void setSymbol(char parameter) {
        symbol = parameter;
    }

    public char getSymbol() {
        return symbol;
    }


    public void setX(int parameter) {
        // TODO : to implement
    }

    public int getX() {
        // TODO : to implement
        return 0;
    }

    public void setY(int parameter) {
        // TODO : to implement
    }

    public int getY() {
        // TODO : to implement
        return 0;
    }
}
