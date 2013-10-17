package com.hexlet.tictac;

public class Cell {

    public final static char EMPTY_SYMBOL = ' ';
    public final static char X_SYMBOL = 'x';
    public final static char O_SYMBOL = 'o';

    private int price;
    private char symbol = EMPTY_SYMBOL;

    public Cell(int price){
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
}
