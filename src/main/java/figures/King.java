package figures;

public class King extends Figure {

    public King(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean isMoveValid(int fromRow, int fromCol, int toRow, int toCol) {
        return false;
    }

}
