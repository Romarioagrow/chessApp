package figures;

public class Queen extends Figure {
    public Queen(boolean isWhite, char figureChar, int row, int cell) {
        super(isWhite, figureChar, row, cell);
    }

    @Override
    public boolean isMoveValid(int fromRow, int fromCol, int toRow, int toCol) {
        return false;
    }

    @Override
    public boolean figureCanMove() {
        System.out.println("\nCheck Queen");
        System.out.format(this.toString() + "\nFigure Coords: %s-%s ", getRowPosition(), getColPosition());
        System.out.println();

        return false;
    }

}
