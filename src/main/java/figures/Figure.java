package figures;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
public abstract class Figure {
    private boolean isWhite;

    private char figureChar;

    //private int[][] position;

    private int rowPosition, colPosition;

    ArrayList<int[]> availableMoves = new ArrayList<>();

    public Figure(boolean isWhite, char figureChar, int rowPosition, int colPosition) {
        this.isWhite = isWhite;
        this.figureChar = figureChar;
        this.rowPosition = rowPosition;
        this.colPosition = colPosition;
    }

    public char getFigureChar() {
        return figureChar;
    }

    public boolean isFigureWhite() {
        return isWhite;
    }

    public abstract boolean figureCanMove(/*Figure figure*/);

    public abstract boolean isMoveValid(int fromRow, int fromCol, int toRow, int toCol);

    //public abstract boolean figureCanMove();
}
