package numerics;

public class IntervalHalving {

    int counter = 0;

    double lowerBarrier;
    double higherBarrier;
    final double ACCURACY;

    public IntervalHalving(double a, double b, double c) {
        lowerBarrier = a;
        higherBarrier = b;
        ACCURACY = c;
    }

    double f(double x) {
//        input function
//        return 4 * Math.pow(x, 2) - 4 * x - 4;
        return Math.pow(x, 2) + 2;
    }

    public double getLowerBarrier() {
        return lowerBarrier;
    }

    public void setLowerBarrier(double lowerBarrier) {
        this.lowerBarrier = lowerBarrier;
    }

    public double getHigherBarrier() {
        return higherBarrier;
    }

    public void setHigherBarrier(double higherBarrier) {
        this.higherBarrier = higherBarrier;
    }

    public double getAccuracy() {
        return ACCURACY;
    }

    double halfInt() {
        double half = (lowerBarrier + higherBarrier) / 2;

        while (Math.abs(f(half)) > ACCURACY) {
            counter++;
            if (f(lowerBarrier) * f(half) < 0) {
                higherBarrier = half;
            }
            else {
                lowerBarrier = half;
            }
            half = (lowerBarrier + higherBarrier) / 2;

            System.out.println(half);
        }

        System.out.println("Answer: " + half);
        System.out.println("Precision: " + ACCURACY);
        System.out.println("It took " + counter + " iterations!");
        return half;
    }

    public static void main(String[] args) {
        IntervalHalving sm = new IntervalHalving(-10, 10000, 0.00001);

        sm.halfInt();
    }
}
