package com.hexlet.tictac;


import com.hexlet.tictac.Exceptiones.InvalidBorderConstructorParameters;

public class Board {

    public final static String COMP_MODE = "comp";
    public final static String HUMAN_MODE = "human";
    public final String gameMode;

    private Cell[][] fieldMatrix;
    private final int board_size;
    private final static int CORNER_FEATURE_PRICE = 2;
    private final static int CENTER_FEATURE_PRICE = 3;
    private final static int USUAL_PRICE = 1;
    private final static int ABSOLUTE_ENEMY_PRICE = 200;
    private final static int ABSOLUTE_WINNER_ON_NEXT_STEP_PRICE = 100;

    private final int INDEX_X = 0;
    private final int INDEX_Y = 1;

    public final int HORIZONTAL_LINE = 1;
    public final int VERTICAL_LINE = 2;
    public final int DIAGONAL_FIRST = 3;
    public final int DIAGONAL_SECOND = 4;

    private Integer stepCounter;


    public Board(int size) throws InvalidBorderConstructorParameters.GameModeException, InvalidBorderConstructorParameters.SizeException {
        this(size, HUMAN_MODE);
    }

    public Board(int size, String gameMode) throws InvalidBorderConstructorParameters.GameModeException, InvalidBorderConstructorParameters.SizeException {
        this.board_size = size;
        stepCounter = size*size;
        this.gameMode = gameMode;
        if ( size < 3 || (size % 2) == 0){
            throw new InvalidBorderConstructorParameters.SizeException();
           /* System.out.println("Board size has to be odd number!!!!!!!!!!!!! AAAAAAAAAAAA");
            return;*/
        }
        if (!gameMode.equals(COMP_MODE) && !gameMode.equals(HUMAN_MODE))
        {
            throw new InvalidBorderConstructorParameters.GameModeException();
        }
        firstInit();
    }

    public int getBoardSize(){
        return board_size;
    }

    public void setFieldMatrix(Cell parameter) {
        // TODO : to implement
    }

    public Cell getField(int i,int j) {
        return fieldMatrix[i][j];
    }

    public Boolean checkDraw(){
        stepCounter--;
        return stepCounter == 0;
    }

    public boolean checkWin(char symbol) {
        boolean result = false;
        Integer[] horizontalSymbolCounts = new Integer[board_size];
        Integer[] verticalSymbolCounts = new Integer[board_size];
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
            for (int j = 0; j < board_size; j++)
            {
                if (fieldMatrix[i][j].getSymbol() == symbol)
                {
                    if (horizontalSymbolCounts[i] == null) horizontalSymbolCounts[i] = 0;
                    horizontalSymbolCounts[i]++;
                    if (horizontalSymbolCounts[i] == board_size)
                        return true;
                }
                if (fieldMatrix[j][i].getSymbol() == symbol)
                {
                    if (verticalSymbolCounts[i] == null) verticalSymbolCounts[i] = 0;
                    verticalSymbolCounts[i]++;
                    if (verticalSymbolCounts[i] == board_size)
                        return true;
                }
            }
        }
        return result;
    }

    public void goHuman(Player player, int[] currentXY)
    {
        int x = currentXY[INDEX_X];
        int y = currentXY[INDEX_Y];
        Cell tempField = fieldMatrix[x][y];
        tempField.setSymbol(player.getSymbol());
        if (gameMode.equals(COMP_MODE))
            calculateFieldPrices(x, y, player.getSymbol());
    }

    public void goComputer(Player player) {
        int maxI = 0;
        int maxJ = 0;
        int maxPrice = USUAL_PRICE;
        for (int i = 0; i < board_size; i++)
        {
            for (int j = 0; j < board_size; j++)
            {
                if (fieldMatrix[i][j].getIsFilled() == false && fieldMatrix[i][j].getPrice() > maxPrice)
                {
                    maxI = i;
                    maxJ = j;
                    maxPrice = fieldMatrix[i][j].getPrice();
                }
            }
        }
        Cell tempField = fieldMatrix[maxI][maxJ];
        tempField.setSymbol(player.getSymbol());
        //if (player.getIsFirst())
            calculateFieldPrices(maxI, maxJ, player.getSymbol());
    }

    private void calculateFieldPrices(int currentX, int currentY, char symbol) {
        for (int i = 0; i < board_size; i++)
        {
            processPricesInLine(currentX, i, symbol, HORIZONTAL_LINE);
            processPricesInLine(i, currentY, symbol, VERTICAL_LINE);
            if (currentX == currentY)
            {
                processPricesInLine(i, i, symbol, DIAGONAL_FIRST);
            }
            if ((currentX + currentY) == (board_size - 1))
            {
                processPricesInLine(i, board_size-1-i, symbol, DIAGONAL_SECOND);
            }
        }
    }

    private void processPricesInLine(int x, int y, char symbol, int type)
    {
        int tempPrice;
        int friendlySymbolsCount = 0;
        int enemySymbolsCount = 0;
        boolean isEnemySymbolInLine = false;
        Cell tempField;
        char currentSymbol = Cell.EMPTY_SYMBOL;
        tempField = fieldMatrix[x][y];
        isEnemySymbolInLine = false;
        friendlySymbolsCount = 0;
        for (int j = 0; j < board_size; j++)
        {
            switch ( type )
            {
                case HORIZONTAL_LINE: currentSymbol = fieldMatrix[x][j].getSymbol(); break;
                case VERTICAL_LINE: currentSymbol = fieldMatrix[j][y].getSymbol(); break;
                case DIAGONAL_FIRST: currentSymbol = fieldMatrix[j][j].getSymbol(); break;
                case DIAGONAL_SECOND: currentSymbol = fieldMatrix[j][board_size-1-j].getSymbol(); break;
            }
            if ((currentSymbol != symbol) && (currentSymbol != Cell.EMPTY_SYMBOL))
            {
                isEnemySymbolInLine = true;
                enemySymbolsCount++;
            }
            if (currentSymbol == symbol)
            {
                friendlySymbolsCount ++;
            }
        }
        if (!tempField.getIsFilled() && !isEnemySymbolInLine)
        {
            if (!isEnemySymbolInLine)
            {
                tempPrice = tempField.getPrice() + capacityFunc(friendlySymbolsCount);
                tempField.setPrice(tempPrice);
            }
            if (enemySymbolsCount == board_size-1)
                tempField.setPrice(ABSOLUTE_ENEMY_PRICE);
            if (friendlySymbolsCount == board_size-1)
                tempField.setPrice(ABSOLUTE_WINNER_ON_NEXT_STEP_PRICE);
        }
    }


    private int capacityFunc(int n)
    {
        int ret = 0;
        for (int i = 0; i <= n; ++i) ret += i*i;
        return ret;
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
                    tempField = new Cell(CORNER_FEATURE_PRICE);
                }
                else if (i == center && center == j)
                {
                    tempField = new Cell(CENTER_FEATURE_PRICE);
                }
                else
                {
                    tempField = new Cell(USUAL_PRICE);
                }
                fieldMatrix[i][j] =  tempField;
            }
    }
}
