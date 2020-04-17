package figures;

public class Rook extends Figure {

    public Rook(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean isMoveValid(int fromRow, int fromCol, int toRow, int toCol) {
        return false;
    }

}
