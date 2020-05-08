package sample;

public class GameBoard {
    public static int size = 19;
    char[][] gameBoard;
    char turn;

    public GameBoard() {
        gameBoard = new char[size][size];
        turn = 'x';
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                gameBoard[i][j] = '_';
            }
        }
    }

    public char pieceAt(int row, int col) {
        return gameBoard[row][col];
    }

    public char[][] getGameBoard() {
        return gameBoard;
    }

    public char getTurn() {
        return turn;
    }

    public boolean inBounds(int row, int col) {
        return row < size && row >= 0 && col < size && col > 0;
    }

    public boolean isEmpty(int row, int col) {
        return gameBoard[row][col] == '_';
    }


    public int removeIfDead(int row, int col) {
        int lives = 0;
        if (inBounds(row+1,col)) {

        }

    }

    public void placePiece(int row, int col, char color) {
        if (inBounds(row, col) && isEmpty(row, col)) {
            gameBoard[row][col] = color;
            turn = turn=='x'? 'o':'x';

        }
    }
}
