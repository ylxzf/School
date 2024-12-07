package numerics;

public class HornerSchemeApp {
    public static void main(String[] args) {
        int[] demo = {4, -3, -4, 1, 0, 2};
        int x = 3;
        HornerScheme hornerScheme = new HornerScheme(demo, x);
        hornerScheme.showPolynomial();
        hornerScheme.showCalculationResult();
    }
}
