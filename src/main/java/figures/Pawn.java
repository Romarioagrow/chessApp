package figures;

public class Pawn extends Figure {
    public Pawn(boolean isWhite, char figureChar) {
        super(isWhite, figureChar);
    }

    @Override
    public boolean isMoveValid(int fromRow, int fromCol, int toRow, int toCol) {
        return false;
    }

}
