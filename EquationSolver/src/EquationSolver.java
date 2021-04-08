import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.sqrt;

public class EquationSolver {
    private double a, b, c;
    Discriminant disc;

    public static class Discriminant {
        public static double getDiscriminante(double a, double b, double c) {
            return b * b - 4 * a * c;
        }
    }

    public EquationSolver(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    List<Double> getSolve() {
        List<Double> res = new ArrayList<Double>();
        if (a == 0 && b == 0)                               //there are no solutions
            return null;
        if (a == 0) {                                       // this is the usual linear equation
            res.add(-c / b);
            return res;
        }
        double d = Discriminant.getDiscriminante(a, b, c);
        if (d < 0)                                          // there are no real solutions
            return null;
        else if (d == 0) {                                  // there is only one solution
            res.add(-b / (2 * a));
        } else {                                            // there are two solutions
            res.add((-b + sqrt(d)) / (2 * a));
            res.add((-b - sqrt(d)) / (2 * a));
        }
        return res;
    }
}
