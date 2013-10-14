package com.hexlet.tictac;

public class IOPart {
    public IOPart(){
        super();
    }

    public void goPlayer(Player parameter) {
        // TODO : to implement
    }

    public void showBoard(Board board) {
        showPriceTable(board);
        showPlayerTable(board);
    }

    private void showPriceTable(Board board){
        int size =  board.getBoardSize();
        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                System.out.print("["+board.getField(i, j).getPrice()+"]");
            }
        System.out.println();
        }
    }

    private void showPlayerTable(Board board){
        int size =  board.getBoardSize();
        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                System.out.print("["+board.getField(i, j).getSymbol()+"]");
            }
            System.out.println();
        }
    }

    public void askPlayerInfo(Player parameter) {
        // TODO : to implement
    }
}
