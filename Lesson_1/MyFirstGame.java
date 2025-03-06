import java.util.Random;

// Игра “Угадай число”
public class MyFirstGame {
    public static void main(String[] args) {
        int playerChoice = 44;
        Random rand = new Random();
        int computerChoice = rand.nextInt(1, 101);
        int lastMaxcomputerChoice = 100;
        int lastMincomputerChoice = 1;

        while (playerChoice != computerChoice) {
            if (computerChoice > playerChoice) {
                lastMaxcomputerChoice = computerChoice;
                System.out.println(computerChoice + " больше того, что загадал компьютер");
                computerChoice = rand.nextInt(lastMincomputerChoice, lastMaxcomputerChoice);
            } else {
                lastMincomputerChoice = computerChoice + 1;
                System.out.println(computerChoice + " меньше того, что загадал компьютер");
                computerChoice = rand.nextInt(lastMincomputerChoice, lastMaxcomputerChoice);
            }
        }
        System.out.printf("Ответ: %d%nВы победили!", computerChoice);
    }
}