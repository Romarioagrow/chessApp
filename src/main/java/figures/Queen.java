package figures;

public class Queen extends Figure {

    public Queen(boolean isWhite, char figureChar) {
        super(isWhite, figureChar);
    }

    @Override
    public boolean isMoveValid(int fromRow, int fromCol, int toRow, int toCol) {
        return false;
    }


}
