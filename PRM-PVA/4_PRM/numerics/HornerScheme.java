package numerics;

import java.util.StringJoiner;

public class HornerScheme {
    int[] polynomial;
    int x;

    public HornerScheme(int[] input, int x) {
        polynomial = input;
        this.x = x;
    }

    public int calculation() {
        int temp = 0;

        temp = polynomial[polynomial.length - 1];

        for (int i = polynomial.length-1; i >- 1 ; i--) {
            temp = x * temp + polynomial[i];
        }

        return temp;
    }

    public void showCalculationResult() {
        System.out.printf("f(%d) = %d", x, calculation());
    }

    public void showPolynomial() {
        StringJoiner polynomialString = new StringJoiner(" ");

        for (int i = polynomial.length-1; i >-1; i--) {
            if (i == polynomial.length-1 & polynomial[i] != 0) {
                String temp = polynomial[i] + "x^" + i;
                polynomialString.add(temp);
            } else if (polynomial[i] != 0 & polynomial[i] > 0 & i == 0) {
                String temp = "+ " + Math.abs(polynomial[i]);
                polynomialString.add(temp);
            } else if (polynomial[i] != 0 & polynomial[i] < 0 & i == 0) {
                String temp = "- " + Math.abs(polynomial[i]);
                polynomialString.add(temp);
            } else if (polynomial[i] != 0 & polynomial[i] > 0) {
                String temp = "+ " + polynomial[i] + "x^" + i;
                polynomialString.add(temp);
            } else if (polynomial[i] != 0 & polynomial[i] < 0) {
                String temp = "- " + Math.abs(polynomial[i])  + "x^" + i;
                polynomialString.add(temp);
            }

        }
        System.out.println("f(x) = " + polynomialString.toString());
    }

    public int[] getPolynomial() {
        return polynomial;
    }

    public void setPolynomial(int[] polynomial) {
        this.polynomial = polynomial;
    }
}
