package sample;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {



    @FXML
    private Canvas canvas;
    private GraphicsContext gc;
    private int boardSize = 540;
    private int tileSize = boardSize / 18;
    private int pieceRadius = 10;

    GameBoard gameBoard;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.SANDYBROWN);
        gc.fillRect(0,0, canvas.getWidth(), canvas.getHeight());
        gameBoard = new GameBoard();
        draw_board();
    }

    @FXML
    void mouse_click(MouseEvent event) {
        int col = (int) ((event.getX() + tileSize/2) / tileSize) - 1;
        int row = (int) ((event.getY() + tileSize/2) / tileSize) - 1;
        System.out.println("row: " + row + " col: " + col);
        gameBoard.placePiece(row, col, gameBoard.getTurn());
        draw_board();

    }

    void draw_board() {
//        gc.fillRect(borderSize,borderSize,boardSize,boardSize);
        gc.setFill(Color.BLACK);
        gc.strokeRect(tileSize, tileSize, boardSize, boardSize);
        for (int i = 2; i < 19; i++) {
            gc.strokeLine(i * tileSize, tileSize, i * tileSize, tileSize + boardSize);
            gc.strokeLine(tileSize, i * tileSize, tileSize + boardSize, i * tileSize);
        }
        for (int i = 0; i < GameBoard.size; i++) {
            for (int j = 0; j < GameBoard.size; j++) {
                if (gameBoard.pieceAt(i,j) != '_') {
                    draw_piece(i, j, gameBoard.pieceAt(i,j));
                }
            }
        }

//        gc.fillOval(10*tileSize-5,10*tileSize-5,10, 10);


//        draw_piece(2,5);

    }

    void draw_piece(int row, int col, char color) {
        if (color == 'x') {
            gc.setFill(Color.BLACK);
        } else {
            gc.setFill(Color.WHITE);
        }
        gc.fillOval((col+1) * tileSize - pieceRadius,(row+1) * tileSize - pieceRadius,
                pieceRadius*2, pieceRadius*2);
    }
}
