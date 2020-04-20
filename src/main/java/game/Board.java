package game;

import figures.*;
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
        standardFiguresArrangement();

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
        ComputerPlayer whitePlayer = new ComputerPlayer(true);
        ComputerPlayer blackPlayer = new ComputerPlayer(false);

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


    public static Figure getFigureFromBoard(int row, int col) {
        //return chessBoard[row][col];
        return chessBoard[row][col];

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


    private void standardFiguresArrangement() {

        /*Black figures */
        Board.chessBoard[0][0] = new Rook(false, '\u265C',0, 0);
        Board.chessBoard[0][1] = new Knight(false, '\u265E',0, 1);
        Board.chessBoard[0][2] = new Bishop(false, '\u265D',0, 2);
        Board.chessBoard[0][3] = new Queen(false, '\u265B',0, 3);
        Board.chessBoard[0][4] = new King(false, '\u265A',0, 4);
        Board.chessBoard[0][5] = new Bishop(false, '\u265D',0, 5);
        Board.chessBoard[0][6] = new Knight(false, '\u265E',0, 6);
        Board.chessBoard[0][7] = new Rook(false, '\u265C',0,7);
        /*Black pawns*/
        for (byte col = 0; col < 8; col++) {
            Board.chessBoard[1][col] = new Pawn(false, '\u265F', 1, col);
        }

        /*White pawns*/
        for (byte col = 0; col < 8; col++) {
            Board.chessBoard[6][col] = new Pawn(true, '\u2659', 6, col);
        }
        /*White figures*/
        Board.chessBoard[7][0] = new Rook(true, '\u2656', 7, 0);
        Board.chessBoard[7][1] = new Knight(true, '\u2658', 7, 1);
        Board.chessBoard[7][2] = new Bishop(true, '\u2657', 7, 2);
        Board.chessBoard[7][3] = new Queen(true, '\u2655', 7, 3);
        Board.chessBoard[7][4] = new King(true, '\u2654', 7, 4);
        Board.chessBoard[7][5] = new Bishop(true, '\u2657', 7, 5);
        Board.chessBoard[7][6] = new Knight(true, '\u2658', 7, 6);
        Board.chessBoard[7][7] = new Rook(true, '\u2656', 7, 7);
    }


    /*public static boolean isGameRunning() {
        return gameRunning;
    }*/


    private boolean moveValid() {
        return false;
    }


    /*public static void displayBoard() {
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
    }*/

    public static void displayBoard() {
        System.out.println("\t0\t1\t2\t3\t4\t5\t6\t7");

        for (byte row = 0; row < 8; row++) {

            System.out.println();
            System.out.print((row) + "\t");

            for (byte col = 0; col < 8; col++) {
                if (chessBoard[row][col] != null) {
                    System.out.print("[" + chessBoard[row][col].getFigureChar() + "]");
                }
                else System.out.print("[\u2001]");
            }
            System.out.print("\t" + (row));
        }
        System.out.println("\n\n\ta\tb\tc\td\te\tf\tg\th");
    }


}
