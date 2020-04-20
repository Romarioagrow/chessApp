package figures;

public class Rook extends Figure {
    public Rook(boolean isWhite, char figureChar/*, byte row, byte cell*/) {
        super(isWhite, figureChar);
    }

    @Override
    public boolean isMoveValid(int fromRow, int fromCol, int toRow, int toCol) {
        return false;
    }

    @Override
    public boolean figureCanMove() {
        return false;
    }
}
