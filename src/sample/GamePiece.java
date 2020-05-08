package sample;

public class GamePiece {
    boolean color;
    int row;
    int col;
    public static boolean black = true;
    public static boolean white = false;

    public GamePiece(boolean color, int row, int col) {
        this.row = row;
        this.col = col;
        this.color = color;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }
    public boolean getColor() {
        return this.color;
    }
}
