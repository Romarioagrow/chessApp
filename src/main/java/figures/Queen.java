package figures;

import game.Figure;

public class Queen extends Figure {
    public Queen(boolean isWhite, char figureChar, int row, int cell) {
        super(isWhite, figureChar, row, cell);
    }

    @Override
    public boolean figureCanMove() {
        printFigureInfo("Queen");

        availableMoves.clear();

        /*
            все диапазоны вверх,
            все диапазоны вниз,
            все диапазоны вправо,
            все диапазоны влево,
            все диапазоны вверх-влево,
            все диапазоны вниз-влево,
            все диапазоны вверх-вправо,
            все диапазоны вниз-вправо,
            отсеить от x >= 0 & x < 8
        */

        int currentRow = getRowPosition();
        int currentCol = getColPosition();

        resolveOffsetsUp(currentRow, currentCol);

        /*Down*/
        resolveOffsetsDown(currentRow, currentCol);

        /*Left*/
        resolveOffsetsLeft(currentRow, currentCol);

        /*Right*/
        resolveOffsetsRight(currentRow, currentCol);

        /*up-left*/
        resolveOffsetsUpLeft(currentRow, currentCol);

        /*up-right*/
        resolveOffsetsUpRight(currentRow, currentCol);

        /*down-left*/
        resolveOffsetsDownLeft(currentRow, currentCol);

        /*down-right*/
        resolveOffsetsDownRight(currentRow, currentCol);

        return !availableMoves.isEmpty();
    }
}
