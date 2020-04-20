package figures;

public class Knight extends Figure {
    public Knight(boolean isWhite, char figureChar, int row, int cell) {
        super(isWhite, figureChar, row, cell);
    }

    /*@Override
    public boolean isMoveValid(int fromRow, int fromCol, int toRow, int toCol) {
        return false;
    }*/

    @Override
    public boolean figureCanMove() {
        System.out.println("\nCheck Knight");
        System.out.format(this.toString() + "\nFigure Coords: %s-%s ", getRowPosition(), getColPosition());
        System.out.println();

        return false;
    }

    @Override
    public boolean isCoordinatesValid(int... coordinates) {
        return false;
    }

}

