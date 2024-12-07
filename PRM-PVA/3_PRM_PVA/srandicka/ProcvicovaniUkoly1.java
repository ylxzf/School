package srandicka;

import java.util.Arrays;
import java.util.Random;

class ProcvicovaniUkoly1 {
    public static void main(String[] args) {
        Random random = new Random();

        int[] randomNumbers = new int[1000];

        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = -50 + random.nextInt(1051);
        }

        System.out.println(Arrays.toString(randomNumbers));
        int positiveStreak = 0;
        int positiveStreakHighest = 0;
        int positiveStreakHighestIndex = 0;

        for (int i = 0; i < randomNumbers.length; i++) {

            if (i == randomNumbers.length-1) {
                if (positiveStreakHighest == 0){
                    positiveStreakHighest = positiveStreak;
                    positiveStreakHighestIndex = i;
                }
            }
            if (randomNumbers[i] > -1) {
                    positiveStreak++;
            }
            else {
                if (positiveStreak>positiveStreakHighest){
                    positiveStreakHighest = positiveStreak;
                    positiveStreakHighestIndex = i;
                }
                positiveStreak = 0;
            }
        }
        int startingIndex = positiveStreakHighestIndex - positiveStreakHighest+1;

        System.out.println("Highest streak of positive numbers achieved: " + positiveStreakHighest);
        System.out.println("It begins at index: " + startingIndex);
    }
}
