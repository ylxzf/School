package pisemky.pisemka1;

import java.util.Arrays;
import java.util.Random;

public class pisemka1Ukol1 {
    public static void main(String[] args) {
        Random random = new Random();

        int[] numbers = new int[6];

        int x = 0;
        while(true){
            numbers[0] = 1 + random.nextInt(49);
            int p = 0;
            int j = 1;
            while (j< numbers.length){
                numbers[j] = 1 + random.nextInt(49);
                int k = 0;
                while (numbers[k] != numbers[j]){
                    k++;
                }

                if (k==j){
                    j++;
                }
            }

//            System.out.println(Arrays.toString(numbers));
//            System.out.println();

//            for (int a : numbers) {
//                if (a == 13){
//                    p++;
//                }
//                if (a == 19){
//                    p++;
//                }
//                if (a == 21){
//                    p++;
//                }
//                if (a == 48){
//                    p++;
//                }
//                if (a == 49){
//                    p++;
//                }
//                if (a == 1){
//                    p++;
//                }
//            }

            if (numbers[0] == 1){
                p++;
            }
            if (numbers[1] == 2){
                p++;
            }
            if (numbers[2] == 3){
                p++;
            }
            if (numbers[3] == 4){
                p++;
            }
            if (numbers[4] == 5){
                p++;
            }
            if (numbers[5] == 6){
                p++;
            }

            x++;
            if (p==6){
                System.out.println(Arrays.toString(numbers));
                System.out.println(x + " tries");
                return;
            }
        }



//        boolean foundAll = List.of(numbers).contains(wantedNumbers);
//        System.out.println(foundAll);
    }
}
