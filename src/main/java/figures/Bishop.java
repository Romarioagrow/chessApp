package figures;

import game.Figure;

import java.util.Arrays;

public class Bishop extends Figure {
    public Bishop(boolean isWhite, char figureChar, int row, int cell) {
        super(isWhite, figureChar, row, cell);
    }

    @Override
    public boolean figureCanMove() {
        printFigureInfo("Bishop");


        availableMoves.clear();

        /*
            Вычислить диапазоны в переделах x >= 0 & x < 8
            все диапазоны вверх-влево,
            все диапазоны вниз-влево,
            все диапазоны вверх-вправо,
            все диапазоны вниз-вправо,

            отфильтровать null и opponentFigure()

            add to allPossibleMoves
        */

        int currentRow = getRowPosition();
        int currentCol = getColPosition();

        /*up-left*/
        resolveOffsetsUpLeft(currentRow, currentCol);

        /*up-right*/
        resolveOffsetsUpRight(currentRow, currentCol);

        /*down-left*/
        resolveOffsetsDownLeft(currentRow, currentCol);

        /*down-right*/
        resolveOffsetsDownRight(currentRow, currentCol);

        //filterOwnFigures();


        /// ??? availableMoves EMPTY

        System.out.println("Bishop moves: " + availableMoves.size());
        availableMoves.forEach(offsetArray -> {
            System.out.println(Arrays.toString(offsetArray));
        });
        return !availableMoves.isEmpty();
    }
}
