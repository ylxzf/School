package pisemky.pisemka1;

import java.util.Arrays;
import java.util.Random;

public class pisemka1Ukol2v2 {
    public static void main(String[] args) {
        Random random = new Random();
        int[] randNumbers = new int[100];
        int[] orderedNumbers = new int[100];

        for (int i = 0; i < randNumbers.length; i++) {
            randNumbers[i] = -50 + random.nextInt(173);
        }

        int x = 0;

        for (int i = 0; i < randNumbers.length; i++) {
            if (randNumbers[i] < 0){
                orderedNumbers[x] = randNumbers[i];
                x++;
            }
        }

        for (int i = 0; i < randNumbers.length; i++) {
            if (randNumbers[i] >= 0){
                orderedNumbers[x] = randNumbers[i];
                x++;
            }
        }

        System.out.println(Arrays.toString(randNumbers));
        System.out.println(Arrays.toString(orderedNumbers));
    }
}
