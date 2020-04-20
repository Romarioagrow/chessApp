package figures;
import java.util.Arrays;

public class Rook extends Figure {
    public Rook(boolean isWhite, char figureChar, int row, int cell) {
        super(isWhite, figureChar, row, cell);
    }

    @Override
    public boolean figureCanMove() {
        System.out.println("\nCheck Rook");
        System.out.format(this.toString() + "\nFigure Coords: %s-%s ", getRowPosition(), getColPosition());
        System.out.println();

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

        //filterOffsetsByBoardBounds();

        /*System.out.println("Rook moves: " + availableMoves.size());
        availableMoves.forEach(offsetArray -> {
            System.out.println(Arrays.toString(offsetArray));
        });*/
        return !availableMoves.isEmpty();
    }
}
