package figures;

public class King extends Figure {

    public King(boolean isWhite, char figureChar) {
        super(isWhite, figureChar);
    }

    @Override
    public boolean isMoveValid(int fromRow, int fromCol, int toRow, int toCol) {
        return false;
    }

    //private char

}
