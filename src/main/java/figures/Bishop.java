package figures;

public class Bishop extends Figure{

    public Bishop(boolean isWhite, char figureChar) {
        super(isWhite, figureChar);
    }

    @Override
    public boolean isMoveValid(int fromRow, int fromCol, int toRow, int toCol) {
        return false;
    }

}
