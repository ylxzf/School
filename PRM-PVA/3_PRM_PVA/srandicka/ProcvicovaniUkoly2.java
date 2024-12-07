package srandicka;

import java.util.Arrays;
import java.util.Random;

class ProcvicovaniUkoly2 {
    public static void main(String[] args) {
        Random random = new Random();

        int[] randomNumbers = new int[3000];

        int streak = 1;
        int hundredStreak = 0;
        int x = 0;

        while(hundredStreak == 0){
            for (int i = 0; i < randomNumbers.length; i++) {
                randomNumbers[i] = -50 + random.nextInt(1051);
            }
            System.out.println(Arrays.toString(randomNumbers));

            for (int i = 0; i < randomNumbers.length; i++) {
                if (randomNumbers[i] >= 0){
                    streak++;
                }
                else{
                    if (streak == 100){
                        System.out.println();
                        System.out.println(streak);
                        hundredStreak++;
                    }
                    streak = 1;
                }
            }

            x++;
        }

        System.out.println();
        System.out.println("The program needed to be ran " + x + " times to find a streak of a 100 positive numbers");
        System.out.println(hundredStreak>0);
        System.out.println("Amount of 100 streaks: " + hundredStreak);
    }
}
