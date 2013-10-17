package com.hexlet;

import com.hexlet.tictac.Board;
import com.hexlet.tictac.Cell;
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
            Player player1 = new Player(Cell.X_SYMBOL);
            io.askPlayerInfo(player1, "Player1");
            Player player2 = new Player(Cell.O_SYMBOL);
            io.askPlayerInfo(player2, "Player2");
            while (true)
            {
                if (playerAction(player1, io, board))
                {
                    break;
                };
                if (playerAction(player2, io, board))
                {
                    break;
                };
            }
        }
        else
        {
            io.showBoard(board);
        }
    }

    private static Boolean playerAction(Player player, IOPart io, Board board){
        Boolean isEndOfGame = false;
        io.goPlayer(player, board);
        io.showBoard(board);
        if (board.checkDraw())
        {
            io.celebrateDraw();
            isEndOfGame = true;
        }
        if (board.checkWin(player.getSymbol()))
        {
            io.celebrateWinner(player);
            isEndOfGame = true;
        }
        return isEndOfGame;
    }
}
