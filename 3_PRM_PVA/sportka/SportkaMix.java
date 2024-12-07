package sportka;

import java.util.Arrays;
import java.util.Random;

class SportkaMix {
    public static void main(String[] args) {
        Random random = new Random();
        int[] numbers = new int[50];

        numbers[0] = -1;

        for (int i = 1; i <= 49; i++) {
            numbers[i] = i;
        }

        for (int i = 1; i <= 49 ; i++) {
            int lahev;
            int kamarad = 1 + random.nextInt(49);

            lahev = numbers[i];
            numbers[i] = numbers[kamarad];
            numbers[kamarad] = lahev;
        }

        System.out.println(Arrays.toString(numbers));
    }
}