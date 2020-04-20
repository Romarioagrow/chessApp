package figures;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public abstract class Figure {
    private boolean isWhite;

    private char figureChar;

    //private int[][] position;



    public Figure(boolean isWhite, char figureChar) {
        this.isWhite = isWhite;
        this.figureChar = figureChar;
    }

    public char getFigureChar() {
        return figureChar;
    }

    public boolean isFigureWhite() {
        return isWhite;
    }

    public abstract boolean figureCanMove();

    public abstract boolean isMoveValid(int fromRow, int fromCol, int toRow, int toCol);

    //public abstract boolean figureCanMove();
}
