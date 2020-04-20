package figures;

import game.Board;

import java.util.Arrays;

public class Rook extends Figure {
    public Rook(boolean isWhite, char figureChar, int row, int cell) {
        super(isWhite, figureChar, row, cell);
    }

    @Override
    public boolean isMoveValid(int fromRow, int fromCol, int toRow, int toCol) {
        return false;
    }

    @Override
    public boolean figureCanMove() {
        System.out.println("\nCheck Rook");
        System.out.format(this.toString() + "\nFigure Coords: %s-%s ", getRowPosition(), getColPosition());
        System.out.println();

        int currentRow = getRowPosition();
        int currentCol = getColPosition();

        /*up*/
        for (int i = 1; i < 8 && (currentRow + i < 8) /*& i < currentRow*/; i++) {
            Figure figure;

            int rowUp = currentRow + i;
            /*if (rowUp < 8)
            {*/

            System.out.println("\nrowUp: " + (rowUp));
            System.out.println("currentCol: " + (currentCol));

            figure = Board.chessBoard()[rowUp][currentCol];
            if (figure == null || figure.isFigureWhite() != this.isFigureWhite()) {
                availableMoves.add(new int[]{rowUp, currentCol});
            }
            else break;
        }

        /*down*/
        for (int i = 1; i < 8 && (currentRow - i >= 0) /*& i < currentRow*/; i++) {
            Figure figure;
            int rowDown = currentRow - i;

            System.out.println("\nrowDown: " + (rowDown));
            System.out.println("currentCol: " + (currentCol));

            figure = Board.chessBoard()[rowDown][currentCol];
            if (figure == null || figure.isFigureWhite() != this.isFigureWhite()) {
                availableMoves.add(new int[]{rowDown, currentCol});
            }
            else break;
        }

        /*right*/
        for (int i = 1; i < 8 && (currentCol + i < 8) /*& i < currentRow*/; i++) {
            Figure figure;
            int colRight = currentCol + i;

            System.out.println("\ncurrentRow: " + (currentRow));
            System.out.println("colRight: " + (colRight));

            figure = Board.chessBoard()[currentRow][colRight];
            if (figure == null || figure.isFigureWhite() != this.isFigureWhite()) {
                availableMoves.add(new int[]{currentRow, colRight});
            }
            else break;
        }


        /*right*/
        for (int i = 1; i < 8 && (currentCol - i >= 0) /*& i < currentRow*/; i++) {
            Figure figure;
            int colLeft = currentCol - i;

            System.out.println("\ncurrentRow: " + (currentRow));
            System.out.println("colLeft: " + (colLeft));

            figure = Board.chessBoard()[currentRow][colLeft];
            if (figure == null || figure.isFigureWhite() != this.isFigureWhite()) {
                availableMoves.add(new int[]{currentRow, colLeft});
            }
            else break;
        }





       /* for (int i = 1; i < 8 *//*& i < currentRow*//*; i++) {
            try
            {
                *//*Move up*//*
                System.out.println("\ncurrentRow: " + currentRow);
                System.out.println("currentCol: " + currentCol);
                Figure figure;
                *//*System.out.println("currentRow + i: " + (currentRow + i));
                System.out.println("currentCol + i: " + (currentCol + i));*//*

                *//*Move up*//*

                int rowUp = currentRow + i;
                if (rowUp < 8)
                {
                    System.out.println("\nrowUp: " + (rowUp));
                    System.out.println("currentCol: " + (currentCol));
                    figure = Board.chessBoard()[rowUp][currentCol];
                    if (figure == null) {
                        availableMoves.add(new int[]{rowUp, currentCol});
                    }
                }

                *//*Move down*//*
                int rowDown = currentRow - i;
                if (rowDown >= 0)
                {
                    System.out.println("\nrowDown: " + (rowDown));
                    System.out.println("currentCol: " + (currentCol));
                    figure = Board.chessBoard()[rowDown][currentCol];
                    if (figure == null) {
                        availableMoves.add(new int[]{rowDown, currentCol});
                    }
                }

                *//*Move right*//*
                int colRight = currentCol + i;
                if (colRight < 8)
                {
                    System.out.println("\ncurrentRow: " + (currentRow));
                    System.out.println("colRight: " + (colRight));
                    figure = Board.chessBoard()[currentRow][colRight];
                    if (figure == null) {
                        availableMoves.add(new int[]{currentRow, colRight});
                    }
                }


                *//*Move left*//*
                int colLeft = currentCol - i;
                if (colLeft >= 0)
                {
                    System.out.println("\ncurrentRow: " + (currentRow));
                    System.out.println("colLeft: " + (colLeft));
                    figure = Board.chessBoard()[currentRow][colLeft];
                    if (figure == null) {
                        availableMoves.add(new int[]{currentRow, colLeft});
                    }
                }

            }
            catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("За границей доски, следующий!");
            }
        }*/


        System.out.println(availableMoves.size());

        availableMoves.forEach(ints -> {
            System.out.println(Arrays.toString(ints));
        });

        /*System.out.println(availableMoves.toString());
        System.out.println(availableMoves.toString());*/
        //return !availableMoves.isEmpty();
        return false;
        /*for (int i = 0; i < 8 & i < currentRow; i++) {
         *//*try
            {*//*
            Figure figure = Board.chessBoard()[currentRow + 1][currentCol];
            if (figure == null) {
                availableMoves.add(new int[]{currentRow + 1, currentCol});
            }
            *//*}
            catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("За границей доски, следующий!");
            }*//*
        }*/


        /*
        * elif board[x][y] == "bRook":
    u = [(x, y+i) for i in range(1,8) if 0<=x<8 and 0<=y<8]
    d = [(x, y-i) for i in range(1,8) if 0<=x<8 and 0<=y<8]
    l = [(x-i, y) for i in range(1,8) if 0<=x<8 and 0<=y<8]
    r = [(x+i, y) for i in range(1,8) if 0<=x<8 and 0<=y<8]
    potential_moves += u + d + l + r
    * */



        //return false;
    }
}
