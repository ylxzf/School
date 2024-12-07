package srandicka;

public class fibonacciNumbers {
    public static void main(String[] args) {

        int x = 0;
        int y = 1;
        int n = 50;

        for (int i = 0; i < n; i++) {
            int sum = x + y;
            x = y;
            y = sum;
        }
        System.out.println(x);
    }
}
