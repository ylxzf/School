package razenitrideni;

import java.util.Random;

public class InsertionSort {
    public static void main(String[] args){
        Random random = new Random();
        int[] array = new int[20];

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }

        System.out.println();

        for (int e: array) {
            System.out.print(e + ", ");
        }

        System.out.println();
        System.out.println();
        System.out.println("--------------------------------------------------------------------");
        System.out.println();

        //start of insertion sort
        for (int i = 0; i < array.length - 1; i++) {
            int j = i + 1;
            int tmp = array[j];
            while (j > 0 && tmp < array[j-1]) {
                array[j] = array[j-1];
                j--;
            }
            array[j] = tmp;
        }
        //end of insertion sort

        for (int e: array) {
            System.out.print(e + ", ");
        }
    }
}
