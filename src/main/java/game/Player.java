package game;

import figures.Figure;
import org.apache.commons.lang3.ArrayUtils;

public class Player implements ComputerPlayer {

    private boolean whitePlayer;

    public Player(boolean whitePlayer) {
        this.whitePlayer = whitePlayer;

    }

    @Override
    public void move() throws InterruptedException {


        //String moveCoordinates = resolveMoveCoordinates(whitePlayer);

        Figure randomFigure = getRandomValidFigureFromBoard(whitePlayer);


        System.out.println(ArrayUtils.indexOf(Board.chessBoard(), randomFigure));


        //ArrayUtils.indexOf(Board.chessBoard(), randomFigure);

        //ArrayUtils.

        //randomFigure.



        moveComment();

    }

    private void moveComment() throws InterruptedException {
        System.out.println("");
        if (this.whitePlayer) System.out.println("White turn!");
        else System.out.println("Black turn!");
        Thread.sleep(500);
    }

    private Figure getRandomValidFigureFromBoard(boolean whitePlayer) {
        try
        {
            boolean hasValidFigures = true;

            Figure randomFigure = null;

            //return randomFigure;
            do {

                if (noMoreMoves()) throw new SecurityException(); /// NoValidFigureException();

                byte figureCol = randomFigureCol();
                byte figureRow = randomFigureRow();

                randomFigure = Board.chessBoard()[figureRow][figureCol];


                //if ()


                //else throw new NoValidFigure();
                //else throw new SecurityException();
                /*for (int i = 0; i < ; i++) {
                }*/
            }
            while (!figureValidToMove(randomFigure));

            return randomFigure;

        }

        catch (Exception e) {

            e.printStackTrace();

            return null;
        }
    }

    private boolean noMoreMoves() {
        return false;
    }

    private byte randomFigureRow() {
        return 0;
    }

    private byte randomFigureCol() {
        //return 0;

        return 0;
    }

    private boolean figureValidToMove(Figure figure) {
        System.out.println(figure.toString());


        //boolean

        return true;
        //return false;
    }

   /* private String resolveMoveCoordinates(boolean whitePlayer) {

        //if (whitePlayer)

        return null;
    }*/

    @Override
    public boolean moveCorrect() {
        return false;
    }
}
