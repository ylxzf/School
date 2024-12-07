package razenitrideni;

import java.util.Random;

class SelectSort {
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

        for (int i = 0; i < pole.length - 1; i++) {   //outer cycle
            int kdeMin = i;
            for (int j = i+1; j < pole.length; j++) {   //inner cycle
                if (pole[kdeMin] > pole[j]){
                    kdeMin = j;
                }
            }
            if (kdeMin != i){
                int temp = pole[kdeMin];
                pole[kdeMin] = pole[i];
                pole[i] = temp;
            }
            for (int e: pole) {
                System.out.print(e + ", ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("--------------------------------------------------------------------");
        System.out.println();
        for (int e: pole) {
            System.out.print(e + ", ");
        }
        System.out.println();
        System.out.println();
        System.out.println("--------------------------------------------------------------------");
    }
}
