package figures;

import game.Board;

import java.util.Arrays;

public class Bishop extends Figure {
    public Bishop(boolean isWhite, char figureChar, int row, int cell) {
        super(isWhite, figureChar, row, cell);
    }

    /*@Override
    public boolean isMoveValid(int fromRow, int fromCol, int toRow, int toCol) {
        return false;
    }*/



    @Override
    public boolean figureCanMove() {
        System.out.println("\nCheck Bishop");
        System.out.format(this.toString() + "\nFigure Coords: %s-%s ", getRowPosition(), getColPosition());
        System.out.println();


        int currentRow = getRowPosition();
        int currentCol = getColPosition();

        /*up-left*/
        for (int i = 1; i < 8 && ((currentRow + i >= 0 & currentRow + i < 8) & (currentCol - i >= 0 & currentCol - i < 8)); i++) {
            Figure figure;

            int rowUp = currentRow + i;
            int colLeft = currentCol - i;
            /*if (rowUp < 8)
            {*/

            System.out.println("\nrowUp: " + (rowUp));
            System.out.println("colLeft: " + (colLeft));

            figure = Board.chessBoard()[rowUp][colLeft];
            if (figure == null || figureIsOpposite(figure)) {
                availableMoves.add(new int[]{rowUp, colLeft});
            }
            else break;
        }


        /*up-right*/
        for (int i = 1; i < 8 && ((currentRow + i >= 0 & currentRow + i < 8) & (currentCol + i >= 0 & currentCol + i < 8)); i++) {
            Figure figure;

            int rowUp = currentRow + i;
            int colRight = currentCol + i;
            /*if (rowUp < 8)
            {*/

            System.out.println("\nrowUp: " + (rowUp));
            System.out.println("colRight: " + (colRight));

            figure = Board.chessBoard()[rowUp][colRight];
            if (figure == null || figureIsOpposite(figure)) {
                availableMoves.add(new int[]{rowUp, colRight});
            }
            else break;
        }



        /*down-left*/
        for (int i = 1; i < 8 && ((currentRow - i >= 0 & currentRow - i < 8) & (currentCol - i >= 0 & currentCol - i < 8)); i++) {
            Figure figure;

            int rowDown = currentRow - i;
            int colLeft = currentCol - i;
            /*if (rowUp < 8)
            {*/

            System.out.println("\nrowDown: " + (rowDown));
            System.out.println("colLeft: " + (colLeft));

            figure = Board.chessBoard()[rowDown][colLeft];
            if (figure == null || figureIsOpposite(figure)) {
                availableMoves.add(new int[]{rowDown, colLeft});
            }
            else break;
        }


        /*down-right*/
        for (int i = 1; i < 8 && ((currentRow - i >= 0 & currentRow - i < 8) & (currentCol + i >= 0 & currentCol + i < 8)); i++) {
            Figure figure;

            int rowDown = currentRow - i;
            int colRight = currentCol + i;
            /*if (rowUp < 8)
            {*/

            System.out.println("\nrowDown: " + (rowDown));
            System.out.println("colRight: " + (colRight));

            figure = Board.chessBoard()[rowDown][colRight];
            if (figure == null || figureIsOpposite(figure)) {
                availableMoves.add(new int[]{rowDown, colRight});
            }
            else break;
        }

        System.out.println(availableMoves.size());

        availableMoves.forEach(ints -> {
            System.out.println(Arrays.toString(ints));
        });

        return !availableMoves.isEmpty();

        //return false;
    }

    @Override
    public boolean isCoordinatesValid(int... coordinates) {
        return false;
    }

}
