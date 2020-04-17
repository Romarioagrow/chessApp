package figures;

public class Pawn extends Figure {

    public Pawn(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean isMoveValid(int fromRow, int fromCol, int toRow, int toCol) {
        return false;
    }

}
