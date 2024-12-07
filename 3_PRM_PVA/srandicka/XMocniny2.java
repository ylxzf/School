package srandicka;

import java.util.Scanner;

class XMocniny2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double x = scanner.nextDouble();
        int n = scanner.nextInt();

        System.out.println(x2n(x, n));
    }

    public static double x2n(double x, int n){
        double tmp = 1;
        
        if(n>0){
            for (int i = 0; i < n; i++) {
                tmp = tmp*x;
            }
            return tmp;
        }
        else{
            return 1/x2n(x, -n);
        }
        
    }
}
