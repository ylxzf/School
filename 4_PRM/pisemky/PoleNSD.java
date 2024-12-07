package pisemky;

import java.util.Arrays;

public class PoleNSD {

    private final int[] inputArray;

    public PoleNSD(int[] input) {
        inputArray = input;
    }

    public int[] getInputArray() {
        return inputArray;
    }

    public int GCD(int num1, int num2) {
        if (num2 != 0) {
            return GCD(num2, num1 % num2);
        }
        else {
            return num1;
        }
    }

    public int arrayGCD() {
        int finalNSD = inputArray[0];
        for (int e: inputArray) {
            finalNSD = GCD(finalNSD, e);
        }
        return finalNSD;
    }

    public static void main(String[] args) {
        PoleNSD demo = new PoleNSD(new int[]{11968, 6688, 4048, 2552, 43648});
        System.out.println(demo.arrayGCD());
        System.out.printf("NSD%s = %d", Arrays.toString(demo.getInputArray()), demo.arrayGCD());
    }

}
