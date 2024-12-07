package numerics;

import java.util.*;
import java.util.stream.Collectors;

public class NewtonSecantMethod {
    private final double ACCURACY;
    private final double x0;
    private int counter = 0;

    public NewtonSecantMethod(double x0, double accuracy) {
        this.x0 = x0;
        this.ACCURACY = accuracy;
    }

    public double getACCURACY() {
        return ACCURACY;
    }

    public double getX0() {
        return x0;
    }

    public int getCounter() {
        return counter;
    }

    //    function f
    public double f(double x) {
        return x + Math.cos(x);
    }

    //    derivative of function f
    public double df(double x) {
        return 1 - Math.sin(x);
    }

    public void newtonSecant() {
        double xn = x0;

        while (Math.abs(f(xn)) > ACCURACY) {
            xn = xn - (f(xn) / df(xn));
            counter++;
        }

        System.out.println("Answer: " + xn);
        System.out.println("Precision: " + ACCURACY);
        System.out.println("It took " + counter + " iterations!");
    }

    public void newtonSecantWriteOut() {
        double xn = x0;

        System.out.printf("x0 = %f\n", x0);
        while (Math.abs(f(xn)) > ACCURACY) {
            xn = xn - (f(xn) / df(xn));
            counter++;
            System.out.printf("x%d = %f\n", counter, xn);
        }
    }

    public void newtonSecantIterationTest() {

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        double xn;
        int iterationNum = 1000000;
        for (int i = iterationNum * -1; i < iterationNum + 1; i++) {
            xn = i;
            counter = 0;

            while (Math.abs(f(xn)) > ACCURACY) {
                xn = xn - (f(xn) / df(xn));
                counter++;
            }

            map.put(i, counter);
        }

//        LinkedHashMap<Integer, Integer> sortedMap = map.entrySet()
//                .stream()
//                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
//                .collect(Collectors.toMap(
//                        Map.Entry::getKey,
//                        Map.Entry::getValue,
//                        (e1, e2) -> e1,
//                        LinkedHashMap::new
//                ));
//
//        for (Map.Entry<Integer, Integer> entry : sortedMap.entrySet()) {
//            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
//        }

        ArrayList<Map.Entry<Integer, Integer>> sortedEntries = new ArrayList<>(map.entrySet());
        sortedEntries.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue())); // Sort in descending order

        // Step 2: Get the first entry in the sorted list
        if (!sortedEntries.isEmpty()) {
            Map.Entry<Integer, Integer> firstEntry = sortedEntries.get(0);
            System.out.println("x0: " + firstEntry.getKey() + ", Iterations: " + firstEntry.getValue());
        } else {
            System.out.println("The map is empty.");
        }
    }

    public static void main(String[] args) {
        NewtonSecantMethod demo = new NewtonSecantMethod(-692971, 0);

        demo.newtonSecant();
//        demo.newtonSecantWriteOut();

//        demo.newtonSecantIterationTest();


    }
}
