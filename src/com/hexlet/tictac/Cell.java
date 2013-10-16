package com.hexlet.tictac;

public class Cell {

    public final static char EMPTY_SYMBOL = ' ';
    public final static char X_SYMBOL = 'x';
    public final static char O_SYMBOL = 'o';

    private int price;

    private char symbol = EMPTY_SYMBOL;

    private int x;

    private int y;

    public Cell(int x, int y, int price){
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

    public boolean getIsFilled() {
        return (symbol != EMPTY_SYMBOL);
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
