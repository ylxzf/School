package pisemky.pisemka2;

import java.util.Random;

public class pisemka2Ukol2 {
    public static void main(String[] args) {
        Random random = new Random();

        int a;
        int b;
        int c;

        int[] numbersThrown = new int[16];

        int x;

        for (int i = 0; i < 1000; i++) {
            a = random.nextInt(6)+1;
            b = random.nextInt(6)+1;
            c = random.nextInt(6)+1;
            x = a+b+c;

            numbersThrown[x-3]++;

            System.out.println("Dice 1: " + a + ", Dice 2: "+ b + ", Dice 3: " + c + ", Total: " + x);
        }

        System.out.println();

        for (int i = 0; i < 16; i++) {
            int n = i+3;
            System.out.println("You threw a " + n + " this amount of times: " + numbersThrown[i]);
        }
    }
}
