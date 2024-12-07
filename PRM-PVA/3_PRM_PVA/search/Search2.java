package search;

import java.util.Arrays;
import java.util.Random;

class Search2 {
    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[100 + 1]; // +1 = zarazka
        int number = 13;

        for (int i = 0; i < array.length - 2; i++) {
            array[i] = -50 + random.nextInt(101);
        }

        System.out.println(Arrays.toString(array));

        array[array.length-1] = number;

        int i = 0;
        while (array[i] != array[array.length-1]){
           i++;
        }
        if(i< array.length-1){
            System.out.println(array[array.length-1]+" is there at "+ i);
        }
        else {
            System.out.println(array[array.length-1]+" isn't there");
        }

    }
}
