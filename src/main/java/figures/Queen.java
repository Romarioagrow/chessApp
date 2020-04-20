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

        int currentRow = getRowPosition();
        int currentCol = getColPosition();

        for (int j = currentCol - 1, i = currentRow + 1; j > -1 && i < 7; j--, i++) {
            //Square square = super.getSquare().getBoardSquare(i, j);


            /*if (square.getPiece() == null) {
                possibleMoves.add(square);
            } else if (isOpponent(square.getPiece())) {
                possibleMoves.add(square);
                break;
            } else {
                break;
            }*/
        }



        return false;
    }

    @Override
    public boolean isCoordinatesValid(int... coordinates) {
        return false;
    }

}
