public class GuessNumber {

    private Player firstPlayer;
    private Player secondPlayer;

    public GuessNumber(Player firstPlayer, Player secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
    }

    public Player checkNumber(int computerChoice) {
        if (computerChoice == firstPlayer.getNumber()) {
            return firstPlayer;
        } 

        if (computerChoice == secondPlayer.getNumber()) {
            return secondPlayer;
        }
        return null;
    }
}