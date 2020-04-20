package game;

import figures.Figure;

import java.util.*;

public class ComputerPlayer implements Player {

    private final boolean whitePlayer;

    public ComputerPlayer(boolean whitePlayer) {
        this.whitePlayer = whitePlayer;

    }

    @Override
    public void move() throws NullPointerException, InterruptedException {
        try
        {
            moveComment();

            List<Figure> playerFigures = getAvailablePlayerFigures(whitePlayer); //getRandomValidFigureFromBoard(whitePlayer);
            System.out.println("Total figures: " + playerFigures.size());
            System.out.println("List of figures: " + (playerFigures.toString()));


            Figure randomFigure = getRandomValidFigureFromBoard(playerFigures);
            System.out.println("Random Figure: " + randomFigure.toString());
            System.out.println("Figure has possible moves: " + randomFigure.getAvailableMoves().size());

            makeTurn(randomFigure);



        }
        catch (NullPointerException e) {
            System.out.println("No more figures!");
            Board.stopGame();
        }
    }

    private void makeTurn(Figure randomFigure) {
        System.out.println("Move figure: " + randomFigure.toString());
    }

    private void moveComment() throws InterruptedException {
        if (this.whitePlayer) System.out.println("\nWhite turn!");
        else System.out.println("Black turn!");
        Thread.sleep(500);
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
            else playerFigures.remove(randomFigure);
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
