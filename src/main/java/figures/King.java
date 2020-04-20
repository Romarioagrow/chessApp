package figures;

import game.Board;

import java.util.ArrayList;

public class King extends Figure {
    public King(boolean isWhite, char figureChar, int row, int cell) {
        super(isWhite, figureChar, row, cell);
    }

    /*@Override
    public boolean isMoveValid(int fromRow, int fromCol, int toRow, int toCol) {
        return false;
    }*/

    @Override
    public boolean figureCanMove() {
        System.out.println("\nCheck King");
        System.out.format(this.toString() + "\nFigure Coords: %s-%s ", getRowPosition(), getColPosition());
        System.out.println();

        int currentRow = getRowPosition();
        int currentCol = getColPosition();

        int[][] possibleOffsets = {
                {1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {-1, 1}, {-1, -1}, {1, -1}
        };

        for (int[] possibleCoords : possibleOffsets ) {
            try
            {
                int moveRow = currentRow + possibleCoords[0];
                int moveCol = currentCol + possibleCoords[1];
                Figure figure = Board.chessBoard()[moveRow][moveCol];

                if (figure == null || figureIsOpposite(figure)) {
                    availableMoves.add(new int[]{moveRow, moveCol});
                }
            }
            catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("За границей доски, следующий!");
            }
        }

        System.out.println(availableMoves.size());

        return !availableMoves.isEmpty();
    }

    private boolean validCoordinates() {
        return true;
    }

    @Override
    public boolean isCoordinatesValid(int... coordinates) {
        return false;
    }
}
