package TSP.Me;

import java.util.ArrayList;
import java.util.Arrays;

public class TSP {

    static int[][] values;

    public TSP(int[][] values) {
        this.values = values;
    }

    public static int[][] getGraph() {
        return values;
    }

    public int TSP_program(int beginningPoint) {
        int length = 0;
        boolean[] alreadyVisited = new boolean[values.length];


        int[] tempArr;

        int currentPoint = beginningPoint;

        while (hasEverythingBeenVisited(alreadyVisited)) {
            alreadyVisited[currentPoint] = true;
            System.out.println("aa" + Arrays.toString(findMinValue(values[currentPoint], alreadyVisited)));
            length += findMinValue(values[currentPoint], alreadyVisited)[0];
            currentPoint = findMinValue(values[currentPoint], alreadyVisited)[1];
        }

        return length;
    }

    public boolean hasEverythingBeenVisited(boolean[] alreadyVisited) {
        for (boolean e : alreadyVisited) {
            if (!e) {
                return true;
            }
        }
        return false;
    }

    public int[] findMinValue(int[] values, boolean[] alreadyVisited) {
        int[] minValue = new int[2];

        boolean check = true;

        for (int i = 1; i < values.length; i++) {

            System.out.println(minValue[0] + ", " + minValue[1]);

            if (check) {
                if (values[i] > 0) {
                    minValue[0] = values[i];
                    minValue[1] = i;
                    check = false;
                }
            }
            else {
                if (values[i] < minValue[0] && values[i] != 0) {
                    if (!alreadyVisited[i]) {
                        minValue[0] = values[i];
                        minValue[1] = i;
                    }
                }
            }
        }

        return minValue;
    }
}
