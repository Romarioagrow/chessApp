package figures;

public class Knight extends Figure {

    public Knight(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean isMoveValid(int fromRow, int fromCol, int toRow, int toCol) {
        return false;
    }

}
