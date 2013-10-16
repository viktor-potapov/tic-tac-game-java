package com.hexlet.tictac;

public class Board {
    private Cell[][] fieldMatrix;

    private Cell maxPriceField;

    private final int board_size;
    private final static int CORNER_FEATURE_PRICE = 2;
    private final static int CENTER_FEATURE_PRICE = 3;
    private final static int USUAL_PRICE = 1;

    public final static String COMP_MODE = "comp";
    public final static String HUMAN_MODE = "human";
    public final String gameMode;

    public int getBoardSize(){
        return board_size;
    }

    private void firstInit(){
        Cell tempField;
        fieldMatrix =  new Cell[board_size][board_size];
        int center =  (board_size-1)/2;
        for (int i = 0; i < board_size; i++)
            for (int j = 0; j < board_size; j++)
            {
                if ((i == 0 && j == 0)||(i == board_size-1 && j == board_size-1) || (i == 0 && j ==  board_size-1)||(i == board_size-1 && j == 0))
                {
                    tempField = new Cell(i, j, CORNER_FEATURE_PRICE);
                }
                else if (i == center && center == j)
                {
                    tempField = new Cell(i, j, CENTER_FEATURE_PRICE);
                }
                else
                {
                    tempField = new Cell(i, j, USUAL_PRICE);
                }
                fieldMatrix[i][j] =  tempField;
            }
    }

    public Board(int size){
        this(size, HUMAN_MODE);
    }

    public Board(int size, String gameMode){
        this.board_size = size;
        this.gameMode = gameMode;
        firstInit();
    }

    public boolean checkWin(char symbol) {
        boolean result = false;
        Integer[] horizontalCounts = new Integer[board_size];
        Integer[] verticalCounts = new Integer[board_size];
        int diagonalCount1 = 0;
        int diagonalCount2 = 0;
        for (int i = 0; i < board_size; i++)
        {
            if (fieldMatrix[i][i].getSymbol() == symbol)
            {
                diagonalCount1++;
                if (diagonalCount1 == board_size)
                    return true;
            }
            if (fieldMatrix[i][board_size-1-i].getSymbol() == symbol)
            {
                diagonalCount2++;
                if (diagonalCount2 == board_size)
                    return true;
            }
           /* for (int j = 0; j < board_size; j++)
            {
                if (fieldMatrix[i][j].getIsFilled())
                {
                    verticalCounts[i]++;
                    if (verticalCounts[i] == board_size-1)
                        return true;
                }
            }
            for (int j = 0; j < board_size; j++)
            {
                if (fieldMatrix[j][i].getIsFilled())
                {
                    horizontalCounts[j]++;
                    if (horizontalCounts[j] == board_size-1)
                        return true;
                }
            }*/

        }
        return result;
    }

    public void calculateFieldPrices() {
        // TODO : to implement
    }

    public void goComputerPlayer() {
        // TODO : to implement
    }


    public void setFieldMatrix(Cell parameter) {
        // TODO : to implement
    }


    public Cell getField(int i,int j) {
        return fieldMatrix[i][j];
    }
}
