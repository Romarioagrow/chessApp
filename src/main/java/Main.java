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

        Board board = new Board();
        Board.displayBoard();


        while (Board.isGameRunning()) {


            if (Board.isWhiteTurn()) {

                Board.whiteMove();

            }

            else Board.blackMove();



        }

    }

}
