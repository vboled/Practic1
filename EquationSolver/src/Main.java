import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] argv) {
        Scanner in = new Scanner(System.in);
        double a, b, c;
        System.out.println("This program solves equations of the form: a * x^2 + b * x + c = 0");
        try {
            System.out.println("Input a: ");
            a = in.nextDouble();
            System.out.println("Input b: ");
            b = in.nextDouble();
            System.out.println("Input c: ");
            c = in.nextDouble();
        } catch (Exception e) {
            System.out.println("An error occurred while entering numbers");
            return;
        }
        EquationSolver solver = new EquationSolver(a, b, c);
        List<Double> res = solver.getSolve();
        if (res == null) {
            System.out.println("There are no solutions");
        } else if (res.size() == 1) {
            System.out.println("There is only one solution:");
            System.out.println("x = " + res.get(0));
        }
        else {
            System.out.println("There are two solutions:");
            System.out.println("x1 = " + res.get(0));
            System.out.println("x2 = " + res.get(1));
        }
    }
}
