package com.hexlet;

import com.hexlet.tictac.Board;
import com.hexlet.tictac.IOPart;
import com.hexlet.tictac.Player;

public class Main {
    public static void main(String[] args){
        System.out.println("Creating board...");
        IOPart io = new IOPart();
        String gameMode = io.askGameMode();
        Board board = new Board(3, gameMode);
        if (gameMode.equals(Board.HUMAN_MODE))
        {
            Player player1 = new Player();
            io.askPlayerInfo(player1, "Player1");
            Player player2 = new Player();
            io.askPlayerInfo(player2, "Player2");
            while (true)
            {
                io.goPlayer(player1);
                io.showBoard(board);
                if (board.checkWin())
                {
                    io.celebrateWinner(player1);
                    break;
                }
                io.goPlayer(player2);
                io.showBoard(board);
                if (board.checkWin())
                {
                    io.celebrateWinner(player2);
                    break;
                }
            }
        }
        else
        {
            io.showBoard(board);
        }

    }
}
