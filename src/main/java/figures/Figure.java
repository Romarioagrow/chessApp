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

    private int rowPosition, colPosition;

    ArrayList<int[]> availableMoves = new ArrayList<>();

    public Figure(boolean isWhite, char figureChar, int rowPosition, int colPosition) {
        this.isWhite = isWhite;
        this.figureChar = figureChar;
        this.rowPosition = rowPosition;
        this.colPosition = colPosition;
    }

    public boolean figureIsOpposite(Figure figure) {
        return figure.isFigureWhite() != this.isFigureWhite();
    }

    public char getFigureChar() {
        return figureChar;
    }

    public boolean isFigureWhite() {
        return isWhite;
    }

    public abstract boolean figureCanMove();

    public abstract boolean isMoveValid(int fromRow, int fromCol, int toRow, int toCol);


    public abstract boolean isCoordinatesValid(int ... coordinates);



    //public abstract boolean figureCanMove();
}
