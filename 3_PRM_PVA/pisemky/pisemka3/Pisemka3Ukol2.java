package pisemky.pisemka3;

import java.util.Random;

public class Pisemka3Ukol2 {
    public static int[] poleInt = new int[100];
    public static double[] poleDouble = new double[100];

    public static void main(String[] args) {
        Random random = new Random();


        for (int i = 0; i < poleInt.length; i++) {
            poleInt[i] = -500 + random.nextInt(1001);
        }

        for (int i = 0; i < poleInt.length; i++) {
            poleDouble[i] = (double)poleInt[i];
        }


        for (int e: poleInt) {
            System.out.print(e + ", ");
        }

        System.out.println();
        System.out.println();
        System.out.println("--------------------------------------------------------------------");
        System.out.println();

        for (int i = 0; i < poleDouble.length-1; i++) {
            for (int j = 0; j < poleDouble.length-1-i; j++) {
                if (Math.abs(poleDouble[j]) > Math.abs(poleDouble[j+1])){
                    double temp = poleDouble[j];
                    poleDouble[j] = poleDouble[j+1];
                    poleDouble[j+1] = temp;
                }
            }
        }

        for (int i = 0; i < poleInt.length; i++) {
            poleInt[i] = (int)poleDouble[i];
        }

        for (int e: poleInt) {
            System.out.print(e + ", ");
        }

    }
}
