package figures;

public class Rook extends Figure {
    public Rook(boolean isWhite, char figureChar, int row, int cell) {
        super(isWhite, figureChar, row, cell);
    }

    @Override
    public boolean isMoveValid(int fromRow, int fromCol, int toRow, int toCol) {
        return false;
    }

    @Override
    public boolean figureCanMove() {
        System.out.println("\nCheck Rook");
        System.out.format(this.toString() + "\nFigure Coords: %s-%s ", getRowPosition(), getColPosition());
        System.out.println();

        return false;
    }
}
