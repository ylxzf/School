package sportka;

import java.util.Arrays;
import java.util.Random;

class SportkaZarazka {
    public static void main(String[] args) {
        Random random = new Random();
        int[] pole = new int[6];

        for (int i = 0; i < 1; i++) {
            pole[0] = 1 + random.nextInt(49); //prvni

            int j = 1;
            while (j< pole.length){
                pole[j] = 1 + random.nextInt(49);
                //kontrola
                int k = 0;
                while (pole[k] != pole[j]){
                    System.out.println("a " + pole[j] + ", "+ pole[k]);
                    k++;
                    System.out.println("b " + pole[j] + ", "+ pole[k]);
                    System.out.println();
                }

                if (k==j){
                    j++;
                }
            }

            System.out.println(Arrays.toString(pole));
        }
    }
}

