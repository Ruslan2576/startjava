import java.util.Scanner;

public class GuessNumber {

    private Player firstPlayer;
    private Player secondPlayer;

    public GuessNumber(Player firstPlayer, Player secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
    }

    public void play() {
        int secretNumber = (int) (Math.random() * 100) + 1;
        while (true) {
            inputNumber(firstPlayer);
            if (checkNumber(firstPlayer, secretNumber)) {
                break;
            }

            inputNumber(secondPlayer);
            if (checkNumber(secondPlayer, secretNumber)) {
                break;
            }
        }
    }

    private static void inputNumber(Player player) {
        Scanner scan = new Scanner(System.in);
        int number = 0;
        do {
            System.out.print(player.getName() + " угадайте число в отрезке [1, 100]: ");
            number = scan.nextInt();
        } while (number < 1 || number > 101);
        player.setNumber(number);
    }

    private static boolean checkNumber(Player player, int secretNumber) {
        int currNumber = player.getNumber();
        if (currNumber == secretNumber) {
            System.out.println(player.getName() + " Поздравляем, вы победили.");
            return true;
        } 

        if (currNumber < secretNumber) {
            System.out.println(currNumber + " меньше загаданного числа");
        } else {
            System.out.println(currNumber + " больше загаданного числа");
        }
        return false;
    }
}