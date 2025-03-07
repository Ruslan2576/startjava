import java.util.Random;

// Игра “Угадай число”
public class MyFirstGame {
    public static void main(String[] args) {
        Random rand = new Random();
        int targetNum = 44;
        int playerChoice = rand.nextInt(1, 101);
        int lastMaxPlayerChoice = 100;
        int lastMinPlayerChoice = 1;

        while (targetNum != playerChoice) {
            if (playerChoice > targetNum) {
                lastMaxPlayerChoice = playerChoice;
                System.out.println(playerChoice + " больше того, что загадал компьютер");
            } else {
                lastMinPlayerChoice = playerChoice + 1;
                System.out.println(playerChoice + " меньше того, что загадал компьютер");
            }
            playerChoice = rand.nextInt(lastMinPlayerChoice, lastMaxPlayerChoice);
        }
        System.out.printf("Ответ: %d%nВы победили!", playerChoice);
    }
}