import game.Board;

public class Main {

/*
Упрощенный вариант шахмат
Стандартное шахматное поле.
Играют два компьютера
Стандартная расстановка фигур
Компьютеры ходят поочереди хаотично выбирая фигуру
Если фигура может ходить то случайно выбирает любой из всех возможных ход
Если не может ходить - выбирает другую фигуру
Игра продолжается пока все игроки могут ходить
*/


    public static void main(String[] args) {

        try {

            Board board = new Board();

            board.startGame();


        }


        catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("No more figures!");
        }

        /*catch (InterruptedException e) {

            e.printStackTrace();

        }*/

    }

}
