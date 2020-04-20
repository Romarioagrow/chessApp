package game;

import figures.Figure;

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
            moveComment();

            List<Figure> playerFigures = getAvailablePlayerFigures(isWhitePlayer); //getRandomValidFigureFromBoard(whitePlayer);
            System.out.println("Available figures: " + playerFigures.size());
            //System.out.println("List of figures: " + (playerFigures.toString()));


            Figure randomFigure = getRandomValidFigureFromBoard(playerFigures);
            //System.out.println("Random Figure: " + randomFigure.toString());
            //System.out.println("Figure has possible moves: " + randomFigure.getAvailableMoves().size());

            //makeTurn(randomFigure);
            System.out.println("Player Random figure: " + randomFigure.toString());
            System.out.println("Figure has possible moves: " + randomFigure.getAvailableMoves().size());

            int[] randomTurn = chooseRandomTurn(randomFigure);
            System.out.println("Random move to: " + Arrays.toString(randomTurn));

            makeTurn(randomFigure, randomTurn);

            Board.displayBoard();

            Thread.sleep(500);

        }
        catch (NullPointerException e) {
            System.out.println("No more figures!");
            Board.stopGame();
        }
    }

    private void makeTurn(Figure randomFigure, int[] randomTurn) {
        int fromRow = randomFigure.getRowPosition();
        int fromCol = randomFigure.getColPosition();

        int toRow = /*fromRow +*/ randomTurn[0];
        int toCol = /*fromCol +*/ randomTurn[1];

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
        //System.out.println( randomFigure.getAvailableMoves().toString());

        randomFigure.getAvailableMoves().forEach(ints -> {
            System.out.println(ints[0] + ":" + ints[1]);
        });

        return randomFigure.getAvailableMoves().get(new Random().nextInt(randomFigure.getAvailableMoves().size()));
    }

    private void moveComment() {
        System.out.println("_____________________________________");
        if (this.isWhitePlayer) System.out.println("\nWhite turn!");
        else System.out.println("\nBlack turn!");
    }

    private Figure getRandomValidFigureFromBoard(List<Figure> playerFigures) {
        /// try {}
        boolean noFigure = true;

        /*Get random valid-to-move figure*/
        while (!playerFigures.isEmpty()) {

            Figure randomFigure = getRandomFigure(playerFigures);

            if (randomFigure.figureCanMove()) {
                return randomFigure;
            }
            else {
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

        /*if (whitePlayer) {
            Arrays.stream(Board.chessBoard()).forEach(figures -> {
                Arrays.stream(figures).forEach(figure -> {
                    if (figure != null && figure.isFigureWhite()) {
                        figuresList.add(figure);
                    }
                });
            });
            //List<Boolean> result = Arrays.stream(Board.chessBoard()).flatMap(array -> array.stream().map(value -> true)).collect(Collectors.toList());
        }
        else {
            Arrays.stream(Board.chessBoard()).forEach(figures -> {
                Arrays.stream(figures).forEach(figure -> {
                    if (figure != null && !figure.isFigureWhite()) {
                        figuresList.add(figure);
                    }
                });
            });
        }*/
    }
}
