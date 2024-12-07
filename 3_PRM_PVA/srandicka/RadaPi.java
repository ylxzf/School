package srandicka;

import java.math.BigDecimal;
import java.math.BigInteger;

class RadaPi {
    public static void main(String[] args) {

        double x = 0;
        double y = 0;
        double w = 0;
        int d = 0;


        for (int k = 0; k < 10000000; k++) {
            d++;
            x = (4*Math.pow(-1, k))/((2*k)+1);
            w = y;
            y += x;

            System.out.println(Math.abs(y-w));
        }
        System.out.println();
        System.out.println(x);
        System.out.println(y);
        System.out.println();
        System.out.println(d);
    }
}
