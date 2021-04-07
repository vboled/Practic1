import java.util.Scanner;

public class Main {
    public static void main(String[] argv) {
        int n = 0, k = 0;
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input number of players:");
            n = scanner.nextInt();
            System.out.println("Input number of Dices:");
            k = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Error while input data!");
            return;
        }
        try {
            DiceRoller game = new DiceRoller(n, k);
            game.play();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
