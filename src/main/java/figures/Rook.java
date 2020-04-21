package figures;
import game.Figure;

public class Rook extends Figure {
    public Rook(boolean isWhite, char figureChar, int row, int cell) {
        super(isWhite, figureChar, row, cell);
    }

    @Override
    public boolean figureCanMove() {
        printFigureInfo("Rook");

        availableMoves.clear();

        /*
            все диапазоны вверх,
            все диапазоны вниз,
            все диапазоны вправо,
            все диапазоны влево,

            отсеить от x >= 0 & x < 8
        */

        int currentRow = getRowPosition();
        int currentCol = getColPosition();

        /*Up*/
        resolveOffsetsUp(currentRow, currentCol);

        /*Down*/
        resolveOffsetsDown(currentRow, currentCol);

        /*Left*/
        resolveOffsetsLeft(currentRow, currentCol);

        /*Right*/
        resolveOffsetsRight(currentRow, currentCol);

        return !availableMoves.isEmpty();
    }
}
