public class Player implements Comparable<Player> {
    private int scores;
    private int numberOfWins;
    private int turnScore;
    private String nickname;

    public Player(String nickname) {
        this.nickname = nickname;
        this.scores = 0;
        this.numberOfWins = 0;
    }

    @Override
    public int compareTo(Player player) {
        return player.turnScore -this.turnScore;
    }

    void increaseNumberOfWins() {
        this.numberOfWins += 1;
    }

    public int getScores() {
        return scores;
    }

    public int getNumberOfWins() {
        return numberOfWins;
    }

    public String getNickname() {
        return nickname;
    }

    public void setTurnScore(int turnScore) {
        this.turnScore = turnScore;
    }

    public int getTurnScore() {
        return turnScore;
    }

    public void increaseScore(int scores) {
        this.scores += scores;
    }
}
