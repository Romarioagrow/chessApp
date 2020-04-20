package figures;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static game.Board.getFigureFromBoard;

@Data
@NoArgsConstructor
public abstract class Figure { /// implements Checkable
    private boolean isWhite;

    private char figureChar;

    private int rowPosition, colPosition;

    List<int[]> availableMoves = new ArrayList<>();

    public Figure(boolean isWhite, char figureChar, int rowPosition, int colPosition) {
        this.isWhite = isWhite;
        this.figureChar = figureChar;
        this.rowPosition = rowPosition;
        this.colPosition = colPosition;
    }

    public boolean offsetAvailableToMove(Figure figure) {
        return figure == null || figure.isFigureWhite() != this.isFigureWhite();
    }

    public boolean figureIsOpponent(Figure figure) {
        return figure != null && figure.isFigureWhite() != this.isFigureWhite();
    }


    public char getFigureChar() {
        return figureChar;
    }

    public boolean isFigureWhite() {
        return isWhite;
    }

    public abstract boolean figureCanMove();

    /*public void filterOffsetsByBoardBounds() {

        availableMoves = availableMoves.stream()

                .filter(offset -> {

                    System.out.println("offset[0]: "+ offset[0] + "offset[1]: " + offset[1]);
                    return ((offset[0] >= 0 & offset[0] < 8) && (offset[1] >= 0 & offset[1] < 8));
                }).collect(Collectors.toList());

    }*/

    protected boolean checkPawnAttackCorrect(int attackRow, int attackCol) {
        /*If offset correct with board*/
        if (checkCorrectOffset(attackRow, attackCol)) {
            return figureIsOpponent(getFigureFromBoard(attackRow, attackCol));
        }
        return false;
    }

    protected boolean checkCorrectOffset(int row, int col) {

        System.out.println("row: " + row + "col: " + col);
        System.out.println("boolean: " + ((row >= 0 & row < 8) & (col >= 0 & col < 8)));
        return (row >= 0 & row < 8) & (col >= 0 & col < 8);
    }

    protected void resolveArrayOffsets(int[][] possibleOffsets) {
        availableMoves = Arrays.stream(possibleOffsets).filter(offset -> {
            int row = getRowPosition() + offset[0];
            int col = getColPosition() + offset[1];

            if (checkCorrectOffset(row, col)) {
                return offsetAvailableToMove(getFigureFromBoard(row, col));
            }
            return false;
        }).collect(Collectors.toList());
    }

    protected void resolveOffsetsUp(int currentRow, int currentCol) {
        for (int row = currentRow; row >= 0; row--) {
            if (offsetAvailableToMove(getFigureFromBoard(row, currentCol))) {
                availableMoves.add(new int[] {row, currentCol});
            }
            else break;
        }
    }

    protected void resolveOffsetsDown(int currentRow, int currentCol) {
        for (int row = currentRow; row < 8; row++) {
            if (offsetAvailableToMove(getFigureFromBoard(row, currentCol))) {
                availableMoves.add(new int[] {row, currentCol});
            }
            else break;
        }
    }

    protected void resolveOffsetsLeft(int currentRow, int currentCol) {
        for (int col = currentCol; col >= 0; col--) {
            if (offsetAvailableToMove(getFigureFromBoard(currentRow, currentCol))) {
                availableMoves.add(new int[] {currentRow, currentCol});
            }
            else break;
        }
    }

    protected void resolveOffsetsRight(int currentRow, int currentCol) {
        for (int col = currentCol; col < 8; col++) {
            if (offsetAvailableToMove(getFigureFromBoard(currentRow, currentCol))) {
                availableMoves.add(new int[] {currentRow, currentCol});
            }
            else break;
        }
    }

    protected void resolveOffsetsUpLeft(int currentRow, int currentCol) {
        for (int row = currentRow, col = currentCol; row >= 0 & col >= 0; row--, col--) {
            if (offsetAvailableToMove(getFigureFromBoard(currentRow, currentCol))) {
                availableMoves.add(new int[] {row, currentCol});
            }
            else break;
        }
    }

    protected void resolveOffsetsUpRight(int currentRow, int currentCol) {
        for (int row = currentRow, col = currentCol; row >= 0 & col < 8; row--, col++) {
            if (offsetAvailableToMove(getFigureFromBoard(currentRow, currentCol))) {
                availableMoves.add(new int[] {row, currentCol});
            }
            else break;
        }
    }

    protected void resolveOffsetsDownLeft(int currentRow, int currentCol) {
        for (int row = currentRow, col = currentCol; row < 8 & col >= 0; row++, col--) {
            if (offsetAvailableToMove(getFigureFromBoard(currentRow, currentCol))) {
                availableMoves.add(new int[] {row, currentCol});
            }
            else break;
        }
    }

    protected void resolveOffsetsDownRight(int currentRow, int currentCol) {
        for (int row = currentRow, col = currentCol; row < 8 & col < 8; row++, col++) {
            if (offsetAvailableToMove(getFigureFromBoard(currentRow, currentCol))) {
                availableMoves.add(new int[] {row, currentCol});
            }
            else break;
        }
    }
}
