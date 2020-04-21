package game;

import lombok.Data;
import lombok.NoArgsConstructor;
import rules.ChessFigure;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static game.Board.getFigureFromBoard;

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

    public void addCurrentOffset(int currentRow, int currentCol) {
        availableMoves.add(new int[] {currentRow, currentCol});
    }

    /*!!! TO ONE CYCLE METHOD WITH PARAMS*/

    public void resolveOffsetsUp(int currentRow, int currentCol) {
        for (int toRow = currentRow - 1; toRow >= 0; toRow--) {

            if (checkCorrectOffsetBounds(currentRow, currentCol))
            {
                Figure checkFigure = Board.getFigureFromBoard(toRow, currentCol);
                if (checkFigure == null) {
                    addCurrentOffset(toRow, currentCol);
                    continue;
                }
                if (figureIsOpponent(checkFigure)) {
                    addCurrentOffset(toRow, currentCol);
                }
                break;
            }
        }
    }

    public void resolveOffsetsDown(int currentRow, int currentCol) {
        for (int toRow = currentRow + 1; toRow < 8; toRow++) {

            if (checkCorrectOffsetBounds(currentRow, currentCol))
            {
                Figure checkFigure = Board.getFigureFromBoard(toRow, currentCol);
                if (checkFigure == null) {
                    addCurrentOffset(toRow, currentCol);
                    continue;
                }
                if (figureIsOpponent(checkFigure)) {
                    addCurrentOffset(toRow, currentCol);
                }
                break;
            }
        }
    }

    public void resolveOffsetsLeft(int currentRow, int currentCol) {
        for (int toCol = currentCol - 1; toCol >= 0; toCol--) {

            if (checkCorrectOffsetBounds(currentRow, toCol))
            {
                Figure checkFigure = Board.getFigureFromBoard(currentRow, toCol);
                if (checkFigure == null) {
                    addCurrentOffset(currentRow, toCol);
                    continue;
                }
                if (figureIsOpponent(checkFigure)) {
                    addCurrentOffset(currentRow, toCol);
                }
                break;
            }
        }
    }

    public void resolveOffsetsRight(int currentRow, int currentCol) {
        for (int toCol = currentCol + 1; toCol < 8; toCol++) {

            if (checkCorrectOffsetBounds(currentRow, toCol))
            {
                Figure checkFigure = Board.getFigureFromBoard(currentRow, toCol);
                if (checkFigure == null) {
                    addCurrentOffset(currentRow, toCol);
                    continue;
                }
                if (figureIsOpponent(checkFigure)) {
                    addCurrentOffset(currentRow, toCol);
                }
                break;
            }
        }
    }

    public void resolveOffsetsUpLeft(int currentRow, int currentCol) {
        for (int toRow = currentRow - 1, toCol = currentCol - 1; toRow >= 0 & toCol >= 0; toRow--, toCol--) {

            if (checkCorrectOffsetBounds(toRow, toCol))
            {
                Figure checkFigure = Board.getFigureFromBoard(toRow, toCol);
                if (checkFigure == null) {
                    addCurrentOffset(toRow, toCol);
                    continue;
                }
                if (figureIsOpponent(checkFigure)) {
                    addCurrentOffset(toRow, toCol);
                }
                break;
            }
        }
    }

    public void resolveOffsetsUpRight(int currentRow, int currentCol) {
        for (int toRow = currentRow - 1, toCol = currentCol + 1; toRow >= 0 & toCol < 8; toRow--, toCol++) {

            if (checkCorrectOffsetBounds(toRow, toCol))
            {
                Figure checkFigure = Board.getFigureFromBoard(toRow, toCol);
                if (checkFigure == null) {
                    addCurrentOffset(toRow, toCol);
                    continue;
                }
                if (figureIsOpponent(checkFigure)) {
                    addCurrentOffset(toRow, toCol);
                }
                break;
            }
        }
    }

    public void resolveOffsetsDownLeft(int currentRow, int currentCol) {
        for (int toRow = currentRow + 1, toCol = currentCol - 1; toRow < 8 & toCol >= 0; toRow++, toCol--) {

            if (checkCorrectOffsetBounds(toRow, toCol))
            {
                Figure checkFigure = Board.getFigureFromBoard(toRow, toCol);
                if (checkFigure == null) {
                    addCurrentOffset(toRow, toCol);
                    continue;
                }
                if (figureIsOpponent(checkFigure)) {
                    addCurrentOffset(toRow, toCol);
                }
                break;
            }
        }
    }

    public void resolveOffsetsDownRight(int currentRow, int currentCol) {
        for (int toRow = currentRow + 1, toCol = currentCol + 1; toRow < 8 & toCol < 8; toRow++, toCol++) {

            if (checkCorrectOffsetBounds(toRow, toCol))
            {
                Figure checkFigure = Board.getFigureFromBoard(toRow, toCol);
                if (checkFigure == null) {
                    addCurrentOffset(toRow, toCol);
                    continue;
                }
                if (figureIsOpponent(checkFigure)) {
                    addCurrentOffset(toRow, toCol);
                }
                break;
            }
        }
    }

    protected void printFigureInfo(String figureName) {
        System.out.format("\nCheck %s", figureName + "\n");
        System.out.println("Coords: " + getRowPosition() + " - " + getColPosition());
        //System.out.format("Figure Coords: %s - %s ", getRowPosition(), getColPosition() + "\n");
    }


    public void aboutFigure() {
        String color = isWhite() ? "White " : "Black ";
        System.out.println("Random figure: " + color + getClass().getSimpleName() + " " + getFigureChar());
        System.out.println("Coords: " + getRowPosition() + " - " + getColPosition());
        //System.out.format("Coords: %s - %s ", getRowPosition(), getColPosition());
    }

    public void printAllRandomMoves() {
        this.getAvailableMoves().forEach(offset -> System.out.println(offset[0] + ":" + offset[1]));
    }
}
