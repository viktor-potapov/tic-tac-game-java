package com.hexlet.tictac;

public class Player {
    private String name;

    private String ip;

    private char symbol = Cell.EMPTY_SYMBOL;

    public Player(char symbol){
       if (symbol == Cell.X_SYMBOL || symbol == Cell.O_SYMBOL)
       {
           this.symbol = symbol;
       }
    }

    public void setName(String name) {
        if (!name.equals(""))
        {
            this.name = name;
        }
    }

    public String getName() {
        return this.name;
    }

    public char getSymbol() {
        return this.symbol;
    }
}
