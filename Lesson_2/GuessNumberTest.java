import java.util.Scanner;

public class GuessNumberTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Получаем имя и инициализируем первого игрока
        System.out.print("Игрок №1 введите своё имя: ");
        String name = scan.next();
        Player firstPlayer = new Player(name);

        // Получаем имя и инициализируем второго игрока
        System.out.print("\nИгрок №2 введите своё имя: ");
        name = scan.next();
        Player secondPlayer = new Player(name);

        GuessNumber guessNumber = new GuessNumber(firstPlayer, secondPlayer);
        Player winner = null;
        String choice = "";

        int computerChoice = (int) (Math.random() * 100) + 1;
        while (!choice.equals("no")) {
            firstPlayer.setNumber(0);
            secondPlayer.setNumber(0);
            do {
                // Первый игрок вводит число
                int number = 0;
                do {
                    System.out.print(firstPlayer.getName() + " угадайте число в отрезке [1, 100]: ");
                    number = scan.nextInt();
                } while (number < 1 || number > 101);
                firstPlayer.setNumber(number);
                winner = guessNumber.checkNumber(computerChoice);
                if (winner != null) {
                    break;
                }
                System.out.println("Неверно");

                // Второй игрок вводит число
                do {
                    System.out.print(secondPlayer.getName() + " угадайте число в отрезке [1, 100]: ");
                    number = scan.nextInt();
                } while (number < 1 || number > 101);
                secondPlayer.setNumber(number);
                winner = guessNumber.checkNumber(computerChoice);
                if (winner != null) {
                    break;
                }
                System.out.println("Неверно");
            } while (winner == null);
            printWinner(winner);

            // Продолжим?
            do {
                System.out.println("Хотите продолжить игру? [yes/no]:");
                choice = scan.next();
            } while (!choice.equals("yes") && !choice.equals("no"));
        }
    }

    public static void printWinner(Player winner) {
        System.out.println(winner.getName() + " вы победили");
    }
}