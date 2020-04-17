package figures;

public class Rook extends Figure {
    public Rook(boolean isWhite, char figureChar) {
        super(isWhite, figureChar);
    }

    @Override
    public boolean isMoveValid(int fromRow, int fromCol, int toRow, int toCol) {
        return false;
    }
}
