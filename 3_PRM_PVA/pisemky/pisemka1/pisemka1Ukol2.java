package pisemky.pisemka1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class pisemka1Ukol2 {
    public static void main(String[] args) {
        Random random = new Random();
        int[] randNumbers = new int[100];
        ArrayList<Integer> negativeNumbers = new ArrayList<Integer>();
        ArrayList<Integer> positiveNumbers = new ArrayList<Integer>();
        ArrayList<Integer> orderedNumbers = new ArrayList<Integer>();

        for (int i = 0; i < randNumbers.length; i++) {
            randNumbers[i] = -50 + random.nextInt(173);
        }

        for (int i = 0; i < randNumbers.length; i++) {
            if (randNumbers[i]<0){
                negativeNumbers.add(randNumbers[i]);
            }
            else{
                positiveNumbers.add(randNumbers[i]);
            }
        }

        System.out.println(Arrays.toString(randNumbers));

        orderedNumbers.addAll(negativeNumbers);
        orderedNumbers.addAll(positiveNumbers);

        for (int i:orderedNumbers) {
            System.out.print(i + ", ");
        }
    }
}
