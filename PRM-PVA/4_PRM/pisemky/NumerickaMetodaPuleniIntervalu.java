package pisemky;

public class NumerickaMetodaPuleniIntervalu {

    int counter = 0;

    double lowerBarrier;
    double higherBarrier;
    final double ACCURACY;
    final int dayOfBirth;

    public NumerickaMetodaPuleniIntervalu(double a, double b, double c, int dayOfBirth) {
        lowerBarrier = a;
        higherBarrier = b;
        ACCURACY = c;
        this.dayOfBirth = dayOfBirth;
    }

//        Vstupní funkce
    double f(double x) {
        return Math.pow(2, x) - dayOfBirth;
    }

//    Vypocitani korene
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

        System.out.println("Vysledek: " + half);
        System.out.println("EPSILON: " + ACCURACY);
        System.out.println(counter + " iteraci");
        return half;
    }

    public static void main(String[] args) {
//        6. 10. 2005 - Ondřej Vondra
//        Pouzil jsem metodu puleni intervalu, protoze je jednoducha a nepotrebuji znat derivaci funkce
        int denNarozeni = 6;

//        dolni hranice je 0 protoze den narozeni neni zaporny
        double dolniHranice = 0;

//        horni hranice je 5 protoze 2^5 je 32 a mesic ma maximalne 31 dni
        double horniHranice = 5;

        NumerickaMetodaPuleniIntervalu demo = new NumerickaMetodaPuleniIntervalu(dolniHranice, horniHranice, 0.00001, denNarozeni);
        demo.halfInt();
    }
}
