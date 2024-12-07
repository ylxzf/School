package search;

import java.util.Arrays;
import java.util.Random;

class Bisex {
    public static int[] pole = new int[100];

    public static boolean binVyhl(int kaktus) {
        int left = 0;
        int right = pole.length - 1;

        while(left < right){
            int pul = (left + right) / 2;
            if (pole[pul] == kaktus) {
                return true;
            }
            else{
                if (kaktus < pole[pul]){
                    right = pul - 1;
                }
                else {
                    left = pul + 1;
                }
            }
        }

        return false;
    }
    public static void main(String[] args) {
        Random random = new Random();
        pole[0] = -50;

        for (int i = 1; i < pole.length; i++) {
            pole[i] = pole[i-1] + random.nextInt(5)+1;
        }

//        System.out.println(Arrays.toString(pole));

        for (int i = 0; i < pole.length; i++) {
            if (i==0) {
                System.out.printf("%3d, ", pole[i]);
            }
            else {
                if (i % 20 ==  0){
                    System.out.println();
                }
                System.out.printf("%3d, ", pole[i]);
            }
        }

        System.out.println();
        System.out.println();
        System.out.println(binVyhl(13));
        System.out.println("maximalni pocet kroku : " + (int) logB(pole.length, 2));
    }

    public static double logB(double number, double custom_base) {
        double result = (int) (Math.log(number) / Math.log(custom_base));
        return result + 1;
    }
}
