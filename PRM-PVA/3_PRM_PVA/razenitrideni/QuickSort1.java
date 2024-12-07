package razenitrideni;

import java.util.Random;

public class QuickSort1 {
    public static void main(String[] args) {
        Random random = new Random();
        int[] pole = new int[10];

        for (int i = 0; i < pole.length; i++) {
            pole[i] = random.nextInt(100);
        }

        System.out.println("--------------------------------------------------------------------");
        System.out.println();

        for (int e: pole) {
            System.out.print(e + ", ");
        }

        System.out.println();
        System.out.println();
        System.out.println("--------------------------------------------------------------------");
        System.out.println();
    }
}
