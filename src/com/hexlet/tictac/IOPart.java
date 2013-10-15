package com.hexlet.tictac;

import java.util.Scanner;

public class IOPart {

    private Scanner sc;

    public IOPart(){
        sc = new Scanner(System.in);
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

    public void askPlayerInfo(Player player, String firstName) {
        System.out.print("Could you please enter "+ firstName +" name:");
        String testName = sc.nextLine();
        if (!testName.equals(""))
        {
            player.setName(testName);
        }
        else
        {
            System.out.println("You input empty name for "+firstName+".");
        }

    }

    public void celebrateWinner(Player player)
    {
        System.out.print("Congratulations! "+ player.getName()+" is winner!");
    }

    public String askGameMode() {
        String gameMode;
        System.out.print("Do you want to play with human or computer? (human/comp):");
        gameMode=sc.nextLine();
        if (gameMode.equals(Board.HUMAN_MODE) || gameMode.equals(Board.COMP_MODE))
        {
            return gameMode;
        }
        System.out.print("Incorrect answer. Have to be \"human\" or \"comp\". ");
        return  this.askGameMode();
    }
}
