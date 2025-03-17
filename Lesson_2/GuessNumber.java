import java.util.Scanner;

public class GuessNumber {

    private Player firstPlayer;
    private Player secondPlayer;

    public GuessNumber(Player firstPlayer, Player secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
    }

    public void play() {
        Player currPlayer = null;
        Scanner scan = new Scanner(System.in);
        int secretNumber = (int) (Math.random() * 100) + 1;

        do {
            int number = 0;
            firstPlayer.setNumber(0);
            secondPlayer.setNumber(0);

            // Первый игрок вводит число
            do {
                System.out.print(firstPlayer.getName() + " угадайте число в отрезке [1, 100]: ");
                number = scan.nextInt();
            } while (number < 1 || number > 101);
            firstPlayer.setNumber(number);
            currPlayer = checkNumber(firstPlayer, secretNumber);
            if (currPlayer != null) {
                break;
            }

            // Второй игрок вводит число
            do {
                System.out.print(secondPlayer.getName() + " угадайте число в отрезке [1, 100]: ");
                number = scan.nextInt();
            } while (number < 1 || number > 101);
            secondPlayer.setNumber(number);
        } while ((currPlayer = checkNumber(secondPlayer, secretNumber)) == null);
        printWinner(currPlayer);
    }

    private Player checkNumber(Player player, int secretNumber) {
        if (player.getNumber() == secretNumber) {
            return player;
        } else if (player.getNumber() < secretNumber) {
            System.out.println(player.getNumber() + " меньше загаданного числа");
        } else {
            System.out.println(player.getNumber() + " больше загаданного числа");
        }
        return null;
    }

    private static void printWinner(Player winner) {
        System.out.println(winner.getName() + " Поздравляем вы победили");
    }
}