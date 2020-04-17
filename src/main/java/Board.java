import figures.*;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Board {

    private boolean gameRunning;

    private static final Figure[][] chessBoard = new Figure[8][8];

    private String move;

    private static int fromRow, fromCol, toRow, toCol;

    private static boolean whiteTurn, validMove = true;


    public Board() {
        initialiseBoard(chessBoard);
        this.gameRunning = true;
    }

    private void initialiseBoard(Figure[][] chessBoard) {

        /*Black figures */
        chessBoard[0][0] = new Rook(false, '\u265C');
        chessBoard[0][1] = new Knight(false, '\u265E');
        chessBoard[0][2] = new Bishop(false, '\u265D');
        chessBoard[0][3] = new Queen(false, '\u265B');
        chessBoard[0][4] = new King(false, '\u265A');
        chessBoard[0][5] = new Bishop(false, '\u265D');
        chessBoard[0][6] = new Knight(false, '\u265E');
        chessBoard[0][7] = new Rook(false, '\u265C');
        /*Black pawns*/
        for (byte col = 0; col < 8; col++) {
            chessBoard[1][col] = new Pawn(false, '\u265F');
        }

        /*White pawns*/
        for (byte col = 0; col < 8; col++) {
            chessBoard[6][col] = new Pawn(true, '\u2659');
        }
        /*White figures*/
        chessBoard[7][0] = new Rook(true, '\u2656');
        chessBoard[7][1] = new Knight(true, '\u2658');
        chessBoard[7][2] = new Bishop(true, '\u2657');
        chessBoard[7][3] = new Queen(true, '\u2655');
        chessBoard[7][4] = new King(true, '\u2654');
        chessBoard[7][5] = new Bishop(true, '\u2657');
        chessBoard[7][6] = new Knight(true, '\u2658');
        chessBoard[7][7] = new Rook(true, '\u2656');
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
