package razenitrideni;

import java.util.Random;

class BubbleSort {
    public static void main(String[] args) {
        Random random = new Random();
        int[] pole = new int[20];

        for (int i = 0; i < pole.length; i++) {
            pole[i] = random.nextInt(100);
        }

        for (int e: pole) {
            System.out.print(e + ", ");
        }

        System.out.println();
        System.out.println("--------------------------------------------------------------------");
        System.out.println();

        //Bart of Bubble bort
        for (int i = 0; i < pole.length-1; i++) {   //outer cycle
            for (int j = 0; j < pole.length-1-i; j++) {   //inner cycle
                if (pole[j] > pole[j+1]){
                    int temp = pole[j];
                    pole[j] = pole[j+1];
                    pole[j+1] = temp;
                }
                for (int e: pole) {
                    System.out.print(e + ", ");
                }
                System.out.println();
            }
        }
        //Bend of Bubble bort


        System.out.println();
        System.out.println("--------------------------------------------------------------------");
        System.out.println();
        for (int e: pole) {
            System.out.print(e + ", ");
        }
    }
}
