import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DiceRoller {
    private ArrayList<Player> allPlayers = new ArrayList<Player>();
    private int numberOfDices;

    public DiceRoller(int numberOfPlayers, int numberOfDices) throws Exception {
        if (numberOfPlayers < 2) {
            throw new Exception("Not enough players");
        } else if (numberOfDices < 1) {
            throw new Exception("Not enough dices");
        }
        this.numberOfDices = numberOfDices;
        allPlayers.add(new Player("You"));
        for (int i = 0; i < numberOfPlayers - 2; i++) {
            allPlayers.add(new Player(i + 1 + "Player"));
        }
        allPlayers.add(new Player("Computer"));
    }

    int makeTurn(Player player) {
        int score = 0;
        int turnScoreSum = 0;
        if (player.getNickname() == "You") {
            System.out.println("This is your turn!");
            System.out.println("Press Enter key to roll dice");
            Scanner scanner = new Scanner(System.in);
            String tap = scanner.nextLine();
        }
        System.out.println(player.getNickname() + " turn is: ");
        for (int i = 0; i < numberOfDices; i++) {
            score = (int)(Math.random() * 6) + 1;
            System.out.print(score + " ");
            turnScoreSum += score;
        }
        player.setTurnScore(turnScoreSum);
        System.out.println("sum: " + turnScoreSum);
        System.out.println();
        return turnScoreSum;
    }

    void printScores() {
        for (Player player : allPlayers) {
            System.out.println(player.getNickname() + " " + player.getNumberOfWins());
        }
    }

    void turnWinners(int maxTurnScores) {
        System.out.println("In this turn wins: ");
        for (Player player : allPlayers) {
            if (maxTurnScores == player.getTurnScore()) {
                player.increaseNumberOfWins();
                System.out.print(player.getNickname() + " ");
            }
        }
        System.out.println();
        System.out.println();
    }

    void congratulation() {
        System.out.println("Congratulate winners: ");
        for (Player player : allPlayers) {
            if (player.getNumberOfWins() == 7) {
                System.out.print(player.getNickname() + " ");
            }
        }
        System.out.println("\n3End Game!");
    }

    public void play() {
        while (true) {
            int maxTurnScore = 0;
            for (Player player : allPlayers) {
                int currentScore = this.makeTurn(player);
                if (currentScore > maxTurnScore) {
                    maxTurnScore = currentScore;
                }
                player.increaseScore(currentScore);
            }
            this.turnWinners(maxTurnScore);
            System.out.println("Subtotals: ");
            this.printScores();
            for (Player player : allPlayers) {
                if (player.getNumberOfWins() == 7) {
                    this.congratulation();
                    return;
                }
            }
        }
    }

}