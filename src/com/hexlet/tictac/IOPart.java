package com.hexlet.tictac;

import java.util.Scanner;

public class IOPart {

    private Scanner sc;
    private final int INCORRECT_VALUE = -1;
    public final Boolean FIRST_GO_HUMAN = false;
    public final Boolean FIRST_GO_COMP = true;

    public IOPart(){
        sc = new Scanner(System.in);
    }

    /*Return correct x,y for new player step */
    public int[] askNextPlayerStep(Player player, Board board) {
        int lastIndex = board.getBoardSize()-1;
        System.out.println(player.getName() + ", could you please input x, than input y where you want to put your symbol. It has to be from 0 to "+ lastIndex+". For example 0 and 0 mark top left corner");
        int y = checkXorY(lastIndex);
        int x = checkXorY(lastIndex);
        if (x == INCORRECT_VALUE || y == INCORRECT_VALUE)
        {
            System.out.println("Parametr \"x\" and \"y\" has to have next format: only Integer and from 0 to "+ lastIndex);
            return askNextPlayerStep(player, board);
        }
        else
        {
            if (board.getField(x, y).getIsFilled())
            {
                System.out.println("This cell already has filled. Try other x, y. ");
                return askNextPlayerStep(player, board);
            }
            else
            {
                int[] currentXY = {x, y};
                return currentXY;
            }
        }
    }

    public void showBoard(Board board) {
        showPriceTable(board); //Need only for testing computer logic. Comp select cell where is max price
        showPlayerTable(board);
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
            System.out.println("You input empty name for " + firstName + ".");
        }

    }

    public void celebrateWinner(Player player)
    {
        System.out.println("Congratulations! "+ player.getName()+" is winner!");
    }

    public void celebrateDraw()
    {
        System.out.println("Congratulations! Won the friendship! You no longer have free moves.");
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

    public Boolean askWhoFirst() {
        String answer;
        System.out.print("Who has to go first? (human/comp):");
        answer=sc.nextLine();
        if (answer.equals(Board.HUMAN_MODE))
        {
            return FIRST_GO_HUMAN;
        }
        if (answer.equals(Board.COMP_MODE))
        {
            return FIRST_GO_COMP;
        }
        System.out.print("Incorrect answer. Have to be \"human\" or \"comp\". ");
        return this.askWhoFirst();
    }

    private int checkXorY(int lastIndex)
    {
        int result = INCORRECT_VALUE;
        if (sc.hasNextInt())
        {
            result = sc.nextInt();
            if (result < 0 || result > lastIndex)
            {
                result = INCORRECT_VALUE;
            }
        }
        return result;
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
}
