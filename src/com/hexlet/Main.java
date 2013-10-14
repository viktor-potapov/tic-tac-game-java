package com.hexlet;

import com.hexlet.tictac.Board;
import com.hexlet.tictac.IOPart;

public class Main {
    public static void main(String[] args){
        System.out.println("Creating board...");
        Board board = new Board(3);
        IOPart io = new IOPart();
        io.showBoard(board);
    }
}
