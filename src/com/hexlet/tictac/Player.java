package com.hexlet.tictac;

public class Player {
    private String name;

    private String ip;

    public Player(){
        super();
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
}
