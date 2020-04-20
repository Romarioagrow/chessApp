package figures;

import game.Figure;

public class Knight extends Figure {
    public Knight(boolean isWhite, char figureChar, int row, int cell) {
        super(isWhite, figureChar, row, cell);
    }

    @Override
    public boolean figureCanMove() {
        System.out.println("\nCheck Knight");
        System.out.format(this.toString() + "\nFigure Coords: %s-%s ", getRowPosition(), getColPosition());
        System.out.println();

        availableMoves.clear();

        int[][] possibleOffsets = {
                {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}
        };

        resolveOffsetBounds(possibleOffsets);

        filterOwnFigures();

        //filterOffsetsByBoardBounds();

        //System.out.println(availableMoves.size());
        return !availableMoves.isEmpty();
    }
}

