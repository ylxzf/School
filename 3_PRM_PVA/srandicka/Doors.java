package srandicka;

import java.util.Arrays;

public class Doors {
    public static void main(String[] args) {
        int[] doors = new int[100];

        int x = 1;

        while(x!=101){
                for (int i = 0; i < 100; i=i+x){
                    if (doors[i] == 0){
                        doors[i] = 1;
                    } else if (doors[i] == 1) {
                        doors[i] = 0;
                    }
                }

            System.out.println(Arrays.toString(doors));
            System.out.println(x);
            System.out.println();
            x++;

        }
    }
}
