import java.util.Scanner;

public class GuessNumber {

    private Player firstPlayer;
    private Player secondPlayer;

    public GuessNumber(Player firstPlayer, Player secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
    }

    public Player inputNumbers() {
        Player winner = null;
        Scanner scan = new Scanner(System.in);
        int computerChoice = (int) (Math.random() * 100) + 1;

        int counter = 1;
        while (winner == null) {
            int number = 0;
            if (counter % 2 != 0) {
                // Игрок №1 вводит число
                do {
                    System.out.print(firstPlayer.getName() + " угадайте число в отрезке [1, 100]: ");
                    number = scan.nextInt();
                } while (number < 1 || number > 101);
                firstPlayer.setNumber(number);
            } else {
                // Игрок №2 вводит число
                do {
                    System.out.print(secondPlayer.getName() + " угадайте число в отрезке [1, 100]: ");
                    number = scan.nextInt();
                } while (number < 1 || number > 101);
                secondPlayer.setNumber(number);
            }

            winner = checkNumber(computerChoice);
            if (winner == null) {
                System.out.println("неверно");
            }

            firstPlayer.setNumber(0);
            secondPlayer.setNumber(0);
            counter++;
        }
        return winner;
    }

    private Player checkNumber(int computerChoice) {
        if (computerChoice == firstPlayer.getNumber()) {
            return firstPlayer;
        } 

        if (computerChoice == secondPlayer.getNumber()) {
            return secondPlayer;
        }
        return null;
    }
}