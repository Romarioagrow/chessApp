package figures;

import game.Figure;

import static game.Board.getFigureFromBoard;

public class Pawn extends Figure {
    public Pawn(boolean isWhite, char figureChar, int row, int cell) {
        super(isWhite, figureChar, row, cell);
    }

    @Override
    public boolean figureCanMove() {
        printFigureInfo("Pawn");

        availableMoves.clear();

        int currentRow = getRowPosition();
        int currentCol = getColPosition();

        if (isWhite()) {
            resolveWhitePawnOffsets(currentRow, currentCol);
        }
        else resolveBlackPawnOffsets(currentRow, currentCol);

        filterOwnFigures();

        return !availableMoves.isEmpty();
    }


    private void resolveWhitePawnOffsets(int currentRow, int currentCol) {
        if (currentRow < 8 && checkPawnOffsetCorrect(currentRow - 1, currentCol)) {
            availableMoves.add(new int[]{currentRow - 1, currentCol});
        }

        if (currentRow == 6 && checkPawnOffsetCorrect(currentRow - 2, currentCol)) {
            availableMoves.add(new int[]{currentRow - 2, currentCol});
        }

        int attackRow = currentRow - 1;
        checkAttackOffsets(attackRow);
    }


    private void resolveBlackPawnOffsets(int currentRow, int currentCol) {
        if (currentRow > 0 && checkPawnOffsetCorrect(currentRow + 1, currentCol)) {
            availableMoves.add(new int[]{currentRow + 1, currentCol});
        }

        if (currentRow == 1 && checkPawnOffsetCorrect(currentRow + 2, currentCol)) {
            availableMoves.add(new int[]{currentRow + 2, currentCol});
        }

        int attackRow = currentRow + 1;
        checkAttackOffsets(attackRow);
    }

    public void checkAttackOffsets(int attackRow) {
        int attackColLeft = getColPosition() - 1;
        int attackColRight = getColPosition() + 1;

        /*AttackLeft*/
        if (checkCorrectOffsetBounds(attackRow, attackColLeft)) {
            Figure pawnAttackFigure = getFigureFromBoard(attackRow, attackColLeft);
            if (figureIsOpponent(pawnAttackFigure)) {
                availableMoves.add(new int[]{attackRow, attackColLeft});
            }
        }

        /*AttackRight*/
        if (checkCorrectOffsetBounds(attackRow, attackColRight)) {
            Figure pawnAttackFigure = getFigureFromBoard(attackRow, attackColRight);
            if (figureIsOpponent(pawnAttackFigure)) {
                availableMoves.add(new int[]{attackRow, attackColRight});
            }
        }
    }
}
