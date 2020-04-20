package game;

import figures.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Data
@ToString
public class Board {

    private static boolean gameRunning;

    private static final Figure[][] chessBoard = new Figure[8][8];

    private static String move;

    private static int fromRow, fromCol, toRow, toCol;

    @Getter
    private static boolean whiteTurn, validMove = true;

    public Board() {
        initialiseBoard();
        gameRunning = true;
        whiteTurn = true;
        displayBoard();
    }

    public static boolean gameRunning() {
        return gameRunning;
    }

    public static Figure[][] chessBoard() {
        return chessBoard;
    }


    public void startGame() throws NullPointerException {
        //try {
        Player whitePlayer = new Player(true);
        Player blackPlayer = new Player(false);

        while (gameRunning()) {
            try {

                if (whiteTurn) {
                    whitePlayer.move();
                    whiteTurn = false;
                }
                else {
                    blackPlayer.move();
                    whiteTurn = true;
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Game is finished!");
        /*}
        catch (Exception e) {
            e.printStackTrace();
        }*/
    }

    static void stopGame() {

        gameRunning = false;

    }


    public static void nextMove() {

        /*try {

        }*/



        //move

        /*if (whiteTurn) {

            whitePlayer.move();

            //move = whiteMove();
        }
        else  blackPlayer.move();   //;//move = blackMove();*/



    }

    public static void whiteMove() {


    }

    public static void blackMove() {


    }


    public void moveCorrect() {


    }


    private void initialiseBoard() {

        /*Black figures */
        Board.chessBoard[0][0] = new Rook(false, '\u265C'/*,0,0*/);
        Board.chessBoard[0][1] = new Knight(false, '\u265E');
        Board.chessBoard[0][2] = new Bishop(false, '\u265D');
        Board.chessBoard[0][3] = new Queen(false, '\u265B');
        Board.chessBoard[0][4] = new King(false, '\u265A');
        Board.chessBoard[0][5] = new Bishop(false, '\u265D');
        Board.chessBoard[0][6] = new Knight(false, '\u265E');
        Board.chessBoard[0][7] = new Rook(false, '\u265C');
        /*Black pawns*/
        for (byte col = 0; col < 8; col++) {
            Board.chessBoard[1][col] = new Pawn(false, '\u265F');
        }

        /*White pawns*/
        for (byte col = 0; col < 8; col++) {
            Board.chessBoard[6][col] = new Pawn(true, '\u2659');
        }
        /*White figures*/
        Board.chessBoard[7][0] = new Rook(true, '\u2656');
        Board.chessBoard[7][1] = new Knight(true, '\u2658');
        Board.chessBoard[7][2] = new Bishop(true, '\u2657');
        Board.chessBoard[7][3] = new Queen(true, '\u2655');
        Board.chessBoard[7][4] = new King(true, '\u2654');
        Board.chessBoard[7][5] = new Bishop(true, '\u2657');
        Board.chessBoard[7][6] = new Knight(true, '\u2658');
        Board.chessBoard[7][7] = new Rook(true, '\u2656');
    }


    /*public static boolean isGameRunning() {
        return gameRunning;
    }*/


    private boolean moveValid() {
        return false;
    }


    public static void displayBoard() {
        System.out.println("\ta\tb\tc\td\te\tf\tg\th");

        for (byte row = 0; row < 8; row++) {

            System.out.println();
            System.out.print((8 - row) + "\t");

            for (byte col = 0; col < 8; col++) {
                if (chessBoard[row][col] != null) {
                    System.out.print("[" + chessBoard[row][col].getFigureChar() + "]");
                }
                else System.out.print("[\u2001]");
            }
            System.out.print("\t" + (8 - row));
        }
        System.out.println("\n\n\ta\tb\tc\td\te\tf\tg\th");
    }


}
