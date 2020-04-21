package game;

import rules.Player;

import java.util.*;

public class ComputerPlayer implements Player {

    private final boolean isWhitePlayer;

    public ComputerPlayer(boolean whitePlayer) {
        this.isWhitePlayer = whitePlayer;
    }

    @Override
    public void move() throws NullPointerException, InterruptedException {
        try
        {
            /*Comment about current move*/
            moveComment();

            /*Get all available player`s figures*/
            List<Figure> playerFigures = getAvailablePlayerFigures(isWhitePlayer);
            System.out.println("Available figures: " + playerFigures.size());
            /// System.out.println("List of figures: " + (playerFigures.toString()));

            /*Get random figure with list of available moves (empty cells, no own figures) */
            Figure randomFigure = getRandomValidFigureFromBoard(playerFigures);
            randomFigure.aboutFigure();

            /*Get random figure move from its available moves*/
            int[] randomTurn = chooseRandomTurn(randomFigure);
            System.out.println("Random move to: " + Arrays.toString(randomTurn));

            /*Make random move with random figure*/
            makeTurn(randomFigure, randomTurn);

            Board.displayBoard();
            Thread.sleep(500);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println(e.getClass().getCanonicalName());
            System.out.println("ArrayIndexOutOfBoundsException!");
            Board.stopGame();
        }
        /*finally {
            nextMove();
        }*/
    }

    private void makeTurn(Figure randomFigure, int[] randomTurn) {
        final int fromRow = randomFigure.getRowPosition();
        final int fromCol = randomFigure.getColPosition();

        final int toRow = randomTurn[0];
        final int toCol = randomTurn[1];

        Figure targetFigure = Board.getFigureFromBoard(toRow, toCol);

        if (randomFigure.figureIsOpponent(targetFigure)) {
            /// beatOpponentFigure();
            Board.addBeatFigure(targetFigure);
        }

        /// moveFigure()
        Board.chessBoard()[toRow][toCol] = randomFigure;
        Board.chessBoard()[fromRow][fromCol] = null;
        randomFigure.setRowPosition(toRow);
        randomFigure.setColPosition(toCol);
    }

    private int[] chooseRandomTurn(Figure randomFigure) {
        randomFigure.printAllRandomMoves();
        /**/
        return randomFigure.getAvailableMoves().get(new Random().nextInt(randomFigure.getAvailableMoves().size()));
    }

    private void moveComment() {
        System.out.println("_____________________________________");
        if (this.isWhitePlayer) System.out.println("\nWhite turn!");
        else System.out.println("\nBlack turn!");
    }

    /*Get random valid-to-move figure*/
    private Figure getRandomValidFigureFromBoard(List<Figure> playerFigures) {

        while (!playerFigures.isEmpty())
        {
            Figure randomFigure = getRandomFigure(playerFigures);

            /*Check figure movement rule*/
            if (randomFigure.figureCanMove()) {
                System.out.println("Figure can move!");
                System.out.println("Available moves: " + randomFigure.getAvailableMoves().size());
                return randomFigure;
            }
            else
            {
                /*Next figure from available*/
                System.out.println("No moves for figure!");
                playerFigures.remove(randomFigure);
            }
        }

        /*If no valid-to-move figure available, end of game*/
        return null;
    }

    private Figure getRandomFigure(List<Figure> playerFigures) {
        /// Random random = new Random();
        return playerFigures.get(new Random().nextInt(playerFigures.size()));
    }

    private List<Figure> getAvailablePlayerFigures(boolean whitePlayer) {
        List<Figure> figuresList = new ArrayList<>();

        Arrays.stream(Board.chessBoard()).forEach(figures ->
        {
            Arrays.stream(figures).filter(Objects::nonNull).forEach(figure -> {
                if (whitePlayer) {
                    if (figure.isFigureWhite()) {
                        figuresList.add(figure);
                    }
                }
                else {
                    if (!figure.isFigureWhite()) {
                        figuresList.add(figure);
                    }
                }
            });
        });

        return figuresList;
    }
}
