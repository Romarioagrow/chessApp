package figures;

import game.Board;

import java.util.Arrays;

public class Pawn extends Figure {
    public Pawn(boolean isWhite, char figureChar, int row, int cell) {
        super(isWhite, figureChar, row, cell);
    }

    @Override
    public boolean figureCanMove() {
        System.out.println("\nCheck Pawn");
        System.out.format(this.toString() + "\nFigure Coords: %s-%s ", getRowPosition(), getColPosition());
        System.out.println();

        availableMoves.clear();

        int currentRow = getRowPosition();
        int currentCol = getColPosition();

        if (isWhite()) {
            resolveWhitePawnOffsets(currentRow, currentCol);
        }
        else resolveBlackPawnOffsets(currentRow, currentCol);

        System.out.println("Pawn moves: " + availableMoves.size());
        availableMoves.forEach(offsetArray -> {
            System.out.println(Arrays.toString(offsetArray));
        });
        return !availableMoves.isEmpty();
    }


    private void resolveWhitePawnOffsets(int currentRow, int currentCol) {
        availableMoves.add(new int[]{-1, 0});

        if (currentRow == 6) {
            availableMoves.add(new int[]{-2, 0});
        }

        int attackRow = currentRow - 1;
        checkAttackOffsets(attackRow);
    }


    private void resolveBlackPawnOffsets(int currentRow, int currentCol) {
        availableMoves.add(new int[]{1, 0});

        if (currentRow == 1) {
            availableMoves.add(new int[]{2, 0});
        }

        int attackRow = currentRow + 1;
        checkAttackOffsets(attackRow);
    }

    public void checkAttackOffsets(int attackRow) {
        /*AttackLeft*/
        int attackColLeft = getColPosition() - 1;
        if (figureIsOpponent(Board.getFigureFromBoard(attackRow, attackColLeft))) {
            availableMoves.add(new int[]{attackRow, attackColLeft});
        }

        /*AttackRight*/
        int attackColRight = getColPosition() + 1;
        if (figureIsOpponent(Board.getFigureFromBoard(attackRow, attackColRight))) {
            availableMoves.add(new int[]{attackRow, attackColRight});
        }
    }

}
