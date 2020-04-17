package figures;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public abstract class Figure {


    private boolean isWhite;


    public Figure(boolean isWhite) {

        this.isWhite = isWhite;

    }


    public boolean isFigureWhite() {

        return isWhite;

    }

    public abstract boolean isMoveValid(int fromRow, int fromCol, int toRow, int toCol);


}
