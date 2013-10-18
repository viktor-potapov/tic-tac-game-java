package com.hexlet.tictac;

public class Player {
    private String name;

    private String ip;

    private char symbol = Cell.EMPTY_SYMBOL;

    private Boolean isHuman;

    private Boolean isFirst;

    public Player(char symbol){
        this(symbol, "Human", true, false);
    }

    public Player(char symbol, String name, boolean isHuman, boolean isFirst){
        if (symbol == Cell.X_SYMBOL || symbol == Cell.O_SYMBOL)
        {
            this.symbol = symbol;
        }
        this.setName(name);
        this.isHuman = isHuman;
        this.isFirst = isFirst;
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

    public Boolean getIsHuman() {
        return this.isHuman;
    }

    public Boolean getIsFirst() {
        return this.isFirst;
    }
}
