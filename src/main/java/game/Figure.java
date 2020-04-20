package game;

import lombok.Data;
import lombok.NoArgsConstructor;
import rules.ChessFigure;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static game.Board.getFigureFromBoard;

/*
        Board includes squares
        Square includes figure

        abstract class Square
        abstract class Figure extends Square
        class King extends Figure
*/

@Data
@NoArgsConstructor
public abstract class Figure implements ChessFigure {
    private boolean isWhite;

    private char figureChar;

    private int rowPosition, colPosition;

    public List<int[]> availableMoves = new ArrayList<>();

    /*public abstract boolean figureCanMove();*/

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

    public boolean checkPawnAttackCorrect(int attackRow, int attackCol) {
        /*If offset correct with board*/
        if (checkCorrectOffsetBounds(attackRow, attackCol)) {
            return figureIsOpponent(getFigureFromBoard(attackRow, attackCol));
        }
        return false;
    }

    public boolean checkCorrectOffsetBounds(int row, int col) {
        return (row >= 0 & row < 8) & (col >= 0 & col < 8);
    }

    public void resolveOffsetBounds(int[][] possibleOffsets) {
        for (int[] offset : possibleOffsets) {
            int row = getRowPosition() + offset[0];
            int col = getColPosition() + offset[1];

            if (checkCorrectOffsetBounds(row, col)) {
                availableMoves.add(new int[]{row, col});
            }
        }
    }

    public void filterOwnFigures() {
        availableMoves = availableMoves.stream()
                .filter(this::checkOwnFigureOffset).collect(Collectors.toList());
    }

    private boolean checkOwnFigureOffset(int[] offset) {
        try
        {
            Figure figure = Board.getFigureFromBoard(offset[0], offset[1]);
            if (figure == null) {
                return true;
            }
            return figure.isWhite() != this.isWhite();
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getClass().getCanonicalName());
            return false;
        }
    }

    /*!!! TO ONE CYCLE METHOD WITH PARAMS*/

    /*!!! WRONG PARAMETERS*/

    public void resolveOffsetsUp(int currentRow, int currentCol) {
        /**/
        for (int row = currentRow; row >= 0; row--) {
            if (offsetAvailableToMove(getFigureFromBoard(row, currentCol))) {
                availableMoves.add(new int[] {row, currentCol});
            }
            else break;
        }
    }
    public void resolveOffsetsDown(int currentRow, int currentCol) {
        for (int row = currentRow; row < 8; row++) {
            if (offsetAvailableToMove(getFigureFromBoard(row, currentCol))) {
                availableMoves.add(new int[] {row, currentCol});
            }
            else break;
        }
    }
    public void resolveOffsetsLeft(int currentRow, int currentCol) {
        for (int col = currentCol; col >= 0; col--) {
            if (offsetAvailableToMove(getFigureFromBoard(currentRow, currentCol))) {
                availableMoves.add(new int[] {currentRow, currentCol});
            }
            else break;
        }
    }
    public void resolveOffsetsRight(int currentRow, int currentCol) {
        for (int col = currentCol; col < 8; col++) {
            if (offsetAvailableToMove(getFigureFromBoard(currentRow, currentCol))) {
                availableMoves.add(new int[] {currentRow, currentCol});
            }
            else break;
        }
    }
    public void resolveOffsetsUpLeft(int currentRow, int currentCol) {
        for (int row = currentRow, col = currentCol; row >= 0 & col >= 0; row--, col--) {
            if (offsetAvailableToMove(getFigureFromBoard(currentRow, currentCol))) {
                availableMoves.add(new int[] {row, currentCol});
            }
            else break;
        }
    }
    public void resolveOffsetsUpRight(int currentRow, int currentCol) {
        for (int row = currentRow, col = currentCol; row >= 0 & col < 8; row--, col++) {
            if (offsetAvailableToMove(getFigureFromBoard(currentRow, currentCol))) {
                availableMoves.add(new int[] {row, currentCol});
            }
            else break;
        }
    }
    public void resolveOffsetsDownLeft(int currentRow, int currentCol) {
        for (int row = currentRow, col = currentCol; row < 8 & col >= 0; row++, col--) {
            if (offsetAvailableToMove(getFigureFromBoard(currentRow, currentCol))) {
                availableMoves.add(new int[] {row, currentCol});
            }
            else break;
        }
    }
    public void resolveOffsetsDownRight(int currentRow, int currentCol) {
        for (int row = currentRow, col = currentCol; row < 8 & col < 8; row++, col++) {
            if (offsetAvailableToMove(getFigureFromBoard(currentRow, currentCol))) {
                availableMoves.add(new int[] {row, currentCol});
            }
            else break;
        }
    }
}
