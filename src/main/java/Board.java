import figures.*;

public class Board {

    private boolean gameRunning;

    private final Figure[][] chessBoard = new Figure[8][8];

    private String move;

    private static int fromRow, fromCol, toRow, toCol;

    private static boolean whiteTurn, validMove = true;


    //private static boolean whiyeTurn;


    public Board() {


        initialiseBoard(chessBoard);
        this.gameRunning = true;



    }

    private void initialiseBoard(Figure[][] chessBoard) {

        /*Black figures */
        chessBoard[0][0] = new Rook(false);
        chessBoard[0][1] = new Knight(false);
        chessBoard[0][2] = new Bishop(false);
        chessBoard[0][3] = new Queen(false);
        chessBoard[0][4] = new King(false);
        chessBoard[0][5] = new Bishop(false);
        chessBoard[0][6] = new Knight(false);
        chessBoard[0][7] = new Rook(false);

        /*Black pawns*/
        for (byte col = 0; col < 8; col++) {
            chessBoard[1][col] = new Pawn(false);
        }

        /*White figures*/
        chessBoard[7][0] = new Rook(true);
        chessBoard[7][1] = new Knight(true);
        chessBoard[7][2] = new Bishop(true);
        chessBoard[7][3] = new Queen(true);
        chessBoard[7][4] = new King(true);
        chessBoard[7][5] = new Bishop(true);
        chessBoard[7][6] = new Knight(true);
        chessBoard[7][7] = new Rook(true);

        /*White pawns*/
        for (byte col = 0; col < 8; col++) {
            chessBoard[7][col] = new Pawn(true);
        }

    }


}
