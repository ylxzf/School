package pisemky;

public class NumerickaMetodaNewton {
    private final double ACCURACY;
    private final double x0;
    private final int dayOfBirth;

    // konstruktor
    public NumerickaMetodaNewton(double x0, double accuracy, int dayOfBirth) {
        this.x0 = x0;
        this.ACCURACY = accuracy;
        this.dayOfBirth = dayOfBirth;
    }

    public double getACCURACY() {
        return ACCURACY;
    }

    public double getX0() {
        return x0;
    }

    //    funkce f => 2^x - 6 = 0
    public double f(double x) {
        return Math.pow(2, x) - dayOfBirth;
    }

    //    derivace funkce f => 2^x * ln(2)
    public double df(double x) {
        return Math.pow(2, x) * Math.log(2);
    }


//    Vypocet korene
    public void newtonSecant() {
        double xn = x0;

        while (Math.abs(f(xn)) > ACCURACY) {
            xn = xn - (f(xn) / df(xn));
        }

        System.out.println("Answer: " + xn);
        System.out.println("Precision: " + ACCURACY);
    }

    public static void main(String[] args) {
//        6. 10. 2005 - Ondřej Vondra
        int denNarozeni = 6;

//        x0 je 2.5 protoze vysledek bude mezi 1 a 5
        double x0 = 2.5;

        NumerickaMetodaNewton demo = new NumerickaMetodaNewton(x0, 0.00001, denNarozeni);
        demo.newtonSecant();
    }
}
