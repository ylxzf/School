package pisemky.pisemka3;

import java.util.Random;

public class Pisemka3Ukol1 {
    public static void main(String[] args) {
        Random random = new Random();
        Random randomIndex = new Random();
        int n = 10;

        int[] pole = new int[n+1];

        for (int i = 0; i < pole.length-1; i++) {
            pole[i] = -500 + random.nextInt(1001);
        }

        pole[n] = 501;
        for (int i = 0; i < pole.length-1; i++) {
            System.out.print(pole[i] + ", ");
        }

        System.out.println();
        int correctNumber = 0;
        int numberOfIterations = 0;

        int x = 0;

        while(true){
            correctNumber = 0;
            for (int i = 0; i < pole.length; i++) {

                if(pole[i]>pole[i+1]){
//                  System.out.println("Not sorted");
                    break;
                }
                else {
//                  System.out.println("Correct");
                    correctNumber++;
                }

                if (correctNumber == 10){
                    for (int j = 0; j < pole.length-1; j++) {
                        System.out.print(pole[j] + ", ");
                    }
                    System.out.println();
                    System.out.println("It took " + numberOfIterations + " iterations to sort this array");
                    return;
                }
            }
            int random1 = randomIndex.nextInt(10);
            int random2 = randomIndex.nextInt(10);
            int temp = pole[random1];
//            System.out.println(temp);
            pole[random1] = pole[random2];
            pole[random2] = temp;
//            System.out.println(Arrays.toString(pole));
            numberOfIterations++;
        }
    }
}
