package pisemky.pisemka2;

import java.util.Random;

public class pisemka2Ukol1 {
    public static void main(String[] args) {
        Random random = new Random();

        int x = 0;
        int y;
        int a = 0;

        while (true){
            x++;
            y = random.nextInt(6)+1;
            System.out.println("Attempt: "+x + ", You threw a " + y);

            if (a == 6 && y == 6){
                break;
            }
            a = y;
        }

        System.out.println();
        System.out.println("It took " + x + " attempts to throw 2 sixes in a row");
    }
}
