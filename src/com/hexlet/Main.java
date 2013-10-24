package com.hexlet;

import com.hexlet.tictac.Board;
import com.hexlet.tictac.Cell;
import com.hexlet.tictac.Exceptiones.InvalidBorderConstructorParameters;
import com.hexlet.tictac.IOPart;
import com.hexlet.tictac.Player;

public class Main {
    public static void main(String[] args){
        System.out.println("Creating board...");
        IOPart io = new IOPart();
        String gameMode = io.askGameMode();
        Board board = null;
        try {
            board = new Board(3, gameMode);
        } catch (InvalidBorderConstructorParameters.SizeException e) {
            System.out.println("Board size has to be odd number");
        } catch (InvalidBorderConstructorParameters.GameModeException e) {
            System.out.println("Game mode have to be equal \"comp\" or \"human\"");
        }
        finally {
            if (board == null)
                return;
        }
        Player player1;
        Player player2;
        if (gameMode.equals(Board.HUMAN_MODE))
        {
            player1 = new Player(Cell.X_SYMBOL);
            io.askPlayerInfo(player1, "Player1");
            player2 = new Player(Cell.O_SYMBOL);
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
            if (io.askWhoFirst() == io.FIRST_GO_HUMAN)
            {
                player1 = new Player(Cell.X_SYMBOL, "Human", true, true);
                player2 = new Player(Cell.O_SYMBOL, "Computer", false, false);
            }
            else
            {
                player1 = new Player(Cell.X_SYMBOL, "Computer", false, true);
                player2 = new Player(Cell.O_SYMBOL, "Human", true, false);
            }
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
    }

    private static Boolean playerAction(Player player, IOPart io, Board board){
        Boolean isEndOfGame = false;
        if (player.getIsHuman()){
            int[] currentXY = io.askNextPlayerStep(player, board);
            board.goHuman(player, currentXY);
        }
        else {
            board.goComputer(player);
        }
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
