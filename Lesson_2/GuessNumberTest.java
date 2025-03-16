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
        String choice = "";

        while (!choice.equals("no")) {
            // Вывести победителя
            printWinner(guessNumber.inputNumbers());

            // Продолжим?
            do {
                System.out.println("Хотите продолжить игру? [yes/no]:");
                choice = scan.next();
            } while (!choice.equals("yes") && !choice.equals("no"));
        }
    }

    public static void printWinner(Player winner) {
        System.out.println(winner.getName() + " Поздравляем вы победили");
    }
}