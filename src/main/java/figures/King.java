package figures;

import game.Figure;

public class King extends Figure {
    public King(boolean isWhite, char figureChar, int row, int cell) {
        super(isWhite, figureChar, row, cell);
    }

    @Override
    public boolean figureCanMove() {
        printFigureInfo("King");

        availableMoves.clear();

        int[][] possibleOffsets = {
                {1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {-1, 1}, {-1, -1}, {1, -1}
        };

        /*Calculates possible array offsets with board bounds*/
        resolveOffsetBounds(possibleOffsets);

        /*Exclude own figures from possible move offsets*/
        filterOwnFigures();

        return !availableMoves.isEmpty();
    }
}
