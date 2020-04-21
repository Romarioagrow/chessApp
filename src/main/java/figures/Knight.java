package figures;

import game.Figure;

public class Knight extends Figure {
    public Knight(boolean isWhite, char figureChar, int row, int cell) {
        super(isWhite, figureChar, row, cell);
    }

    @Override
    public boolean figureCanMove() {
        printFigureInfo("Knight");


        availableMoves.clear();

        int[][] possibleOffsets = {
                {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}
        };

        resolveOffsetBounds(possibleOffsets);

        filterOwnFigures();

        return !availableMoves.isEmpty();
    }
}

