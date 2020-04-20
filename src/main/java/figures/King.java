package figures;

public class King extends Figure {
    public King(boolean isWhite, char figureChar, int row, int cell) {
        super(isWhite, figureChar, row, cell);
    }

    @Override
    public boolean figureCanMove() {
        System.out.println("\nCheck King");
        System.out.format(this.toString() + "\nFigure Coords: %s-%s ", getRowPosition(), getColPosition());
        System.out.println();

        availableMoves.clear();

        int[][] possibleOffsets = {
                {1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {-1, 1}, {-1, -1}, {1, -1}
        };

        resolveArrayOffsets(possibleOffsets);

        System.out.println(availableMoves.size());
        return !availableMoves.isEmpty();
    }

    private boolean validCoordinates() {
        return true;
    }
}
