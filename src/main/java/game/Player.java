package game;

import figures.Figure;
import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Player implements ComputerPlayer {

    private final boolean whitePlayer;

    public Player(boolean whitePlayer) {
        this.whitePlayer = whitePlayer;

    }

    @Override
    public void move() throws NullPointerException, InterruptedException {
        try
        {
            moveComment();

            List<Figure> playerFigures =  getAvailablePlayerFigures(this.whitePlayer); //getRandomValidFigureFromBoard(whitePlayer);
            System.out.println("Total figures: " + playerFigures.size());
            System.out.println("List of figures: " + (playerFigures.toString()));

            Figure randomFigure = getRandomValidFigureFromBoard(playerFigures);
            System.out.println("Random Figure: " + randomFigure.toString());


            //Figure randomFigure = getRandomValidFigureFromBoard(whitePlayer);

        /*assert randomFigure != null;
        System.out.println("Random figure: " + randomFigure.toString());

        makeRandomMove(randomFigure);
         ;*/
        }
        catch (NullPointerException e) {
            //e.printStackTrace();
            System.out.println("No more figures!");
            Board.stopGame();
        }
    }

   /* private List<Figure> getPlayerFigures(boolean whitePlayer) {
        //return null;

        //List<Figure> playerFigures = getAvailablePlayerFigures(whitePlayer);
        //System.out.println(playerFigures.toString());

    }*/

    private void makeRandomMove(Figure randomFigure) {
        System.out.println("Random Move!");


    }

    private void moveComment() throws InterruptedException {
        System.out.println("");
        if (this.whitePlayer) System.out.println("White turn!");
        else System.out.println("Black turn!");
        Thread.sleep(500);
    }

    private Figure getRandomValidFigureFromBoard(List<Figure> playerFigures) {
        //try {
        boolean noFigure = true;

        while (!playerFigures.isEmpty()) {

            Figure randomFigure = getRandomFigure(playerFigures);
            //System.out.println("Random figure: " + randomFigure);

            if (/*randomFigure.figureCanMove()*/figureCanMove(randomFigure)) {
                return randomFigure;
            }
            else playerFigures.remove(randomFigure);
        }

        return null;


            /*for (Figure figure : playerFigures) {
                if ()
            }*/
        //Figure randomFigure = null;
        //boolean hasValidFigures = true;
        //
            /*List<Figure> playerFigures = getAvailablePlayerFigures(whitePlayer);
            System.out.println(playerFigures.toString());*/
        //return randomFigure;
            /*do {
                if (noMoreMoves()) throw new SecurityException(); /// NoValidFigureException();
                *//*byte figureCol = randomFigureCol(whitePlayer);
                byte figureRow = randomFigureRow(whitePlayer);
                randomFigure = Board.chessBoard()[figureRow][figureCol];*//*
                List<Figure> playerFigures = getAvailablePlayerFigures(whitePlayer);
                System.out.println(playerFigures.toString());
                //if ()
                //else throw new NoValidFigure();
                //else throw new SecurityException();
                *//*for (int i = 0; i < ; i++) {
                }*//*
            }
            while (!figureValidToMove(randomFigure));*/
        //return randomFigure;
        // }

        /*catch (Exception e) {

            e.printStackTrace();

            return null;
        }*/
    }

    private boolean figureCanMove(Figure randomFigure) {

        if (randomFigure == null) return false;


        int i = ArrayUtils.indexOf(Board.chessBoard(), randomFigure);
        System.out.println("Figure Index: " + i);

        return false;
    }

    private Figure getRandomFigure(List<Figure> playerFigures) {
        Random random = new Random();
        return playerFigures.get(random.nextInt(playerFigures.size()));
        //return null;
    }

    private List<Figure> getAvailablePlayerFigures(boolean whitePlayer) {
        //return null;

        List<Figure> figuresList = new ArrayList<>();

        Arrays.stream(Board.chessBoard()).forEach(figures -> {
            Arrays.stream(figures).forEach(figure -> {

                if (whitePlayer) {
                    if (figure != null && figure.isFigureWhite()) {
                        figuresList.add(figure);
                    }
                }
                else {
                    if (figure != null && !figure.isFigureWhite()) {
                        figuresList.add(figure);
                    }
                }

                /*if (figure != null && figure.isFigureWhite()) {
                    figuresList.add(figure);
                }*/
            });
        });


        if (whitePlayer) {
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
        }




        return figuresList;
    }

    private boolean noMoreMoves() {
        return false;
    }

    private byte randomFigureRow(boolean whitePlayer) {
        return 0;
    }

    private byte randomFigureCol(boolean whitePlayer) {
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
