package figures;

import game.Board;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    public boolean availableToAdd(Figure figure) {
        return figure == null || figure.isFigureWhite() != this.isFigureWhite();
    }

    /*public boolean figureIsOpposite(figure) {

    }*/

    public char getFigureChar() {
        return figureChar;
    }

    public boolean isFigureWhite() {
        return isWhite;
    }

    public abstract boolean figureCanMove();

    /*public void filterAvailableMoves() {
        availableMoves = availableMoves.stream().filter(offsetArray -> {
            Figure figure = Board.chessBoard()[0][1];
            return availableToAdd(figure);
        }).collect(Collectors.toList());
    }*/

    protected void resolveArrayOffsets(int[][] possibleOffsets) {
        availableMoves = Arrays.stream(possibleOffsets).filter(ints -> {
            int row = ints[0];
            int col = ints[1];
            return availableToAdd(Board.chessBoard()[row][col]);
        }).collect(Collectors.toList());
    }

    protected void resolveOffsetsUp(int currentRow, int currentCol) {
        for (int row = currentRow; row >= 0; row--) {
            if (availableToAdd(Board.chessBoard()[row][currentCol])) {
                availableMoves.add(new int[] {row, currentCol});
            }
            else break;
        }
    }

    protected void resolveOffsetsDown(int currentRow, int currentCol) {
        for (int row = currentRow; row < 8; row++) {
            if (availableToAdd(Board.chessBoard()[row][currentCol])) {
                availableMoves.add(new int[] {row, currentCol});
            }
            else break;
        }
    }

    protected void resolveOffsetsLeft(int currentRow, int currentCol) {
        for (int col = currentCol; col >= 0; col--) {
            if (availableToAdd(Board.chessBoard()[currentRow][currentCol])) {
                availableMoves.add(new int[] {currentRow, currentCol});
            }
            else break;
        }
    }

    protected void resolveOffsetsRight(int currentRow, int currentCol) {
        for (int col = currentCol; col < 8; col++) {
            if (availableToAdd(Board.chessBoard()[currentRow][currentCol])) {
                availableMoves.add(new int[] {currentRow, currentCol});
            }
            else break;
        }
    }

    protected void resolveOffsetsUpLeft(int currentRow, int currentCol) {
        for (int row = currentRow, col = currentCol; row >= 0 & col >= 0; row--, col--) {
            if (availableToAdd(Board.chessBoard()[row][currentCol])) {
                availableMoves.add(new int[] {row, currentCol});
            }
            else break;
        }
    }

    protected void resolveOffsetsUpRight(int currentRow, int currentCol) {
        for (int row = currentRow, col = currentCol; row >= 0 & col < 8; row--, col++) {
            if (availableToAdd(Board.chessBoard()[row][currentCol])) {
                availableMoves.add(new int[] {row, currentCol});
            }
            else break;
        }
    }

    protected void resolveOffsetsDownLeft(int currentRow, int currentCol) {
        for (int row = currentRow, col = currentCol; row < 8 & col >= 0; row++, col--) {
            if (availableToAdd(Board.chessBoard()[row][currentCol])) {
                availableMoves.add(new int[] {row, currentCol});
            }
            else break;
        }
    }

    protected void resolveOffsetsDownRight(int currentRow, int currentCol) {
        for (int row = currentRow, col = currentCol; row < 8 & col < 8; row++, col++) {
            if (availableToAdd(Board.chessBoard()[row][currentCol])) {
                availableMoves.add(new int[] {row, currentCol});
            }
            else break;
        }
    }
}
