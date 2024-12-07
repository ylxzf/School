package search;

import java.util.Arrays;
import java.util.Random;

class Search1 {
    public static void main(String[] args) {
        Random random = new Random();
        int number = 13;
        int[] array = new int[100];

        for (int i = 0; i < array.length; i++) {
            array[i] = -500 + random.nextInt(1001);
        }

        int i = 0;
        while(i<array.length && array[i]!=number){
//            if (i%10==0&&i!=0){
//                System.out.println();
//            }
//            System.out.print(array[i]+", ");
            i++;
        }

        System.out.println(Arrays.toString(array));

        System.out.println(i<array.length);
/*
        boolean numberSearch = false;
            int i = 0;
            while(i+1<array.length && array[i]!=13){
                System.out.print(array[i]+", ");
                i++;
                if(array[i]==13){
                    numberSearch=true;
                    System.out.print(array[i]);
                    System.out.println();
                    System.out.println(numberSearch);
                    return;
                }
            }
*/

//        int i = 0;
//            while(i<array.length && array[i]!=number){
//                if (i%10==0&&i!=0){
//                    System.out.println();
//                }
//                System.out.print(array[i]+", ");
//                i++;
//            }
//            if (i<array.length){
//                System.out.print(array[i]+", ");
//                System.out.println();
//                System.out.println();
//                System.out.println("includes "+number+" at "+ i);
//            } else{
//                System.out.println();
//                System.out.println();
//                System.out.println(number+" isn't included");
//            }

/*
        for (int i = 0; i < array.length; i++) {
            if (i%10==0){
                System.out.println();
            }
            System.out.print(array[i]+", ");
        }
*/
    }
}
