import java.util.*;
import java.util.concurrent.TimeUnit;

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
        if (player.getNickname() == "You") {                    // Имитируем ход пользователя
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
        System.out.println("\n\n");
    }

    void congratulation() {
        System.out.println("Congratulate winners: ");
        for (Player player : allPlayers) {
            if (player.getNumberOfWins() == 7) {
                System.out.print(player.getNickname() + " ");
            }
        }
        System.out.println("\nEnd Game!");
    }

    public void play() throws InterruptedException {
        while (true) {                                  // Вечный цикл, который прерывается при достижении каким-либо игроков 7 побед
            int maxTurnScore = 0;
            for (Player player : allPlayers) {
                int currentScore = this.makeTurn(player);
                if (currentScore > maxTurnScore) {
                    maxTurnScore = currentScore;
                }
                player.increaseScore(currentScore);
            }
            this.turnWinners(maxTurnScore);         // Определеяем победителей раунда
            Collections.sort(this.allPlayers);      // Сортируем массив с игроками по количеству набранных очков в последней партии
            System.out.println("Subtotals: ");
            this.printScores();
            Thread.sleep(2000);               // Задержка для того, чтобы можно было посмотреть результаты последнего раунда
            for (Player player : allPlayers) {
                if (player.getNumberOfWins() == 7) {  // Проверка на наличие победителя
                    this.congratulation();
                    return;
                }
            }
        }
    }

}
